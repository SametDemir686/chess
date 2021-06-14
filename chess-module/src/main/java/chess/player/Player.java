package chess.player;

import chess.match.A1Notation;
import chess.piece.*;

import java.util.List;

public interface Player {
    List<? extends Piece> getAllActivePieces();

    King getKing();

    Queen getQueen();

    Bishop getDarkSquareBishop();

    Bishop getLightSquareBishop();

    Knight getKnightB();

    Knight getKnightG();

    Rook getRookA();

    Rook getRookH();

    Pawn getaPawn();

    Pawn getbPawn();

    Pawn getcPawn();

    Pawn getdPawn();

    Pawn getePawn();

    Pawn getfPawn();

    Pawn getgPawn();

    Pawn gethPawn();

    default A1Notation getKingsPosition() {
        return getKing().getPosition();
    }
}
