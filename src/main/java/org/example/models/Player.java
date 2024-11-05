package org.example.models;

import org.example.DiceUtility;

public class Player {
    private String name;
    private int currentPosition;

    public Player(String name, int currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public void makeMove(Board board) {
        int currentPosition = this.currentPosition;

        //roll the dice.
        int diceNumber = DiceUtility.roll();

        System.out.println(this.name + " got " + diceNumber + " on this dice.");

        int finalPosition = currentPosition + diceNumber;

        //Check if there's any Snake or a Ladder present at finalPosition.
        if (finalPosition <= board.getCellCount()) {
            if (board.hasSnakeOrLadder(finalPosition)) {
                BoardEntity entity = board.getBoardEntityMap().get(finalPosition);
                entity.printMessage();
//                    if (entity.getBoardEntityType().equals(BoardEntityType.SNAKE)) {
//                        System.out.println("Oops, You encountered a Snake...:(");
//                    } else {
//                        System.out.println("Yayy, You encountered a Ladder...:)");
//                    }

                finalPosition = entity.getEnd();
            }

            System.out.println(this.name + " is making a move to " + finalPosition);
        } else {
            //Skip the move
            System.out.println("Skipping this move, please try again.");
            finalPosition = currentPosition;
        }

        this.setCurrentPosition(finalPosition);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
