package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

//        System.out.println("Hello world");
//
//        Position pos = new Position(3, 5);
//
//        System.out.println(pos);

//        Board board = new Board(8, 8);

        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();
        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

            }
            catch (ChessException e) {
                System.out.println(e.getMessage());
                System.out.println("Press Enter to continue");
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.println("Press Enter to continue");
                sc.nextLine();
            }
        }


    }
}
