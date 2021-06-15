package chess.board;

import chess.match.A1Notation;
import chess.match.Perspective;
import chess.piece.Piece;
import chess.piece.black.BlackPiece;
import chess.piece.white.WhitePiece;

public interface Board {
    void resetBoard();

    boolean canMove(A1Notation piecePosition, A1Notation newPosition);

    boolean move(A1Notation piecePosition, A1Notation moveTo);

    boolean isStaleMate();

    boolean willThereBeCheckIfMoves(A1Notation position, A1Notation newPosition);

    Piece getPieceAt(A1Notation position);

    boolean isThreatenedByBlack(A1Notation position);

    boolean isThreatenedByWhite(A1Notation position);

    A1Notation getBlacksKingPosition();

    A1Notation getWhitesKingPosition();

    boolean isEmpty(A1Notation current);

    boolean isOccupiedByBlackPiece(A1Notation position);

    void putBlackPiece(A1Notation position, BlackPiece piece);

    void putWhitePiece(A1Notation position, WhitePiece piece);

    boolean isOccupiedByWhitePiece(A1Notation position);

    boolean isWhiteChecked();

    boolean isBlackedChecked();

    default boolean isChecked(boolean isWhite) {
        return isWhite
                ? isWhiteChecked()
                : isBlackedChecked();
    }

    boolean isCheckMate();

    void putBlackPawn(A1Notation position);

    void putBlackQueen(A1Notation position);

    void putBlackBishop(A1Notation position);

    void putBlackKnight(A1Notation position);

    void putBlackRook(A1Notation position);

    void putBlackKing(A1Notation position);

    void putWhitePawn(A1Notation position);

    void putWhiteQueen(A1Notation position);

    void putWhiteBishop(A1Notation position);

    void putWhiteKnight(A1Notation position);

    void putWhiteRook(A1Notation position);

    void putWhiteKing(A1Notation position);

    Piece[][] getBoard(Perspective perspective);

}
