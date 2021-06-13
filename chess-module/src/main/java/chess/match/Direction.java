package chess.match;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    UP_LEFT,
    UP_RIGHT,
    DOWN_LEFT,
    DOWN_RIGHT,
    NULL,
    SELF;

    public Direction reverse() {
        switch (this) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            case UP_LEFT:
                return DOWN_RIGHT;
            case UP_RIGHT:
                return DOWN_LEFT;
            case DOWN_LEFT:
                return UP_RIGHT;
            case DOWN_RIGHT:
                return UP_LEFT;
            case NULL:
                return NULL;
            case SELF:
                return SELF;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public boolean isValid() {
        return this != NULL && this != SELF;
    }
}