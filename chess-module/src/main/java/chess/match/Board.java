package chess.match;

import chess.piece.NullPiece;
import chess.piece.Piece;
import chess.piece.PieceDTO;
import chess.piece.black.*;
import chess.piece.white.*;
import chess.player.BlackPlayer;
import chess.player.WhitePlayer;

import static chess.match.A1Notation.*;
import static chess.util.MatrixUtil.*;

public class Board {
    public static final int BOARD_SIZE = 8;
    private Piece[][] board;
    private boolean isWhitesTurn = true;
    private WhitePlayer whitePlayer = new WhitePlayer();
    private BlackPlayer blackPlayer = new BlackPlayer();

    public Board() {
        board = new Piece[BOARD_SIZE][BOARD_SIZE];
        removeAllPieces();
    }

    public void initializeBoard() {
        initilizeWhitePieces();
        initilizeBlackPieces();
    }

    public void resetBoard() {
        removeAllPieces();
        initializeBoard();
    }

    public void removeAllPieces() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new NullPiece(this);
            }
        }
    }

    public Piece remove(A1Notation position) {
        Piece pieceToBeRemoved = getPieceAt(position);
        put(position, new NullPiece(this));
        return pieceToBeRemoved;
    }

    private void initilizeBlackPieces() {
        putBlackPiece(A8, new BlackRook(this));
        putBlackPiece(B8, new BlackKnight(this));
        putBlackPiece(C8, new BlackBishop(this));
        putBlackPiece(D8, new BlackQueen(this));
        putBlackPiece(E8, new BlackKing(this));
        putBlackPiece(F8, new BlackBishop(this));
        putBlackPiece(G8, new BlackKnight(this));
        putBlackPiece(H8, new BlackRook(this));
        putBlackPiece(A7, new BlackPawn(this));
        putBlackPiece(B7, new BlackPawn(this));
        putBlackPiece(C7, new BlackPawn(this));
        putBlackPiece(D7, new BlackPawn(this));
        putBlackPiece(E7, new BlackPawn(this));
        putBlackPiece(F7, new BlackPawn(this));
        putBlackPiece(G7, new BlackPawn(this));
        putBlackPiece(H7, new BlackPawn(this));
    }

    private void initilizeWhitePieces() {
        putWhitePiece(A1, new WhiteRook(this));
        putWhitePiece(B1, new WhiteKnight(this));
        putWhitePiece(C1, new WhiteBishop(this));
        putWhitePiece(D1, new WhiteQueen(this));
        putWhitePiece(E1, new WhiteKing(this));
        putWhitePiece(F1, new WhiteBishop(this));
        putWhitePiece(G1, new WhiteKnight(this));
        putWhitePiece(H1, new WhiteRook(this));
        putWhitePiece(A2, new WhitePawn(this));
        putWhitePiece(B2, new WhitePawn(this));
        putWhitePiece(C2, new WhitePawn(this));
        putWhitePiece(D2, new WhitePawn(this));
        putWhitePiece(E2, new WhitePawn(this));
        putWhitePiece(F2, new WhitePawn(this));
        putWhitePiece(G2, new WhitePawn(this));
        putWhitePiece(H2, new WhitePawn(this));
    }

    private void put(A1Notation position, Piece piece) {
        board[position.getHorizontalIndex()][position.getVerticalIndex()] = piece;
        piece.setPosition(position);
    }

    private void putBlackPiece(A1Notation position, BlackPiece piece) {
        put(position, piece);
        blackPlayer.add(position, piece);
    }

    private void putWhitePiece(A1Notation position, WhitePiece piece) {
        put(position, piece);
        whitePlayer.add(position, piece);
    }

    public Piece getPieceAt(A1Notation a1Notation) {
        return getPieceAt(a1Notation.getHorizontalIndex(), a1Notation.getVerticalIndex());
    }

    private Piece getPieceAt(int verticalIndex, int horizontalIndex) {
        return board[verticalIndex][horizontalIndex];
    }

    public boolean canMove(A1Notation piecePosition, A1Notation newPosition) {
        return piecePosition != null
                && piecePosition != newPosition
                && isTurnValidToMoveThePieceAt(piecePosition)
                && getPieceAt(piecePosition).canMoveTo(newPosition);
    }

    private boolean isTurnValidToMoveThePieceAt(A1Notation piecePosition) {
        return isOccupiedByWhitePiece(piecePosition) == isWhitesTurn;
    }

    public boolean isEmpty(A1Notation position) {
        return getPieceAt(position) instanceof NullPiece;
    }

    public boolean isOccupiedByWhitePiece(A1Notation position) {
        return getPieceAt(position).isWhite();
    }

    public boolean isOccupiedByBlackPiece(A1Notation position) {
        return getPieceAt(position).isBlack();
    }

    public boolean move(A1Notation piecePosition, A1Notation moveTo) {
        if (canMove(piecePosition, moveTo)) {
            isWhitesTurn = !isWhitesTurn;
            movePiece(piecePosition, moveTo);
            return true;
        }
        return false;
    }

    private void movePiece(A1Notation piecePosition, A1Notation moveTo) {
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

    public boolean isNotEmpty(A1Notation position) {
        return !isEmpty(position);
    }

    public boolean isThreatenedByBlack(A1Notation position) {
        return blackPlayer.getAllActivePieces().stream().anyMatch(piece -> piece.threatens(position));
    }

    public boolean isThreatenedByWhite(A1Notation position) {
        return whitePlayer.getAllActivePieces().stream().anyMatch(piece -> piece.threatens(position));
    }

    private PieceDTO[][] getBoard() {
        PieceDTO[][] result = new PieceDTO[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result[i][j] = new PieceDTO(board[i][j]);
            }
        }
        return result;
    }

    public String getBoardAsStringByWhitePerspective() {
        Piece[][] copy = copyBoard(board);
        transpose(copy);
        rotateLeft(copy);
        return toString(copy);
    }

    public PieceDTO[][] getBoardByWhitePerspective() {
        PieceDTO[][] result = getBoard();
        transpose(result);
        rotateLeft(result);
        return result;
    }

    public String getBoardAsStringByBlackPerspective() {
        Piece[][] copy = copyBoard(board);
        transpose(copy);
        rotateRight(copy);
        return toString(copy);
    }

    public PieceDTO[][] getBoardByBlackPerspective() {
        PieceDTO[][] result = getBoard();
        transpose(result);
        rotateRight(result);
        return result;
    }

    @Override
    public String toString() {
        return toString(board);
    }

    private String toString(Piece[][] board) {
        StringBuilder result = new StringBuilder();
        for (Piece[] pieces : board) {
            for (Piece piece : pieces) {
                result.append(piece).append('\t');
            }
            result.append("\n");
        }
        return result.toString();
    }
}
