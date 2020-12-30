package de.uol.is.ludo.agents;

import de.uol.is.ludo.IBoard;
import de.uol.is.ludo.IPawn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Strategy4 extends Strategy3 {

    /**
     * @param name  agent name
     * @param color agent color
     * @param board playing field
     */
    public Strategy4(String name, IPawn.player color, IBoard board) {
        super(name, color, board);
        this.strategy = "Strategy4";
    }

    /**
     * @return a list in which the game pieces are returned sorted
     */
    @Override
    protected ArrayList<IPawn> chooseFigure(ArrayList<IPawn> pawns) {
        // random strategy
        int random = (int) (Math.random() * (2 + 1) + 0);
        switch (random) {
            case 0:
                Collections.shuffle(pawns, new Random()); // Generate a random ranking
                optionList.addAll(pawns);
                break;
            case 1:
                pawns.sort(Comparator.comparing(IPawn::getFieldId)); // sort pawns by field id
                optionList.addAll(pawns); // Add all other characters to the result, sorted by game progress
                break;
            case 2:
                optionList.addAll(sortPawnsSortedByCriticalStatus(pawns));
                break;
            default:
                optionList.addAll(pawns);

        }
        return optionList;
    }

}