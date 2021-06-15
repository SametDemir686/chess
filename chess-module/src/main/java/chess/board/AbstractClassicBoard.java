package chess.board;

import chess.match.A1Notation;
import chess.piece.NullPiece;
import chess.piece.Piece;
import chess.piece.PieceDTO;
import chess.piece.black.*;
import chess.piece.white.*;
import chess.player.BlackPlayer;
import chess.player.Player;
import chess.player.WhitePlayer;

public abstract class AbstractClassicBoard implements Board {
    public static final int BOARD_SIZE = 8;
    protected Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];
    protected boolean whitesTurn = true;
    protected Player<WhitePiece> whitePlayer = new WhitePlayer();
    protected Player<BlackPiece> blackPlayer = new BlackPlayer();

    public PieceDTO[][] getBoardDTO() {
        PieceDTO[][] result = new PieceDTO[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result[i][j] = new PieceDTO(board[i][j]);
            }
        }
        return result;
    }

    public Piece[][] getBoard() {
        Piece[][] result = new Piece[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result[i][j] = board[i][j].copy();
            }
        }
        return result;
    }

    @Override
    public boolean move(A1Notation piecePosition, A1Notation moveTo) {
        if (canMove(piecePosition, moveTo)) {
            whitesTurn = !whitesTurn;
            movePiece(piecePosition, moveTo);
            return true;
        }
        return false;
    }

    public void removeAllPieces() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new NullPiece();
            }
        }
    }

    protected void put(A1Notation position, Piece piece) {
        board[position.getHorizontalIndex()][position.getVerticalIndex()] = piece;
        piece.setPosition(position);
        piece.setBoard(this);
    }

    public Piece remove(A1Notation position) {
        Piece pieceToBeRemoved = getPieceAt(position);
        put(position, new NullPiece());
        return pieceToBeRemoved;
    }

    public Piece getPieceAt(A1Notation a1Notation) {
        return getPieceAt(a1Notation.getHorizontalIndex(), a1Notation.getVerticalIndex());
    }

    private Piece getPieceAt(int verticalIndex, int horizontalIndex) {
        return board[verticalIndex][horizontalIndex];
    }

    @Override
    public void putBlackPiece(A1Notation position, BlackPiece piece) {
        put(position, piece);
        blackPlayer.add(position, piece);
    }

    @Override
    public void putWhitePiece(A1Notation position, WhitePiece piece) {
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

    @Override
    public A1Notation getBlacksKingPosition() {
        return blackPlayer.getKingsPosition();
    }

    @Override
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
    public boolean isCheckMate() {
        return isChecked(whitesTurn)
                && hasNoMoves(whitesTurn);
    }

    @Override
    public boolean isStaleMate() {
        return !isChecked(whitesTurn)
                && hasNoMoves(whitesTurn);
    }

    private boolean hasNoMoves(boolean whitesTurn) {
        if (whitesTurn) return whiteHasNoMoves();
        return blackHasNoMoves();
    }

    private boolean whiteHasNoMoves() {
        return whitePlayer.getAllActivePieces().stream().noneMatch(Piece::canMove);
    }

    private boolean blackHasNoMoves() {
        return blackPlayer.getAllActivePieces().stream().noneMatch(Piece::canMove);
    }

    @Override
    public boolean willThereBeCheckIfMoves(A1Notation from, A1Notation to) {
        if (from == null || to == null) return false;
        if (isEmpty(from)) return false;
        HelperBoard helperBoard = new HelperBoard(whitePlayer, blackPlayer);
        helperBoard.move(from, to);
        return helperBoard.isChecked(whitesTurn);
    }

    @Override
    public void putBlackPawn(A1Notation position) {
        putBlackPiece(position, new BlackPawn());
    }

    @Override
    public void putBlackQueen(A1Notation position) {
        putBlackPiece(position, new BlackQueen());
    }

    @Override
    public void putBlackBishop(A1Notation position) {
        putBlackPiece(position, new BlackBishop());
    }

    @Override
    public void putBlackKnight(A1Notation position) {
        putBlackPiece(position, new BlackKnight());
    }

    @Override
    public void putBlackRook(A1Notation position) {
        putBlackPiece(position, new BlackRook());
    }

    @Override
    public void putBlackKing(A1Notation position) {
        putBlackPiece(position, new BlackKing());
    }

    @Override
    public void putWhitePawn(A1Notation position) {
        putWhitePiece(position, new WhitePawn());
    }

    @Override
    public void putWhiteQueen(A1Notation position) {
        putWhitePiece(position, new WhiteQueen());
    }

    @Override
    public void putWhiteBishop(A1Notation position) {
        putWhitePiece(position, new WhiteBishop());
    }

    @Override
    public void putWhiteKnight(A1Notation position) {
        putWhitePiece(position, new WhiteKnight());
    }

    @Override
    public void putWhiteRook(A1Notation position) {
        putWhitePiece(position, new WhiteRook());
    }

    @Override
    public void putWhiteKing(A1Notation position) {
        putWhitePiece(position, new WhiteKing());
    }

    @Override
    public String toString() {
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
