/*
 * This class holds all the method and fields for the application
 * paper rock scissors.
 */
package prs;

import java.text.MessageFormat;
import javax.swing.JOptionPane;

/**
 * @author Ian James Fannon
 */
public class Game {
   
    private int round;
    private int answer;
    private int playerOneScore;
    private int playerTwoScore;
    private String playerOneName;
    private String playerTwoName;
    private String playerOne;
    private String playerTwo;
    private boolean isPlaying;
    
    /**
     * The class constructor
     */
    public Game() {
        this.round = 0;
        this.answer = 0;
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
        this.playerOneName = "";
        this.playerTwoName = "";
        this.playerOne = "";
        this.playerTwo = "";
        this.isPlaying = true;
    }
    
    /**
     * A method to obtain the value of the variable playerOne.
     * @return the value of playerOne.
     */
    public String getPlayerOne() {
        return playerOne;
    }
    
    /**
     * A method to obtain the value of the variable playerTwo.
     * @return the value of playerTwo.
     */
    public String getPlayerTwo() {
        return playerTwo;
    }
    
    /**
     * A method to display a game greeting.
     */
    public void Greeting() {
        JOptionPane.showMessageDialog(null, "Welcome to Paper Rock Scissors", 
                "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Created by \"Ian James Fannon\"", 
                "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * A method to obtain the names of the players.
     */
    public void getName() {
        playerOneName = JOptionPane.showInputDialog("Player 1 enter you name: ");
        playerTwoName = JOptionPane.showInputDialog("Player 2 enter your name: ");
    }
    
    /**
     * A method to obtain the input from player one.
     * @return the variable playerOne which stores their move.
     */
    private String getPlayerOneInput() {
        playerOne = JOptionPane.showInputDialog(MessageFormat.format("{0} Enter "
                + "\"P\" for paper\n\"R\" for rock\n\"S\" for Scissors: ", playerOneName, JOptionPane.INFORMATION_MESSAGE));
        return playerOne;
    }
    
    /**
     * A method to obtain the input from player two.
     * @return the variable playerTwo which stores their move.
     */
    private String getPlayerTwoInput() {
        playerTwo = JOptionPane.showInputDialog(MessageFormat.format("{0} Enter "
                + "\"P\" for paper\n\"R\" for rock\n\"S\" for Scissors: ", playerTwoName, JOptionPane.INFORMATION_MESSAGE));
        return playerTwo;
    }
    
    /**
     * A method to display the score, the amount of rounds won.
     */
    private void displayScore() {
        JOptionPane.showMessageDialog(null, MessageFormat.format("{0} Score: {1}          {2}Score: {3}", 
            playerOneName, playerOneScore, playerTwoName, playerTwoScore), "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * A method to display the winner of the game.
     * @param newPlayerOneScore is the amount of rounds won for user one.
     * @param newPlayerTwoScore is the amount of rounds won for user two.
     */
    private void displayWinner(int newPlayerOneScore, int newPlayerTwoScore) {
        if (newPlayerOneScore > newPlayerTwoScore) {
            JOptionPane.showMessageDialog(null, "The Winner is " + playerOneName, 
                    "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
        } else if (newPlayerOneScore < newPlayerTwoScore) {
            JOptionPane.showMessageDialog(null, "The Winner is " + playerTwoName, 
                    "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * A method to see is the users want to play again.
     * @return a boolean value of true or false in the variable isPlaying.
     */
    public boolean isTryingAgain() {
        answer = JOptionPane.showConfirmDialog(null, "Try Again?\nYes or No", 
                "Paper-Rock-Scissors", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Game Over", "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Thank you for playing", 
                    "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
            isPlaying = false;
            System.exit(0);
            return isPlaying;
        } else if (answer == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "One more time", "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Ready",  "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Set",  "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Go",  "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
            isPlaying = true;
            return isPlaying;
        }
        return isPlaying;
    } 
    
    /**
     * A method contain the logic or the determination of a winner.
     */
    public void gameLogic() {
        while(playerOneScore <= 6 && playerTwoScore <= 6) {
            do {
                for (round = 0; round <= 5; round++) {
                    getPlayerOneInput();
                    getPlayerTwoInput();

                    if (playerOne.equalsIgnoreCase("P") && playerTwo.equalsIgnoreCase("R")) {
                        JOptionPane.showMessageDialog(null, MessageFormat.format("Congratulations {0} "
                            + "Paper covers Rock", playerOneName), "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
                        playerOneScore++;
                        displayWinner(playerOneScore, playerTwoScore);
                        displayScore();
                    } else if (playerOne.equalsIgnoreCase("R") && playerTwo.equalsIgnoreCase("P")) {
                        JOptionPane.showMessageDialog(null, MessageFormat.format("Congratulations {0} "
                            + "Paper covers Rock", playerTwoName), "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
                        playerTwoScore++;
                        displayWinner(playerOneScore, playerTwoScore);
                        displayScore();
                    } else if (playerOne.equalsIgnoreCase("R") && playerTwo.equalsIgnoreCase("S")) {
                        JOptionPane.showMessageDialog(null, MessageFormat.format("Congratulations {0} "
                            + "Rock beats Scissors", playerOneName), "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
                        playerOneScore++;
                        displayWinner(playerOneScore, playerTwoScore);
                        displayScore();
                    } else if (playerOne.equalsIgnoreCase("S") && playerTwo.equalsIgnoreCase("R")) {
                        JOptionPane.showMessageDialog(null, MessageFormat.format("Congratulations {0} "
                            + "Rock beats Scissors", playerTwoName), "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
                        playerTwoScore++;
                        displayScore();
                    } else if (playerOne.equalsIgnoreCase("S") && playerTwo.equalsIgnoreCase("P")) {
                        JOptionPane.showMessageDialog(null, MessageFormat.format("Congratulations {0} "
                            + "Scissors cuts Paper", playerOneName), "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
                        playerOneScore++;
                        displayWinner(playerOneScore, playerTwoScore);
                        displayScore();
                    } else if (playerOne.equalsIgnoreCase("P") && playerTwo.equalsIgnoreCase("S")) {
                        JOptionPane.showMessageDialog(null, MessageFormat.format("Congratulations {0} "
                            + "Scissors cuts Paper", playerTwoName), "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
                        playerTwoScore++;
                        displayWinner(playerOneScore, playerTwoScore);
                        displayScore();
                    } else if (playerOne.equalsIgnoreCase("P") && playerTwo.equalsIgnoreCase("P")) {
                        JOptionPane.showMessageDialog(null, "Tie both players draw Paper ", 
                                "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
                    } else if (playerOne.equalsIgnoreCase("R") && playerTwo.equalsIgnoreCase("R")) {
                        JOptionPane.showMessageDialog(null, "Tie both players draw Rock ", 
                                "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
                    } else if (playerOne.equalsIgnoreCase("S") && playerTwo.equalsIgnoreCase("S")) {
                        JOptionPane.showMessageDialog(null, "Tie both players draw Scissors ", 
                                "Paper-Rock-Scissors", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                }
            } while (isTryingAgain());
        }
    }
}
