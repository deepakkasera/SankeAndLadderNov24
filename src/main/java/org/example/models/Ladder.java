package org.example.models;

public class Ladder extends BoardEntity {

    public Ladder(int start, int end) {
        super(start, end, BoardEntityType.LADDER);
    }

    @Override
    public void printMessage() {
        System.out.println("Yayy, You encountered a Ladder...:)");
    }

    @Override
    public void printEntity() {
        System.out.print("L(" + this.getEnd() + ") ");
    }
}
