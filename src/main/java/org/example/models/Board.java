package org.example.models;

import java.util.Map;

public class Board {
    private int dimension;
    private int cellCount;
    private Map<Integer, BoardEntity> boardEntityMap;

    public Board(int dimension) {
        this.dimension = dimension;
        this.cellCount = dimension * dimension;

        addSnakesAndLadders();
    }

    private void addSnakesAndLadders() {
        //n snakes to the board (start > end)
        addSnakes();

        //n ladders to the board (end > start)
        addLadders();
    }

    private void addSnakes() {
        for (int i = 0; i < dimension; i++) {
            int min = 2;
            int max = cellCount - 1;

            int start = (int) Math.floor(Math.random() * (max - min + 1) + min);
            max = start - 1;
            int end = (int) Math.floor(Math.random() * (max - min + 1) + min);

            if (!hasSnakeOrLadder(start)) {
                boardEntityMap.put(start, new Snake(start, end));
            }
        }
    }

    private void addLadders() {
        for (int i = 0; i < dimension; i++) {
            int min = 2;
            int max = cellCount - 1;

            int end = (int) Math.floor(Math.random() * (max - min + 1) + min);
            max = end - 1;
            int start = (int) Math.floor(Math.random() * (max - min + 1) + min);

            if (!hasSnakeOrLadder(start)) {
                boardEntityMap.put(start, new Ladder(start, end));
            }
        }
    }

    private boolean hasSnakeOrLadder(int index) {
        return boardEntityMap.containsKey(index);
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Map<Integer, BoardEntity> getBoardEntityMap() {
        return boardEntityMap;
    }

    public void setBoardEntityMap(Map<Integer, BoardEntity> boardEntityMap) {
        this.boardEntityMap = boardEntityMap;
    }
}

/*
n = 10;
min = 2
max = 99

Math.random() -> [0, 1)

(int) (Math.random() * (max - min + 1) + min);

floor(x * 98 + 2)

x = 0.1 => 9.8 + 2 = 11.8 = 11
x = 0.3 => 0.3 * 98 + 2 = 29.4 + 2 = 31.4 = 31
x = 0.5 => 0.5 * 98 + 2 = 49.0 + 2 = 51
x = 0.37 => 0.37 * 98 + 2 = 36.26 + 2 = 38.26 = 38
 */
