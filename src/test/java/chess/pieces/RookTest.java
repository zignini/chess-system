package chess.pieces;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessMatch;
import chess.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.Color.BLACK;
import static chess.Color.WHITE;
import static org.junit.jupiter.api.Assertions.*;

public class RookTest {

    private Rook rook;
    private Board board;
    private Position startingPosition;
    private ChessMatch chessMatch;

    @BeforeEach
    void setUp() {
        Color color = WHITE;
        chessMatch = new ChessMatch();
        board = chessMatch.getBoard();
        rook = new Rook(board, color);
        startingPosition = new Position(4, 4);
        rook.setPosition(startingPosition);
        chessMatch.getBoard().placePiece(rook, startingPosition);
    }

    @Test
    @DisplayName("Rook can't move outside the board")
    void testMoveOutsideTheBoard() {
        Position invalidTargetPosition = new Position(9, 9);
        assertThrows(IndexOutOfBoundsException.class, () -> rook.possibleMoves());
    }

    @Test
    @DisplayName("Rook can't move diagonally")
    void testMoveDiagonally() {
//        Position invalidTargetPosition = new Position (5, 5);
        assertFalse(rook.possibleMoves()[5][5]);
    }

    @Test
    @DisplayName("Rook can't move when there is an opponent piece in the way")
    void testMoveOpponentInTheWay() {
        Piece opponentPiece = new Rook(board, BLACK);
        Position opponentPiecePosition = new Position(3, 4);
        board.placePiece(opponentPiece, opponentPiecePosition);
        assertFalse(rook.possibleMoves()[2][4]);
    }

    @Test
    @DisplayName("Rook can't move when there is a friendly piece in the way")
    void testMoveFriendlyPieceInTheWay() {
        Piece friendlyPiece = new Rook(board, WHITE);
        Position friendlyPiecePosition = new Position(3, 4);
        board.placePiece(friendlyPiece, friendlyPiecePosition);
        assertFalse(rook.possibleMoves()[2][4]);
    }

    @Test
    @DisplayName("Rook can't capture friendly piece")
    void testCaptureFriendly() {
        Piece friendlyPiece = new Rook(board, WHITE);
        Position friendlyPiecePosition = new Position(2, 4);
        board.placePiece(friendlyPiece, friendlyPiecePosition);
        assertFalse(rook.possibleMoves()[2][4]);
    }

    @Test
    @DisplayName("Rook cam capture opponent piece")
    void testCaptureOpponent() {
        Piece opponentPiece = new Rook(board, BLACK);
        Position opponentPiecePosition = new Position(2, 4);
        board.placePiece(opponentPiece, opponentPiecePosition);
        assertTrue(rook.possibleMoves()[2][4]);
    }

}
