package chess.player;

import chess.match.A1Notation;
import chess.piece.*;
import chess.piece.black.*;

import static chess.match.A1Notation.*;

public class BlackPlayer extends Player {

    public BlackKing getKing() {
        return (BlackKing) king;
    }

    public BlackQueen getQueen() {
        return (BlackQueen) queen;
    }

    public BlackBishop getDarkSquareBishop() {
        return (BlackBishop) darkSquareBishop;
    }

    public BlackBishop getLightSquareBishop() {
        return (BlackBishop) lightSquareBishop;
    }

    public BlackKnight getKnightB() {
        return (BlackKnight) knightB;
    }

    public BlackKnight getKnightG() {
        return (BlackKnight) knightG;
    }

    public BlackRook getRookA() {
        return (BlackRook) rookA;
    }

    public BlackRook getRookH() {
        return (BlackRook) rookH;
    }

    public BlackPawn getaPawn() {
        return (BlackPawn) aPawn;
    }

    public BlackPawn getbPawn() {
        return (BlackPawn) bPawn;
    }

    public BlackPawn getcPawn() {
        return (BlackPawn) cPawn;
    }

    public BlackPawn getdPawn() {
        return (BlackPawn) dPawn;
    }

    public BlackPawn getePawn() {
        return (BlackPawn) ePawn;
    }

    public BlackPawn getfPawn() {
        return (BlackPawn) fPawn;
    }

    public BlackPawn getgPawn() {
        return (BlackPawn) gPawn;
    }

    public BlackPawn gethPawn() {
        return (BlackPawn) hPawn;
    }

    public void add(A1Notation position, BlackPiece piece) {
        if (piece instanceof King) setKing((BlackKing) piece);
        else if (piece instanceof Queen) setQueen((BlackQueen) piece);
        else if (piece instanceof Bishop) setBishop((BlackBishop) piece, position);
        else if (piece instanceof Knight) setKnight((BlackKnight) piece, position);
        else if (piece instanceof Rook) setRook((BlackRook) piece, position);
        else if (piece instanceof Pawn) setPawn((BlackPawn) piece, position);
        else throw new IllegalArgumentException();
    }

    private void setPawn(BlackPawn piece, A1Notation position) {
        if (position == A7) setaPawn(piece);
        else if (position == B7) setbPawn(piece);
        else if (position == C7) setcPawn(piece);
        else if (position == D7) setdPawn(piece);
        else if (position == E7) setePawn(piece);
        else if (position == F7) setfPawn(piece);
        else if (position == G7) setgPawn(piece);
        else if (position == H7) sethPawn(piece);
        else throw new IllegalArgumentException();
    }

    private void setRook(BlackRook piece, A1Notation position) {
        if (position == A8) setRookA(piece);
        else if (position == H8) setRookH(piece);
        else throw new IllegalArgumentException();
    }

    private void setKnight(BlackKnight piece, A1Notation position) {
        if (position == B8) setKnightB(piece);
        else if (position == G8) setKnightG(piece);
        else throw new IllegalArgumentException();
    }

    private void setBishop(BlackBishop piece, A1Notation position) {
        if (position == C8) setLightSquareBishop(piece);
        else if (position == F8) setDarkSquareBishop(piece);
        else throw new IllegalArgumentException();
    }
}
