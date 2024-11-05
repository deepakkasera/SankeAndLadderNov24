package org.example.models;

import java.util.LinkedList;
import java.util.Queue;

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

    }
}
