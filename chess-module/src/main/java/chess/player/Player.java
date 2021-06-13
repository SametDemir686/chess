package chess.player;

import chess.match.A1Notation;
import chess.piece.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Player {
    protected King king;
    protected Queen queen;
    protected Bishop darkSquareBishop;
    protected Bishop lightSquareBishop;
    protected Knight knightB;
    protected Knight knightG;
    protected Rook rookA;
    protected Rook rookH;
    protected Pawn aPawn;
    protected Pawn bPawn;
    protected Pawn cPawn;
    protected Pawn dPawn;
    protected Pawn ePawn;
    protected Pawn fPawn;
    protected Pawn gPawn;
    protected Pawn hPawn;

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public Queen getQueen() {
        return queen;
    }

    public void setQueen(Queen queen) {
        this.queen = queen;
    }

    public Bishop getDarkSquareBishop() {
        return darkSquareBishop;
    }

    public void setDarkSquareBishop(Bishop darkBishop) {
        this.darkSquareBishop = darkBishop;
    }

    public Bishop getLightSquareBishop() {
        return lightSquareBishop;
    }

    public void setLightSquareBishop(Bishop bishop) {
        this.lightSquareBishop = bishop;
    }

    public Knight getKnightB() {
        return knightB;
    }

    public void setKnightB(Knight knightB) {
        this.knightB = knightB;
    }

    public Knight getKnightG() {
        return knightG;
    }

    public void setKnightG(Knight knightG) {
        this.knightG = knightG;
    }

    public Rook getRookA() {
        return rookA;
    }

    public void setRookA(Rook rookA) {
        this.rookA = rookA;
    }

    public Rook getRookH() {
        return rookH;
    }

    public void setRookH(Rook rookH) {
        this.rookH = rookH;
    }

    public Pawn getaPawn() {
        return aPawn;
    }

    public void setaPawn(Pawn aPawn) {
        this.aPawn = aPawn;
    }

    public Pawn getbPawn() {
        return bPawn;
    }

    public void setbPawn(Pawn bPawn) {
        this.bPawn = bPawn;
    }

    public Pawn getcPawn() {
        return cPawn;
    }

    public void setcPawn(Pawn cPawn) {
        this.cPawn = cPawn;
    }

    public Pawn getdPawn() {
        return dPawn;
    }

    public void setdPawn(Pawn dPawn) {
        this.dPawn = dPawn;
    }

    public Pawn getePawn() {
        return ePawn;
    }

    public void setePawn(Pawn ePawn) {
        this.ePawn = ePawn;
    }

    public Pawn getfPawn() {
        return fPawn;
    }

    public void setfPawn(Pawn fPawn) {
        this.fPawn = fPawn;
    }

    public Pawn getgPawn() {
        return gPawn;
    }

    public void setgPawn(Pawn gPawn) {
        this.gPawn = gPawn;
    }

    public Pawn gethPawn() {
        return hPawn;
    }

    public void sethPawn(Pawn hPawn) {
        this.hPawn = hPawn;
    }

    public A1Notation getKingsPosition() {
        return getKing().getPosition();
    }

    public List<Piece> getAllActivePieces() {
        return Stream.of(king, queen,
                darkSquareBishop, lightSquareBishop,
                knightB, knightG,
                rookA, rookH,
                aPawn, bPawn, cPawn, dPawn, ePawn, fPawn, gPawn, hPawn)
                .filter(AbstractPiece::isActive)
                .collect(Collectors.toList());
    }
}
