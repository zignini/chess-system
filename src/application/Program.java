package application;

import chess.ChessMatch;

public class Program {

    public static void main(String[] args) {

//        System.out.println("Hello world");
//
//        Position pos = new Position(3, 5);
//
//        System.out.println(pos);

//        Board board = new Board(8, 8);

        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());

    }
}