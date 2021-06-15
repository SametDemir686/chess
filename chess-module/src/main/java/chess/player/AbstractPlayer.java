package chess.player;

import chess.match.A1Notation;
import chess.piece.King;
import chess.piece.NullPiece;
import chess.piece.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractPlayer<P extends Piece, K extends King> implements Player<P> {
    protected K king;
    private List<P> pieces;

    protected AbstractPlayer() {
        pieces = new ArrayList<>();
    }

    @Override
    public void add(A1Notation position, P piece) {
        if (piece instanceof King) {
            setKing((K) piece);
        }
        pieces.add(piece);
    }

    @Override
    public boolean remove(P piece) {
        return pieces.remove(piece);
    }

    @Override
    public Piece getPieceAt(A1Notation position) {
        return pieces.stream()
                .filter(s -> s.getPosition() == position)
                .findAny()
                .map(Piece.class::cast)
                .orElse(new NullPiece());
    }

    @Override
    public void removeAllPieces() {
        pieces.clear();
    }

    public List<P> getAllActivePieces() {
        return pieces.stream()
                .filter(P::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public List<P> getAllPieces() {
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
}
