package chess.player;

import chess.match.A1Notation;
import chess.piece.*;
import chess.piece.white.*;

import static chess.match.A1Notation.*;

public class WhitePlayer extends Player {
    public WhiteKing getKing() {
        return (WhiteKing) king;
    }

    public WhiteQueen getQueen() {
        return (WhiteQueen) queen;
    }

    public WhiteBishop getDarkSquareBishop() {
        return (WhiteBishop) darkSquareBishop;
    }

    public WhiteBishop getLightSquareBishop() {
        return (WhiteBishop) lightSquareBishop;
    }

    public WhiteKnight getKnightB() {
        return (WhiteKnight) knightB;
    }

    public WhiteKnight getKnightG() {
        return (WhiteKnight) knightG;
    }

    public WhiteRook getRookA() {
        return (WhiteRook) rookA;
    }

    public WhiteRook getRookH() {
        return (WhiteRook) rookH;
    }

    public WhitePawn getaPawn() {
        return (WhitePawn) aPawn;
    }

    public WhitePawn getbPawn() {
        return (WhitePawn) bPawn;
    }

    public WhitePawn getcPawn() {
        return (WhitePawn) cPawn;
    }

    public WhitePawn getdPawn() {
        return (WhitePawn) dPawn;
    }

    public WhitePawn getePawn() {
        return (WhitePawn) ePawn;
    }

    public WhitePawn getfPawn() {
        return (WhitePawn) fPawn;
    }

    public WhitePawn getgPawn() {
        return (WhitePawn) gPawn;
    }

    public WhitePawn gethPawn() {
        return (WhitePawn) hPawn;
    }

    public void add(A1Notation position, WhitePiece piece) {
        if (piece instanceof King) setKing((WhiteKing) piece);
        else if (piece instanceof Queen) setQueen((WhiteQueen) piece);
        else if (piece instanceof Bishop) setBishop((WhiteBishop) piece, position);
        else if (piece instanceof Knight) setKnight((WhiteKnight) piece, position);
        else if (piece instanceof Rook) setRook((WhiteRook) piece, position);
        else if (piece instanceof Pawn) setPawn((WhitePawn) piece, position);
        else throw new IllegalArgumentException();
    }

    private void setPawn(WhitePawn piece, A1Notation position) {
        if (position == A2) setaPawn(piece);
        else if (position == B2) setbPawn(piece);
        else if (position == C2) setcPawn(piece);
        else if (position == D2) setdPawn(piece);
        else if (position == E2) setePawn(piece);
        else if (position == F2) setfPawn(piece);
        else if (position == G2) setgPawn(piece);
        else if (position == H2) sethPawn(piece);
        else throw new IllegalArgumentException();
    }

    private void setRook(WhiteRook piece, A1Notation position) {
        if (position == A1) setRookA(piece);
        else if (position == H1) setRookH(piece);
        else throw new IllegalArgumentException();
    }

    private void setKnight(WhiteKnight piece, A1Notation position) {
        if (position == B1) setKnightB(piece);
        else if (position == G1) setKnightG(piece);
        else throw new IllegalArgumentException();
    }

    private void setBishop(WhiteBishop piece, A1Notation position) {
        if (position == C1) setLightSquareBishop(piece);
        else if (position == F1) setDarkSquareBishop(piece);
        else throw new IllegalArgumentException();
    }
}
