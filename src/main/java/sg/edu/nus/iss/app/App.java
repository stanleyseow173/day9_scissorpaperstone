package sg.edu.nus.iss.app;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private App(){

    }
    public static void main( String[] args )
    {
        //SCP scp = new SCP();
        //0 -> scissors, 1 -> paper, 2 -> stone
        // System.out.println(SCP.checkWinner(1,0));
        // System.out.println(SCP.checkWinner(2,1));
        // System.out.println(SCP.checkWinner(0,2));
        // System.out.println(SCP.checkWinner(2,0));
        // System.out.println(SCP.checkWinner(2,2));
        // System.out.println(SCP.checkWinner(1,1));
        // System.out.println(SCP.checkWinner(1,2));
        // System.out.println(SCP.checkWinner(0,0));
        // System.out.println(SCP.checkWinner(0,1));

        String[] choices = {"scissor", "paper", "stone"};

        //keep track of the number of times the player and computer wins
        Integer playerWinCont = 0;
        Integer computerWinCount = 0;

        //keyboard input into Scanner object
        Scanner scanner = new Scanner(System.in);

        //variable to keep track of player's selection/input/choice
        String playerSelection = "";

        //instantiate the scissor paper stone class
        SCP scp = new SCP();

        while (!playerSelection.equalsIgnoreCase("Q")){
            //game logic here...

            String winner = "";

            //generate computer choice
            Integer computerSelection = 0;
            computerSelection = scp.generateComputerChoice();

            //detect input from player/
            System.out.println("Enter (0) sciessor, (1) paper, (2) stone (Q) quit application");
            playerSelection = scanner.nextLine();

            if(!playerSelection.equalsIgnoreCase("q")){
                Integer playerOption = Integer.parseInt(playerSelection);

                //valid player entry
                if(playerOption >= 0 && playerOption <=2){
                    winner = scp.checkWinner(computerSelection, playerOption);
                    if (winner.equalsIgnoreCase("player")){
                        playerWinCont ++;    
                    } else if(winner.equalsIgnoreCase("computer")){
                        computerWinCount ++;
                    }
                    System.out.printf("The winner is %s.",winner);
                } else{
                    System.out.println("You have entered an invalid option.");
                    continue;
                }
            }
        }

        System.out.printf("Player win count: %d", playerWinCont);
        System.out.printf("\nComputer win count: %d", computerWinCount);
        System.out.println(playerWinCont>computerWinCount?"Player wins...":playerWinCont==computerWinCount?"Tie":"Computer wins...");

        //kill the scanner object opened to detect keyboard input
        scanner.close();

    }
}
