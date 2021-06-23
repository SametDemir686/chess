package chess.player;

import chess.notations.Position;
import chess.piece.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractPlayer<P extends Piece, K extends King> implements Player<P> {
    protected K king;
    private List<Queen> queens;
    private List<Knight> knights;
    private List<Bishop> bishops;
    private List<Rook> rooks;
    private List<Pawn> pawns;

    protected AbstractPlayer() {
        queens = new ArrayList<>();
        knights = new ArrayList<>();
        bishops = new ArrayList<>();
        rooks = new ArrayList<>();
        pawns = new ArrayList<>();
    }

    @Override
    public void add(Position position, P piece) {
        if (piece instanceof King) setKing((K) piece);
        else if (piece instanceof Queen) queens.add((Queen) piece);
        else if (piece instanceof Knight) knights.add((Knight) piece);
        else if (piece instanceof Bishop) bishops.add((Bishop) piece);
        else if (piece instanceof Rook) rooks.add((Rook) piece);
        else if (piece instanceof Pawn) pawns.add((Pawn) piece);
        else throw new IllegalArgumentException(piece.getClass().toString());
        piece.setPosition(position);
    }

    @Override
    public boolean remove(P piece) {
        if (piece instanceof King) {
            throw new IllegalArgumentException("Cannot remove king");
        } else if (piece instanceof Queen) {
            return queens.remove(piece);
        } else if (piece instanceof Knight) {
            return knights.remove(piece);
        } else if (piece instanceof Bishop) {
            return bishops.remove(piece);
        } else if (piece instanceof Rook) {
            return rooks.remove(piece);
        } else if (piece instanceof Pawn) {
            return pawns.remove(piece);
        }
        return false;
    }

    @Override
    public Piece getPieceAt(Position position) {
        return getAllPieces().stream()
                .filter(s -> s.getPosition() == position)
                .findAny()
                .map(Piece.class::cast)
                .orElse(new NullPiece());
    }

    @Override
    public void removeAllPieces() {
        queens.clear();
        knights.clear();
        bishops.clear();
        rooks.clear();
        pawns.clear();
        king = null;
    }

    public List<P> getAllActivePieces() {
        return getAllPieces().stream()
                .filter(P::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public List<P> getAllPieces() {
        List<P> pieces = new ArrayList<>();
        pieces.add((P) king);
        pieces.addAll((Collection<? extends P>) queens);
        pieces.addAll((Collection<? extends P>) knights);
        pieces.addAll((Collection<? extends P>) bishops);
        pieces.addAll((Collection<? extends P>) rooks);
        pieces.addAll((Collection<? extends P>) pawns);
        return pieces;
    }

    @Override
    public King getKing() {
        return king;
    }

    private void setKing(K piece) {
        if (king == null) king = piece;
        else throw new IllegalStateException("There can be only 1 king");
    }

    @Override
    public List<Queen> getQueens() {
        return queens;
    }

    @Override
    public List<Knight> getKnights() {
        return knights;
    }

    @Override
    public List<Bishop> getBishops() {
        return bishops;
    }

    @Override
    public List<Rook> getRooks() {
        return rooks;
    }

    @Override
    public boolean threathens(Position position) {
        return getAllActivePieces().stream().anyMatch(piece -> piece.threatens(position));
    }

    @Override
    public List<Pawn> getPawns() {
        return pawns;
    }

    public Pawn getPawnThatCanMoveTo(Position to, String distinguisher) {
        return getPieceThatCanMoveTo(pawns, to, distinguisher);
    }

    public Queen getQueenThatCanMoveTo(Position to, String distinguisher) {
        return getPieceThatCanMoveTo(queens, to, distinguisher);
    }

    public Knight getKnightThatCanMoveTo(Position to, String distinguisher) {
        return getPieceThatCanMoveTo(knights, to, distinguisher);
    }

    public Bishop getBishopThatCanMoveTo(Position to, String distinguisher) {
        return getPieceThatCanMoveTo(bishops, to, distinguisher);
    }

    public <T extends Piece> T getPieceThatCanMoveTo(List<T> pieces, Position to, String distinguisher) {
        List<T> result = pieces.stream()
                .filter(piece -> piece.canMoveTo(to) && piece.distinguish(distinguisher))
                .collect(Collectors.toList());
        if (result.isEmpty())
            throw new IllegalArgumentException("cannot find any matching piece");
        if (result.size() > 1)
            throw new IllegalStateException("found " + result.size() + " matching pieces");
        return result.get(0);
    }
}
