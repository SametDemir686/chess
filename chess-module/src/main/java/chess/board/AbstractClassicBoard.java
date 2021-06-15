package chess.board;

import chess.match.A1Notation;
import chess.match.Perspective;
import chess.piece.NullPiece;
import chess.piece.Piece;
import chess.piece.black.*;
import chess.piece.white.*;
import chess.player.BlackPlayer;
import chess.player.Player;
import chess.player.WhitePlayer;

public abstract class AbstractClassicBoard implements Board {
    public static final int BOARD_SIZE = 8;
    protected boolean whitesTurn = true;
    protected Player<WhitePiece> whitePlayer = new WhitePlayer();
    protected Player<BlackPiece> blackPlayer = new BlackPlayer();

    @Override
    public Piece[][] getBoard(Perspective perspective) {
        A1Notation[][] positions = perspective.getPositions();
        Piece[][] result = new Piece[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions[i].length; j++) {
                result[i][j] = getPieceAt(positions[i][j]).copy();
            }
        }
        return result;
    }

    @Override
    public Piece getPieceAt(A1Notation position) {
        return whitePlayer.hasPieceAt(position)
                ? whitePlayer.getPieceAt(position)
                : blackPlayer.getPieceAt(position);
    }

    @Override
    public boolean move(A1Notation piecePosition, A1Notation moveTo) {
        if (canMove(piecePosition, moveTo)) {
            whitesTurn = !whitesTurn;
            movePiece(piecePosition, moveTo);
            return true;
        }
        return false;
    }

    public void removeAllPieces() {
        whitePlayer.removeAllPieces();
        blackPlayer.removeAllPieces();
    }

    protected void put(A1Notation position, Piece piece) {
        piece.setPosition(position);
        piece.setBoard(this);
    }

    public Piece remove(A1Notation position) {
        Piece pieceToBeRemoved = getPieceAt(position);
        put(position, new NullPiece());
        return pieceToBeRemoved;
    }

    @Override
    public void putBlackPiece(A1Notation position, BlackPiece piece) {
        put(position, piece);
        blackPlayer.add(position, piece);
    }

    @Override
    public void putWhitePiece(A1Notation position, WhitePiece piece) {
        put(position, piece);
        whitePlayer.add(position, piece);
    }

    public boolean isOccupiedByWhitePiece(A1Notation position) {
        return getPieceAt(position).isWhite();
    }

    public boolean isOccupiedByBlackPiece(A1Notation position) {
        return getPieceAt(position).isBlack();
    }

    protected void movePiece(A1Notation piecePosition, A1Notation moveTo) {
        Piece movingPiece = remove(piecePosition);
        Piece capturedPiece = remove(moveTo);
        capturedPiece.captured();
        put(moveTo, movingPiece);
        movingPiece.move();
    }

    @Override
    public A1Notation getBlacksKingPosition() {
        return blackPlayer.getKingsPosition();
    }

    @Override
    public A1Notation getWhitesKingPosition() {
        return whitePlayer.getKingsPosition();
    }

    public boolean isEmpty(A1Notation position) {
        return getPieceAt(position) instanceof NullPiece;
    }

    public boolean isNotEmpty(A1Notation position) {
        return !isEmpty(position);
    }

    public boolean isThreatenedByBlack(A1Notation position) {
        return blackPlayer.getAllActivePieces().stream().anyMatch(piece -> piece.threatens(position));
    }

    public boolean isThreatenedByWhite(A1Notation position) {
        return whitePlayer.getAllActivePieces().stream().anyMatch(piece -> piece.threatens(position));
    }

    @Override
    public boolean isWhiteChecked() {
        A1Notation whitesKingPosition = getWhitesKingPosition();
        return blackPlayer.getAllActivePieces().stream()
                .anyMatch(piece -> piece.threatens(whitesKingPosition));
    }

    @Override
    public boolean isBlackedChecked() {
        A1Notation blacksKingPosition = getBlacksKingPosition();
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
    public boolean willThereBeCheckIfMoves(A1Notation from, A1Notation to) {
        if (from == null || to == null) return false;
        if (isEmpty(from)) return false;
        HelperBoard helperBoard = new HelperBoard(whitePlayer, blackPlayer);
        helperBoard.move(from, to);
        return helperBoard.isChecked(whitesTurn);
    }

    @Override
    public void putBlackPawn(A1Notation position) {
        putBlackPiece(position, new BlackPawn());
    }

    @Override
    public void putBlackQueen(A1Notation position) {
        putBlackPiece(position, new BlackQueen());
    }

    @Override
    public void putBlackBishop(A1Notation position) {
        putBlackPiece(position, new BlackBishop());
    }

    @Override
    public void putBlackKnight(A1Notation position) {
        putBlackPiece(position, new BlackKnight());
    }

    @Override
    public void putBlackRook(A1Notation position) {
        putBlackPiece(position, new BlackRook());
    }

    @Override
    public void putBlackKing(A1Notation position) {
        putBlackPiece(position, new BlackKing());
    }

    @Override
    public void putWhitePawn(A1Notation position) {
        putWhitePiece(position, new WhitePawn());
    }

    @Override
    public void putWhiteQueen(A1Notation position) {
        putWhitePiece(position, new WhiteQueen());
    }

    @Override
    public void putWhiteBishop(A1Notation position) {
        putWhitePiece(position, new WhiteBishop());
    }

    @Override
    public void putWhiteKnight(A1Notation position) {
        putWhitePiece(position, new WhiteKnight());
    }

    @Override
    public void putWhiteRook(A1Notation position) {
        putWhitePiece(position, new WhiteRook());
    }

    @Override
    public void putWhiteKing(A1Notation position) {
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
