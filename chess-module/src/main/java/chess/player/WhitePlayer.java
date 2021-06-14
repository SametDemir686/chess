package chess.player;

import chess.match.A1Notation;
import chess.match.Board;
import chess.piece.*;
import chess.piece.white.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static chess.match.A1Notation.*;

public class WhitePlayer implements Player {
    private WhiteKing king;
    private WhiteQueen queen;
    private WhiteBishop darkSquareBishop;
    private WhiteBishop lightSquareBishop;
    private WhiteKnight knightB;
    private WhiteKnight knightG;
    private WhiteRook rookA;
    private WhiteRook rookH;
    private WhitePawn aPawn;
    private WhitePawn bPawn;
    private WhitePawn cPawn;
    private WhitePawn dPawn;
    private WhitePawn ePawn;
    private WhitePawn fPawn;
    private WhitePawn gPawn;
    private WhitePawn hPawn;

    public WhitePlayer() {
    }

    public WhitePlayer(WhitePlayer whitePlayer) {
        king = new WhiteKing(whitePlayer.king);
        queen = new WhiteQueen(whitePlayer.queen);
        darkSquareBishop = new WhiteBishop(whitePlayer.darkSquareBishop);
        lightSquareBishop = new WhiteBishop(whitePlayer.lightSquareBishop);
        knightB = new WhiteKnight(whitePlayer.knightB);
        knightG = new WhiteKnight(whitePlayer.knightG);
        rookA = new WhiteRook(whitePlayer.rookA);
        rookH = new WhiteRook(whitePlayer.rookH);
        aPawn = new WhitePawn(whitePlayer.aPawn);
        bPawn = new WhitePawn(whitePlayer.bPawn);
        cPawn = new WhitePawn(whitePlayer.cPawn);
        dPawn = new WhitePawn(whitePlayer.dPawn);
        ePawn = new WhitePawn(whitePlayer.ePawn);
        fPawn = new WhitePawn(whitePlayer.fPawn);
        gPawn = new WhitePawn(whitePlayer.gPawn);
        hPawn = new WhitePawn(whitePlayer.hPawn);
    }

    public List<WhitePiece> getAllActivePieces() {
        return stream()
                .filter(WhitePiece::isActive)
                .collect(Collectors.toList());
    }

    private Stream<WhitePiece> stream() {
        return Stream.of(
                king, queen,
                darkSquareBishop, lightSquareBishop,
                knightB, knightG,
                rookA, rookH,
                aPawn, bPawn, cPawn, dPawn, ePawn, fPawn, gPawn, hPawn);
    }

    public void setBoard(Board board) {
        stream().forEach(piece -> piece.setBoard(board));
    }

    @Override
    public WhiteKing getKing() {
        return king;
    }

    public void setKing(WhiteKing king) {
        this.king = king;
    }

    @Override
    public WhiteQueen getQueen() {
        return queen;
    }

    public void setQueen(WhiteQueen queen) {
        this.queen = queen;
    }

    @Override
    public WhiteBishop getDarkSquareBishop() {
        return darkSquareBishop;
    }

    public void setDarkSquareBishop(WhiteBishop darkSquareBishop) {
        this.darkSquareBishop = darkSquareBishop;
    }

    @Override
    public WhiteBishop getLightSquareBishop() {
        return lightSquareBishop;
    }

    public void setLightSquareBishop(WhiteBishop lightSquareBishop) {
        this.lightSquareBishop = lightSquareBishop;
    }

    @Override
    public WhiteKnight getKnightB() {
        return knightB;
    }

    public void setKnightB(WhiteKnight knightB) {
        this.knightB = knightB;
    }

    @Override
    public WhiteKnight getKnightG() {
        return knightG;
    }

    public void setKnightG(WhiteKnight knightG) {
        this.knightG = knightG;
    }

    @Override
    public WhiteRook getRookA() {
        return rookA;
    }

    public void setRookA(WhiteRook rookA) {
        this.rookA = rookA;
    }

    @Override
    public WhiteRook getRookH() {
        return rookH;
    }

    public void setRookH(WhiteRook rookH) {
        this.rookH = rookH;
    }

    @Override
    public WhitePawn getaPawn() {
        return aPawn;
    }

    public void setaPawn(WhitePawn aPawn) {
        this.aPawn = aPawn;
    }

    @Override
    public WhitePawn getbPawn() {
        return bPawn;
    }

    public void setbPawn(WhitePawn bPawn) {
        this.bPawn = bPawn;
    }

    @Override
    public WhitePawn getcPawn() {
        return cPawn;
    }

    public void setcPawn(WhitePawn cPawn) {
        this.cPawn = cPawn;
    }

    @Override
    public WhitePawn getdPawn() {
        return dPawn;
    }

    public void setdPawn(WhitePawn dPawn) {
        this.dPawn = dPawn;
    }

    @Override
    public WhitePawn getePawn() {
        return ePawn;
    }

    public void setePawn(WhitePawn ePawn) {
        this.ePawn = ePawn;
    }

    @Override
    public WhitePawn getfPawn() {
        return fPawn;
    }

    public void setfPawn(WhitePawn fPawn) {
        this.fPawn = fPawn;
    }

    @Override
    public WhitePawn getgPawn() {
        return gPawn;
    }

    public void setgPawn(WhitePawn gPawn) {
        this.gPawn = gPawn;
    }

    @Override
    public WhitePawn gethPawn() {
        return hPawn;
    }

    public void sethPawn(WhitePawn hPawn) {
        this.hPawn = hPawn;
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
