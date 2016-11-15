/*
 * This is an application of the classic game paper rock scissors.
 * Created: June 3, 2016
 * Programmer: Ian James Fannon
 */
package prs;

/**
 * @author Ian James Fannon
 */
public class PaperRockScissors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Game game = new Game();
        game.Greeting();
        game.getName();
        game.gameLogic();
    }
    
}
