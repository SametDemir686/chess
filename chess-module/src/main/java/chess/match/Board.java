package chess.match;

import chess.piece.Piece;
import chess.piece.PieceDTO;

public interface Board {
    void initializeBoard();

    void resetBoard();

    boolean canMove(A1Notation piecePosition, A1Notation newPosition);

    boolean move(A1Notation piecePosition, A1Notation moveTo);

    boolean willThereBeCheckIfMoves(A1Notation position, A1Notation newPosition);

    A1Notation getKingsPosition(boolean white);

    String getBoardAsStringByWhitePerspective();

    PieceDTO[][] getBoardByWhitePerspective();

    String getBoardAsStringByBlackPerspective();

    PieceDTO[][] getBoardByBlackPerspective();

    Piece getPieceAt(A1Notation position);

    boolean isThreatenedByBlack(A1Notation position);

    boolean isThreatenedByWhite(A1Notation position);

    boolean isEmpty(A1Notation current);

    boolean isOccupiedByBlackPiece(A1Notation position);

    boolean isOccupiedByWhitePiece(A1Notation position);

    boolean isWhiteChecked();

    boolean isBlackedChecked();

    default boolean isChecked(boolean isWhite) {
        return isWhite
                ? isWhiteChecked()
                : isBlackedChecked();
    }
}
