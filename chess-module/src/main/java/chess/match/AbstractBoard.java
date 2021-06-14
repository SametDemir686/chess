package chess.match;

import chess.piece.NullPiece;
import chess.piece.Piece;
import chess.piece.PieceDTO;
import chess.piece.black.BlackPiece;
import chess.piece.white.WhitePiece;
import chess.player.BlackPlayer;
import chess.player.WhitePlayer;

import static chess.util.MatrixUtil.*;

public abstract class AbstractBoard implements Board {
    public static final int BOARD_SIZE = 8;
    protected Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];
    protected boolean isWhitesTurn = true;
    protected WhitePlayer whitePlayer = new WhitePlayer();
    protected BlackPlayer blackPlayer = new BlackPlayer();

    private PieceDTO[][] getBoard() {
        PieceDTO[][] result = new PieceDTO[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result[i][j] = new PieceDTO(board[i][j]);
            }
        }
        return result;
    }

    @Override
    public boolean move(A1Notation piecePosition, A1Notation moveTo) {
        if (canMove(piecePosition, moveTo)) {
            isWhitesTurn = !isWhitesTurn;
            movePiece(piecePosition, moveTo);
            return true;
        }
        return false;
    }

    @Override
    public String getBoardAsStringByWhitePerspective() {
        Piece[][] copy = copyBoard(board);
        transpose(copy);
        rotateLeft(copy);
        return toString(copy);
    }

    @Override
    public PieceDTO[][] getBoardByWhitePerspective() {
        PieceDTO[][] result = getBoard();
        transpose(result);
        rotateLeft(result);
        return result;
    }

    @Override
    public String getBoardAsStringByBlackPerspective() {
        Piece[][] copy = copyBoard(board);
        transpose(copy);
        rotateRight(copy);
        return toString(copy);
    }

    @Override
    public PieceDTO[][] getBoardByBlackPerspective() {
        PieceDTO[][] result = getBoard();
        transpose(result);
        rotateRight(result);
        return result;
    }

    protected String toString(Piece[][] board) {
        StringBuilder result = new StringBuilder();
        for (Piece[] pieces : board) {
            for (Piece piece : pieces) {
                result.append(piece).append('\t');
            }
            result.append("\n");
        }
        return result.toString();
    }

    public void removeAllPieces() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new NullPiece(this);
            }
        }
    }

    protected void put(A1Notation position, Piece piece) {
        board[position.getHorizontalIndex()][position.getVerticalIndex()] = piece;
        piece.setPosition(position);
    }

    public Piece remove(A1Notation position) {
        Piece pieceToBeRemoved = getPieceAt(position);
        put(position, new NullPiece(this));
        return pieceToBeRemoved;
    }

    public Piece getPieceAt(A1Notation a1Notation) {
        return getPieceAt(a1Notation.getHorizontalIndex(), a1Notation.getVerticalIndex());
    }

    private Piece getPieceAt(int verticalIndex, int horizontalIndex) {
        return board[verticalIndex][horizontalIndex];
    }

    protected void putBlackPiece(A1Notation position, BlackPiece piece) {
        put(position, piece);
        blackPlayer.add(position, piece);
    }

    protected void putWhitePiece(A1Notation position, WhitePiece piece) {
        put(position, piece);
        whitePlayer.add(position, piece);
    }

    public boolean isOccupiedByWhitePiece(A1Notation position) {
        return getPieceAt(position).isWhite();
    }

    public boolean isOccupiedByBlackPiece(A1Notation position) {
        return getPieceAt(position).isBlack();
    }

    protected void movePiece(A1Notation piecePosition, A1Notation moveTo) {
        Piece movingPiece = remove(piecePosition);
        Piece capturedPiece = remove(moveTo);
        capturedPiece.captured();
        put(moveTo, movingPiece);
        movingPiece.move();
    }

    public A1Notation getKingsPosition(boolean isWhite) {
        if (isWhite) return getWhitesKingPosition();
        else return getBlacksKingPosition();
    }

    public A1Notation getBlacksKingPosition() {
        return blackPlayer.getKingsPosition();
    }

    public A1Notation getWhitesKingPosition() {
        return whitePlayer.getKingsPosition();
    }

    public boolean isEmpty(A1Notation position) {
        return getPieceAt(position) instanceof NullPiece;
    }

    public boolean isNotEmpty(A1Notation position) {
        return !isEmpty(position);
    }

    public boolean isThreatenedByBlack(A1Notation position) {
        return blackPlayer.getAllActivePieces().stream().anyMatch(piece -> piece.threatens(position));
    }

    public boolean isThreatenedByWhite(A1Notation position) {
        return whitePlayer.getAllActivePieces().stream().anyMatch(piece -> piece.threatens(position));
    }

    @Override
    public boolean isWhiteChecked() {
        A1Notation whitesKingPosition = getWhitesKingPosition();
        return blackPlayer.getAllActivePieces().stream()
                .anyMatch(piece -> piece.threatens(whitesKingPosition));
    }

    @Override
    public boolean isBlackedChecked() {
        A1Notation blacksKingPosition = getBlacksKingPosition();
        return whitePlayer.getAllActivePieces().stream()
                .anyMatch(piece -> piece.threatens(blacksKingPosition));
    }

    @Override
    public boolean willThereBeCheckIfMoves(A1Notation from, A1Notation to) {
        if (from == null || to == null) return false;
        if (isEmpty(from)) return false;
        DummyBoard dummyBoard = new DummyBoard(whitePlayer, blackPlayer);
        dummyBoard.move(from, to);
        return dummyBoard.isChecked(isWhitesTurn);
    }

}
