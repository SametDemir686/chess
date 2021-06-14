package chess.match;

import chess.piece.black.*;
import chess.piece.white.*;

import static chess.match.A1Notation.*;

public class MatchBoard extends AbstractBoard {

    public MatchBoard() {
        removeAllPieces();
    }

    @Override
    public void initializeBoard() {
        initilizeWhitePieces();
        initilizeBlackPieces();
    }

    @Override
    public void resetBoard() {
        removeAllPieces();
        initializeBoard();
        isWhitesTurn = true;
    }

    private void initilizeBlackPieces() {
        putBlackPiece(A8, new BlackRook(this));
        putBlackPiece(B8, new BlackKnight(this));
        putBlackPiece(C8, new BlackBishop(this));
        putBlackPiece(D8, new BlackQueen(this));
        putBlackPiece(E8, new BlackKing(this));
        putBlackPiece(F8, new BlackBishop(this));
        putBlackPiece(G8, new BlackKnight(this));
        putBlackPiece(H8, new BlackRook(this));
        putBlackPiece(A7, new BlackPawn(this));
        putBlackPiece(B7, new BlackPawn(this));
        putBlackPiece(C7, new BlackPawn(this));
        putBlackPiece(D7, new BlackPawn(this));
        putBlackPiece(E7, new BlackPawn(this));
        putBlackPiece(F7, new BlackPawn(this));
        putBlackPiece(G7, new BlackPawn(this));
        putBlackPiece(H7, new BlackPawn(this));
    }

    private void initilizeWhitePieces() {
        putWhitePiece(A1, new WhiteRook(this));
        putWhitePiece(B1, new WhiteKnight(this));
        putWhitePiece(C1, new WhiteBishop(this));
        putWhitePiece(D1, new WhiteQueen(this));
        putWhitePiece(E1, new WhiteKing(this));
        putWhitePiece(F1, new WhiteBishop(this));
        putWhitePiece(G1, new WhiteKnight(this));
        putWhitePiece(H1, new WhiteRook(this));
        putWhitePiece(A2, new WhitePawn(this));
        putWhitePiece(B2, new WhitePawn(this));
        putWhitePiece(C2, new WhitePawn(this));
        putWhitePiece(D2, new WhitePawn(this));
        putWhitePiece(E2, new WhitePawn(this));
        putWhitePiece(F2, new WhitePawn(this));
        putWhitePiece(G2, new WhitePawn(this));
        putWhitePiece(H2, new WhitePawn(this));
    }

    @Override
    public boolean canMove(A1Notation piecePosition, A1Notation newPosition) {
        return piecePosition != null
                && piecePosition != newPosition
                && isTurnValidToMoveThePieceAt(piecePosition)
                && getPieceAt(piecePosition).canMoveTo(newPosition);
    }

    private boolean isTurnValidToMoveThePieceAt(A1Notation piecePosition) {
        return isOccupiedByWhitePiece(piecePosition) == isWhitesTurn;
    }

    @Override
    public String toString() {
        return toString(board);
    }
}
