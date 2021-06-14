package chess.player;

import chess.match.A1Notation;
import chess.match.Board;
import chess.piece.*;
import chess.piece.black.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static chess.match.A1Notation.*;

public class BlackPlayer implements Player {
    private BlackKing king;
    private BlackQueen queen;
    private BlackBishop darkSquareBishop;
    private BlackBishop lightSquareBishop;
    private BlackKnight knightB;
    private BlackKnight knightG;
    private BlackRook rookA;
    private BlackRook rookH;
    private BlackPawn aPawn;
    private BlackPawn bPawn;
    private BlackPawn cPawn;
    private BlackPawn dPawn;
    private BlackPawn ePawn;
    private BlackPawn fPawn;
    private BlackPawn gPawn;
    private BlackPawn hPawn;

    public BlackPlayer() {
    }

    public BlackPlayer(BlackPlayer blackPlayer) {
        king = new BlackKing(blackPlayer.king);
        queen = new BlackQueen(blackPlayer.queen);
        darkSquareBishop = new BlackBishop(blackPlayer.darkSquareBishop);
        lightSquareBishop = new BlackBishop(blackPlayer.lightSquareBishop);
        knightB = new BlackKnight(blackPlayer.knightB);
        knightG = new BlackKnight(blackPlayer.knightG);
        rookA = new BlackRook(blackPlayer.rookA);
        rookH = new BlackRook(blackPlayer.rookH);
        aPawn = new BlackPawn(blackPlayer.aPawn);
        bPawn = new BlackPawn(blackPlayer.bPawn);
        cPawn = new BlackPawn(blackPlayer.cPawn);
        dPawn = new BlackPawn(blackPlayer.dPawn);
        ePawn = new BlackPawn(blackPlayer.ePawn);
        fPawn = new BlackPawn(blackPlayer.fPawn);
        gPawn = new BlackPawn(blackPlayer.gPawn);
        hPawn = new BlackPawn(blackPlayer.hPawn);
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

    public List<BlackPiece> getAllActivePieces() {
        return stream()
                .filter(BlackPiece::isActive)
                .collect(Collectors.toList());
    }

    private Stream<BlackPiece> stream() {
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
    public BlackKing getKing() {
        return king;
    }

    public void setKing(BlackKing king) {
        this.king = king;
    }

    @Override
    public BlackQueen getQueen() {
        return queen;
    }

    public void setQueen(BlackQueen queen) {
        this.queen = queen;
    }

    @Override
    public BlackBishop getDarkSquareBishop() {
        return darkSquareBishop;
    }

    public void setDarkSquareBishop(BlackBishop darkSquareBishop) {
        this.darkSquareBishop = darkSquareBishop;
    }

    @Override
    public BlackBishop getLightSquareBishop() {
        return lightSquareBishop;
    }

    public void setLightSquareBishop(BlackBishop lightSquareBishop) {
        this.lightSquareBishop = lightSquareBishop;
    }

    @Override
    public BlackKnight getKnightB() {
        return knightB;
    }

    public void setKnightB(BlackKnight knightB) {
        this.knightB = knightB;
    }

    @Override
    public BlackKnight getKnightG() {
        return knightG;
    }

    public void setKnightG(BlackKnight knightG) {
        this.knightG = knightG;
    }

    @Override
    public BlackRook getRookA() {
        return rookA;
    }

    public void setRookA(BlackRook rookA) {
        this.rookA = rookA;
    }

    @Override
    public BlackRook getRookH() {
        return rookH;
    }

    public void setRookH(BlackRook rookH) {
        this.rookH = rookH;
    }

    @Override
    public BlackPawn getaPawn() {
        return aPawn;
    }

    public void setaPawn(BlackPawn aPawn) {
        this.aPawn = aPawn;
    }

    @Override
    public BlackPawn getbPawn() {
        return bPawn;
    }

    public void setbPawn(BlackPawn bPawn) {
        this.bPawn = bPawn;
    }

    @Override
    public BlackPawn getcPawn() {
        return cPawn;
    }

    public void setcPawn(BlackPawn cPawn) {
        this.cPawn = cPawn;
    }

    @Override
    public BlackPawn getdPawn() {
        return dPawn;
    }

    public void setdPawn(BlackPawn dPawn) {
        this.dPawn = dPawn;
    }

    @Override
    public BlackPawn getePawn() {
        return ePawn;
    }

    public void setePawn(BlackPawn ePawn) {
        this.ePawn = ePawn;
    }

    @Override
    public BlackPawn getfPawn() {
        return fPawn;
    }

    public void setfPawn(BlackPawn fPawn) {
        this.fPawn = fPawn;
    }

    @Override
    public BlackPawn getgPawn() {
        return gPawn;
    }

    public void setgPawn(BlackPawn gPawn) {
        this.gPawn = gPawn;
    }

    @Override
    public BlackPawn gethPawn() {
        return hPawn;
    }

    public void sethPawn(BlackPawn hPawn) {
        this.hPawn = hPawn;
    }
}
