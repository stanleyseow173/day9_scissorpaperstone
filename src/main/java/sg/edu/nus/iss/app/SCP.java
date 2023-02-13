package sg.edu.nus.iss.app;

import java.util.Random;

import javax.lang.model.util.ElementScanner14;

public class SCP {
    public Integer generateComputerChoice(){
        Random random = new Random();
        return random.nextInt(3);
    }

    public String checkWinner(Integer playerChoice, Integer computerChoice){
        //0 -> scissors
        //1 -> paper
        //2 -> stone
        String whoWins = "";

        //draw
        if (playerChoice == computerChoice){
            whoWins = "no one";
        //player scissors and computer paper
        }else if (playerChoice == 0 & computerChoice == 1){
            whoWins = "player";
        }
        //player paper and computer stone
        else if (playerChoice == 1 & computerChoice == 2){
            whoWins = "player";
        }
        //player stone and computer scissors
        else if (playerChoice == 2 & computerChoice == 0){
            whoWins = "player";
        }else{
            whoWins = "computer";
        }
        return whoWins;
    }
}
