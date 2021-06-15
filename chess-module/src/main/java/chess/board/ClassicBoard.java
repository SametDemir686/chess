package chess.board;

import chess.match.A1Notation;

import static chess.match.A1Notation.*;

public class ClassicBoard extends AbstractClassicBoard {

    public ClassicBoard() {
        resetBoard();
    }

    @Override
    public void resetBoard() {
        removeAllPieces();
        initilizeWhitePieces();
        initilizeBlackPieces();
        whitesTurn = true;
    }

    private void initilizeBlackPieces() {
        putBlackRook(A8);
        putBlackKnight(B8);
        putBlackBishop(C8);
        putBlackQueen(D8);
        putBlackKing(E8);
        putBlackBishop(F8);
        putBlackKnight(G8);
        putBlackRook(H8);
        putBlackPawn(A7);
        putBlackPawn(B7);
        putBlackPawn(C7);
        putBlackPawn(D7);
        putBlackPawn(E7);
        putBlackPawn(F7);
        putBlackPawn(G7);
        putBlackPawn(H7);
    }

    private void initilizeWhitePieces() {
        putWhiteRook(A1);
        putWhiteKnight(B1);
        putWhiteBishop(C1);
        putWhiteQueen(D1);
        putWhiteKing(E1);
        putWhiteBishop(F1);
        putWhiteKnight(G1);
        putWhiteRook(H1);
        putWhitePawn(A2);
        putWhitePawn(B2);
        putWhitePawn(C2);
        putWhitePawn(D2);
        putWhitePawn(E2);
        putWhitePawn(F2);
        putWhitePawn(G2);
        putWhitePawn(H2);
    }

    @Override
    public boolean canMove(A1Notation piecePosition, A1Notation newPosition) {
        return piecePosition != null
                && piecePosition != newPosition
                && isTurnValidToMoveThePieceAt(piecePosition)
                && getPieceAt(piecePosition).canMoveTo(newPosition);
    }

    private boolean isTurnValidToMoveThePieceAt(A1Notation piecePosition) {
        return isOccupiedByWhitePiece(piecePosition) == whitesTurn;
    }

}
