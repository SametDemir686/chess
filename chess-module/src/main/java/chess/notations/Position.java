package chess.notations;

import java.util.Optional;

public enum Position {
    A1('A', '1', 0, 0),
    A2('A', '2', 0, 1),
    A3('A', '3', 0, 2),
    A4('A', '4', 0, 3),
    A5('A', '5', 0, 4),
    A6('A', '6', 0, 5),
    A7('A', '7', 0, 6),
    A8('A', '8', 0, 7),
    B1('B', '1', 1, 0),
    B2('B', '2', 1, 1),
    B3('B', '3', 1, 2),
    B4('B', '4', 1, 3),
    B5('B', '5', 1, 4),
    B6('B', '6', 1, 5),
    B7('B', '7', 1, 6),
    B8('B', '8', 1, 7),
    C1('C', '1', 2, 0),
    C2('C', '2', 2, 1),
    C3('C', '3', 2, 2),
    C4('C', '4', 2, 3),
    C5('C', '5', 2, 4),
    C6('C', '6', 2, 5),
    C7('C', '7', 2, 6),
    C8('C', '8', 2, 7),
    D1('D', '1', 3, 0),
    D2('D', '2', 3, 1),
    D3('D', '3', 3, 2),
    D4('D', '4', 3, 3),
    D5('D', '5', 3, 4),
    D6('D', '6', 3, 5),
    D7('D', '7', 3, 6),
    D8('D', '8', 3, 7),
    E1('E', '1', 4, 0),
    E2('E', '2', 4, 1),
    E3('E', '3', 4, 2),
    E4('E', '4', 4, 3),
    E5('E', '5', 4, 4),
    E6('E', '6', 4, 5),
    E7('E', '7', 4, 6),
    E8('E', '8', 4, 7),
    F1('F', '1', 5, 0),
    F2('F', '2', 5, 1),
    F3('F', '3', 5, 2),
    F4('F', '4', 5, 3),
    F5('F', '5', 5, 4),
    F6('F', '6', 5, 5),
    F7('F', '7', 5, 6),
    F8('F', '8', 5, 7),
    G1('G', '1', 6, 0),
    G2('G', '2', 6, 1),
    G3('G', '3', 6, 2),
    G4('G', '4', 6, 3),
    G5('G', '5', 6, 4),
    G6('G', '6', 6, 5),
    G7('G', '7', 6, 6),
    G8('G', '8', 6, 7),
    H1('H', '1', 7, 0),
    H2('H', '2', 7, 1),
    H3('H', '3', 7, 2),
    H4('H', '4', 7, 3),
    H5('H', '5', 7, 4),
    H6('H', '6', 7, 5),
    H7('H', '7', 7, 6),
    H8('H', '8', 7, 7),
    ;

    private final char horizontalChar;
    private final char verticalChar;
    private final int verticalIndex;
    private final int horizontalIndex;

    Position(char verticalChar, char horizontalChar, int verticalIndex, int horizontalIndex) {
        this.verticalChar = verticalChar;
        this.horizontalChar = horizontalChar;
        this.verticalIndex = verticalIndex;
        this.horizontalIndex = horizontalIndex;
    }

    public static Position[][] getBoard() {
        return new Position[][]{
                new Position[]{A8, B8, C8, D8, E8, F8, G8, H8},
                new Position[]{A7, B7, C7, D7, E7, F7, G7, H7},
                new Position[]{A6, B6, C6, D6, E6, F6, G6, H6},
                new Position[]{A5, B5, C5, D5, E5, F5, G5, H5},
                new Position[]{A4, B4, C4, D4, E4, F4, G4, H4},
                new Position[]{A3, B3, C3, D3, E3, F3, G3, H3},
                new Position[]{A2, B2, C2, D2, E2, F2, G2, H2},
                new Position[]{A1, B1, C1, D1, E1, F1, G1, H1}
        };
    }

    public static Position parse(String position) {
        return valueOf(position.toUpperCase());
    }

    public int getVerticalIndex() {
        return verticalIndex;
    }

    public int getHorizontalIndex() {
        return horizontalIndex;
    }

    public String getName() {
        return verticalChar + "" + horizontalChar;
    }

    public Position left() {
        int upVertice = (int) verticalChar - 1;
        if (upVertice < 'A') return null;
        return valueOf((char) upVertice + "" + horizontalChar);
    }

    public Position right() {
        int upVertice = (int) verticalChar + 1;
        if (upVertice > 'H') return null;
        return valueOf((char) upVertice + "" + horizontalChar);
    }

    public Position up() {
        int rightHorizon = (int) horizontalChar + 1;
        if (rightHorizon > '8') return null;
        return valueOf(verticalChar + "" + (char) rightHorizon);
    }

    public Position down() {
        int leftHorizon = (int) horizontalChar - 1;
        if (leftHorizon < '1') return null;
        return valueOf(verticalChar + "" + (char) leftHorizon);
    }

    public Position downRight() {
        Position down = down();
        if (down == null) return null;
        return down.right();
    }

    public Position downLeft() {
        Position down = down();
        if (down == null) return null;
        return down.left();
    }

    public Position upRight() {
        Position up = up();
        if (up == null) return null;
        return up.right();
    }

    public Position upLeft() {
        Position up = up();
        if (up == null) return null;
        return up.left();
    }

    public Position upUpRight() {
        return Optional.of(this).map(Position::upRight).map(Position::up).orElse(null);
    }

    public Position upRightRight() {
        return Optional.of(this).map(Position::upRight).map(Position::right).orElse(null);
    }

    public Position upUpLeft() {
        return Optional.of(this).map(Position::upLeft).map(Position::up).orElse(null);
    }

    public Position upLeftLeft() {
        return Optional.of(this).map(Position::upLeft).map(Position::left).orElse(null);
    }

    public Position downDownRight() {
        return Optional.of(this).map(Position::downRight).map(Position::down).orElse(null);
    }

    public Position downRightRight() {
        return Optional.of(this).map(Position::downRight).map(Position::right).orElse(null);
    }

    public Position downDownLeft() {
        return Optional.of(this).map(Position::downLeft).map(Position::down).orElse(null);
    }

    public Position downLeftLeft() {
        return Optional.of(this).map(Position::downLeft).map(Position::left).orElse(null);
    }

    public boolean isEighthRank() {
        return horizontalChar == '8';
    }

    public boolean isFirstRank() {
        return horizontalChar == '1';
    }
}
