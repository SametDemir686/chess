package chess.board;

import chess.move.InvalidMove;
import chess.move.Move;
import chess.notations.Perspective;
import chess.notations.Position;
import chess.piece.King;
import chess.piece.NullPiece;
import chess.piece.Piece;
import chess.piece.black.*;
import chess.piece.white.*;
import chess.player.BlackPlayer;
import chess.player.Player;
import chess.player.WhitePlayer;

import static chess.notations.Position.*;

public abstract class AbstractClassicBoard implements Board {
    public static final int BOARD_SIZE = 8;
    protected boolean whitesTurn = true;
    protected Player<WhitePiece> whitePlayer = new WhitePlayer();
    protected Player<BlackPiece> blackPlayer = new BlackPlayer();

    @Override
    public Piece[][] getBoard(Perspective perspective) {
        Position[][] positions = perspective.getPositions();
        Piece[][] result = new Piece[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions[i].length; j++) {
                result[i][j] = getPieceAt(positions[i][j]).copy();
            }
        }
        return result;
    }

    @Override
    public boolean canBlackLongCastle() {
        if (isBlackedChecked()) return false;
        if (isThreatenedByWhite(C8) || isThreatenedByWhite(D8)) return false;
        if (isNotEmpty(B8) || isNotEmpty(C8) || isNotEmpty(D8)) return false;
        return blackPlayer.canLongCastle();
    }

    @Override
    public boolean canWhiteLongCastle() {
        if (isWhiteChecked()) return false;
        if (isThreatenedByBlack(C1) || isThreatenedByBlack(D1)) return false;
        if (isNotEmpty(B1) || isNotEmpty(C1) || isNotEmpty(D1)) return false;
        return whitePlayer.canLongCastle();
    }

    @Override
    public boolean canBlackShortCastle() {
        if (isBlackedChecked()) return false;
        if (isThreatenedByWhite(F8) || isThreatenedByWhite(G8)) return false;
        if (isNotEmpty(F8) || isNotEmpty(G8)) return false;
        return blackPlayer.canShortCastle();
    }

    @Override
    public boolean canWhiteShortCastle() {
        if (isWhiteChecked()) return false;
        if (isThreatenedByBlack(F1) || isThreatenedByBlack(G1)) return false;
        if (isNotEmpty(F1) || isNotEmpty(G1)) return false;
        return whitePlayer.canShortCastle();
    }

    @Override
    public Piece getPieceAt(Position position) {
        return whitePlayer.hasPieceAt(position)
                ? whitePlayer.getPieceAt(position)
                : blackPlayer.getPieceAt(position);
    }

    @Override
    public Move move(Position piecePosition, Position moveTo) {
        if (canMove(piecePosition, moveTo)) {
            whitesTurn = !whitesTurn;
            if (isLongCastling(piecePosition, moveTo)) return castleLong(piecePosition);
            if (isShortCastling(piecePosition, moveTo)) return castleShort(piecePosition);
            return movePiece(piecePosition, moveTo);
        }
        return null;
    }

    private Move castleShort(Position piecePosition) {
        if (isOccupiedByWhitePiece(piecePosition)) whitePlayer.castleShort();
        else blackPlayer.castleShort();
        return new InvalidMove();
    }

    private Move castleLong(Position piecePosition) {
        if (isOccupiedByWhitePiece(piecePosition)) whitePlayer.castleLong();
        else blackPlayer.castleLong();
        return new InvalidMove();
    }

    private boolean isLongCastling(Position piecePosition, Position moveTo) {
        Piece piece = getPieceAt(piecePosition);
        if (!(piece instanceof King)) return false;
        King king = (King) piece;
        return king.isLongCastling(moveTo) && king.canLongCastle();
    }

    private boolean isShortCastling(Position piecePosition, Position moveTo) {
        Piece piece = getPieceAt(piecePosition);
        if (!(piece instanceof King)) return false;
        King king = (King) piece;
        return king.isShortCastling(moveTo) && king.canShortCastle();
    }

    public void removeAllPieces() {
        whitePlayer.removeAllPieces();
        blackPlayer.removeAllPieces();
    }

    @Override
    public void putBlackPiece(Position position, BlackPiece piece) {
        piece.setBoard(this);
        blackPlayer.add(position, piece);
    }

    @Override
    public void putWhitePiece(Position position, WhitePiece piece) {
        piece.setBoard(this);
        whitePlayer.add(position, piece);
    }

    public boolean isOccupiedByWhitePiece(Position position) {
        return getPieceAt(position).isWhite();
    }

    public boolean isOccupiedByBlackPiece(Position position) {
        return getPieceAt(position).isBlack();
    }

    protected Move movePiece(Position piecePosition, Position moveTo) {
        Piece movingPiece = getPieceAt(piecePosition);
        Piece capturedPiece = getPieceAt(moveTo);
        capturedPiece.captured();
        movingPiece.move(moveTo);
        return new InvalidMove();
    }

    @Override
    public Position getBlacksKingPosition() {
        return blackPlayer.getKingsPosition();
    }

    @Override
    public Position getWhitesKingPosition() {
        return whitePlayer.getKingsPosition();
    }

    public boolean isEmpty(Position position) {
        return getPieceAt(position) instanceof NullPiece;
    }

    public boolean isNotEmpty(Position position) {
        return !isEmpty(position);
    }

    public boolean isThreatenedByBlack(Position position) {
        return blackPlayer.getAllActivePieces().stream().anyMatch(piece -> piece.threatens(position));
    }

    public boolean isThreatenedByWhite(Position position) {
        return whitePlayer.getAllActivePieces().stream().anyMatch(piece -> piece.threatens(position));
    }

    @Override
    public boolean isWhiteChecked() {
        Position whitesKingPosition = getWhitesKingPosition();
        return blackPlayer.getAllActivePieces().stream()
                .anyMatch(piece -> piece.threatens(whitesKingPosition));
    }

    @Override
    public boolean isBlackedChecked() {
        Position blacksKingPosition = getBlacksKingPosition();
        return whitePlayer.getAllActivePieces().stream()
                .anyMatch(piece -> piece.threatens(blacksKingPosition));
    }

    @Override
    public boolean isCheckMate() {
        return isChecked(whitesTurn)
                && hasNoMoves(whitesTurn);
    }

    @Override
    public boolean isStaleMate() {
        return !isChecked(whitesTurn)
                && hasNoMoves(whitesTurn);
    }

    private boolean hasNoMoves(boolean whitesTurn) {
        if (whitesTurn) return whiteHasNoMoves();
        return blackHasNoMoves();
    }

    private boolean whiteHasNoMoves() {
        return whitePlayer.getAllActivePieces().stream().noneMatch(Piece::canMove);
    }

    private boolean blackHasNoMoves() {
        return blackPlayer.getAllActivePieces().stream().noneMatch(Piece::canMove);
    }

    @Override
    public boolean willThereBeCheckIfMoves(Position from, Position to) {
        if (from == null || to == null) return false;
        if (isEmpty(from)) return false;
        HelperBoard helperBoard = new HelperBoard(whitePlayer, blackPlayer);
        helperBoard.move(from, to);
        return helperBoard.isChecked(whitesTurn);
    }

    @Override
    public void putBlackPawn(Position position) {
        putBlackPiece(position, new BlackPawn());
    }

    @Override
    public void putBlackQueen(Position position) {
        putBlackPiece(position, new BlackQueen());
    }

    @Override
    public void putBlackBishop(Position position) {
        putBlackPiece(position, new BlackBishop());
    }

    @Override
    public void putBlackKnight(Position position) {
        putBlackPiece(position, new BlackKnight());
    }

    @Override
    public void putBlackRook(Position position) {
        putBlackPiece(position, new BlackRook());
    }

    @Override
    public void putBlackKing(Position position) {
        putBlackPiece(position, new BlackKing());
    }

    @Override
    public void putWhitePawn(Position position) {
        putWhitePiece(position, new WhitePawn());
    }

    @Override
    public void putWhiteQueen(Position position) {
        putWhitePiece(position, new WhiteQueen());
    }

    @Override
    public void putWhiteBishop(Position position) {
        putWhitePiece(position, new WhiteBishop());
    }

    @Override
    public void putWhiteKnight(Position position) {
        putWhitePiece(position, new WhiteKnight());
    }

    @Override
    public void putWhiteRook(Position position) {
        putWhitePiece(position, new WhiteRook());
    }

    @Override
    public void putWhiteKing(Position position) {
        putWhitePiece(position, new WhiteKing());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Piece[] pieces : getBoard(Perspective.WHITE)) {
            for (Piece piece : pieces) {
                result.append(piece).append('\t');
            }
            result.append("\n");
        }
        return result.toString();
    }
}
