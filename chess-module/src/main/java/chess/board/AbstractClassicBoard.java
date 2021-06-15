package chess.board;

import chess.match.A1Notation;
import chess.piece.NullPiece;
import chess.piece.Piece;
import chess.piece.PieceDTO;
import chess.piece.black.*;
import chess.piece.white.*;
import chess.player.BlackPlayer;
import chess.player.Player;
import chess.player.WhitePlayer;

import static chess.match.A1Notation.*;

public abstract class AbstractClassicBoard implements Board {
    public static final int BOARD_SIZE = 8;
    protected boolean whitesTurn = true;
    protected Player<WhitePiece> whitePlayer = new WhitePlayer();
    protected Player<BlackPiece> blackPlayer = new BlackPlayer();

    private static A1Notation[][] whitesPerspective = new A1Notation[][]{
            {A8, B8, C8, D8, E8, F8, G8, H8},
            {A7, B7, C7, D7, E7, F7, G7, H7},
            {A6, B6, C6, D6, E6, F6, G6, H6},
            {A5, B5, C5, D5, E5, F5, G5, H5},
            {A4, B4, C4, D4, E4, F4, G4, H4},
            {A3, B3, C3, D3, E3, F3, G3, H3},
            {A2, B2, C2, D2, E2, F2, G2, H2},
            {A1, B1, C1, D1, E1, F1, G1, H1},
    };

    private static A1Notation[][] blacksPerspective = new A1Notation[][]{
            {H1, G1, F1, E1, D1, C1, B1, A1},
            {H2, G2, F2, E2, D2, C2, B2, A2},
            {H3, G3, F3, E3, D3, C3, B3, A3},
            {H4, G4, F4, E4, D4, C4, B4, A4},
            {H5, G5, F5, E5, D5, C5, B5, A5},
            {H6, G6, F6, E6, D6, C6, B6, A6},
            {H7, G7, F7, E7, D7, C7, B7, A7},
            {H8, G8, F8, E8, D8, C8, B8, A8},
    };

    public PieceDTO[][] getBoardDTO() {
        PieceDTO[][] result = new PieceDTO[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < whitesPerspective.length; i++) {
            for (int j = 0; j < whitesPerspective[i].length; j++) {
                result[i][j] = new PieceDTO(getPieceAt(whitesPerspective[i][j]));
            }
        }
        return result;
    }

    public Piece getPieceAt(A1Notation position) {
        return whitePlayer.hasPieceAt(position)
                ? whitePlayer.getPieceAt(position)
                : blackPlayer.getPieceAt(position);
    }

    public Piece[][] getBoard() {
        Piece[][] result = new Piece[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < whitesPerspective.length; i++) {
            for (int j = 0; j < whitesPerspective[i].length; j++) {
                result[i][j] = getPieceAt(whitesPerspective[i][j]).copy();
            }
        }
        return result;
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

    public A1Notation getKingsPosition(boolean isWhite) {
        if (isWhite) return getWhitesKingPosition();
        else return getBlacksKingPosition();
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
        for (Piece[] pieces : getBoard()) {
            for (Piece piece : pieces) {
                result.append(piece).append('\t');
            }
            result.append("\n");
        }
        return result.toString();
    }
}
