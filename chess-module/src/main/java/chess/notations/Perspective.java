package chess.notations;

import static chess.notations.Position.*;

public enum Perspective {
    WHITE(new Position[][]{
            {A8, B8, C8, D8, E8, F8, G8, H8},
            {A7, B7, C7, D7, E7, F7, G7, H7},
            {A6, B6, C6, D6, E6, F6, G6, H6},
            {A5, B5, C5, D5, E5, F5, G5, H5},
            {A4, B4, C4, D4, E4, F4, G4, H4},
            {A3, B3, C3, D3, E3, F3, G3, H3},
            {A2, B2, C2, D2, E2, F2, G2, H2},
            {A1, B1, C1, D1, E1, F1, G1, H1},
    }),
    BLACK(new Position[][]{
            {H1, G1, F1, E1, D1, C1, B1, A1},
            {H2, G2, F2, E2, D2, C2, B2, A2},
            {H3, G3, F3, E3, D3, C3, B3, A3},
            {H4, G4, F4, E4, D4, C4, B4, A4},
            {H5, G5, F5, E5, D5, C5, B5, A5},
            {H6, G6, F6, E6, D6, C6, B6, A6},
            {H7, G7, F7, E7, D7, C7, B7, A7},
            {H8, G8, F8, E8, D8, C8, B8, A8},
    });


    private Position[][] positions;

    Perspective(Position[][] positions) {
        this.positions = positions;
    }

    public Position[][] getPositions() {
        return positions;
    }
}
