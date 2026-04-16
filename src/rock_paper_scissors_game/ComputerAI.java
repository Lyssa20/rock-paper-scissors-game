/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock_paper_scissors_game;

/**
 *
 * @author lisas
 */
import java.util.ArrayList;
import java.util.Random;

public class ComputerAI {
    
    ArrayList<String> list;
    Random random = new Random();
    ComputerAI ai; 

    // track player habits
    int rockCount = 0;
    int paperCount = 0;
    int scissorsCount = 0;

    // moves
    String ROCK = "ROCK";
    String PAPER = "PAPER";
    String SCISSORS = "SCISSORS";

    // constructor (gets move list from main class)
    public ComputerAI(ArrayList<String> list) {
        this.list = list;
    }

    // track what player plays
    public void trackPlayerMove(String move) {
        if(move.equals(ROCK)) rockCount++;
        else if(move.equals(PAPER)) paperCount++;
        else scissorsCount++;
    }

    // main AI logic
    public String getMove(String difficulty) {

        // EASY = random
        if(difficulty.equals("Easy")) {
            return list.get(random.nextInt(list.size()));
        }

        // find most used move
        String mostUsed = ROCK;

        if(paperCount > rockCount && paperCount > scissorsCount)
            mostUsed = PAPER;
        else if(scissorsCount > rockCount && scissorsCount > paperCount)
            mostUsed = SCISSORS;

        // counter move
        String smartMove;

        if(mostUsed.equals(ROCK)) smartMove = PAPER;
        else if(mostUsed.equals(PAPER)) smartMove = SCISSORS;
        else smartMove = ROCK;

        // MEDIUM = mix
        if(difficulty.equals("Medium")) {
            int chance = random.nextInt(100);

            if(chance < 60)
                return smartMove;
            else
                return list.get(random.nextInt(list.size()));
        }

        // HARD = always smart
        return smartMove;
    }

    // reset AI memory
    public void reset() {
        rockCount = 0;
        paperCount = 0;
        scissorsCount = 0;
    }
}

