package org.example.models;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private Board board;
    private Queue<Player> players;
    private Queue<Player> winners;
    private int dimension;

    public Game(int dimension, Queue<Player> players) {
        this.dimension = dimension;
        this.players = players;
        this.winners = new LinkedList<>();

        this.board = new Board(dimension);
    }

    public void launch() {
        this.board.display();

        while (players.size() > 1) {
            Player currentPlayer = players.poll();

            System.out.println("It is " + currentPlayer.getName() + "'s turn.");
            System.out.println("Please press 'r' to roll the dice.");

            Scanner scanner = new Scanner(System.in);
            char ch = scanner.next().charAt(0);

            currentPlayer.makeMove(board);

            //Check if the currentPlayer has WON the game or not.
            if (currentPlayer.getCurrentPosition() == board.getCellCount()) {
                System.out.println(currentPlayer.getName() + " has WON the game. Congratulations..");
                winners.add(currentPlayer);
            } else {
                players.add(currentPlayer);
            }
        }
    }
}
