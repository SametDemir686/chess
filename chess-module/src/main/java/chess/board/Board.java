package chess.board;

import chess.move.Move;
import chess.notations.Perspective;
import chess.notations.Position;
import chess.piece.Piece;
import chess.piece.black.BlackPiece;
import chess.piece.white.WhitePiece;

public interface Board {
    void resetBoard();

    boolean canMove(Position piecePosition, Position newPosition);

    Move move(Position piecePosition, Position moveTo);

    boolean isStaleMate();

    boolean willThereBeCheckIfMoves(Position position, Position newPosition);

    Piece getPieceAt(Position position);

    boolean isThreatenedByBlack(Position position);

    boolean isThreatenedByWhite(Position position);

    Position getBlacksKingPosition();

    Position getWhitesKingPosition();

    boolean isEmpty(Position current);

    boolean isOccupiedByBlackPiece(Position position);

    void putBlackPiece(Position position, BlackPiece piece);

    void putWhitePiece(Position position, WhitePiece piece);

    boolean isOccupiedByWhitePiece(Position position);

    boolean isWhiteChecked();

    boolean isBlackedChecked();

    default boolean isChecked(boolean isWhite) {
        return isWhite
                ? isWhiteChecked()
                : isBlackedChecked();
    }

    boolean isCheckMate();

    void putBlackPawn(Position position);

    void putBlackQueen(Position position);

    void putBlackBishop(Position position);

    void putBlackKnight(Position position);

    void putBlackRook(Position position);

    void putBlackKing(Position position);

    void putWhitePawn(Position position);

    void putWhiteQueen(Position position);

    void putWhiteBishop(Position position);

    void putWhiteKnight(Position position);

    void putWhiteRook(Position position);

    void putWhiteKing(Position position);

    Piece[][] getBoard(Perspective perspective);

    boolean canBlackLongCastle();

    boolean canWhiteLongCastle();

    boolean canBlackShortCastle();

    boolean canWhiteShortCastle();
}
