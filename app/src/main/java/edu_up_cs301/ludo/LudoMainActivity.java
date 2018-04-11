package edu_up_cs301.ludo;

import java.util.ArrayList;

import edu_up_cs301.game.GameMainActivity;
import edu_up_cs301.game.GamePlayer;
import edu_up_cs301.game.LocalGame;
import edu_up_cs301.game.config.GameConfig;
import edu_up_cs301.game.config.GamePlayerType;

/**
 * LudoMainActivity
 * It is the default start up screen
 */
public class LudoMainActivity extends GameMainActivity {

    // the port number that this game will use when playing over the network
    private static final int PORT_NUMBER = 2278;

    /**
     * Create the default configuration for this game:
     * - one human player vs. one computer player
     * - minimum of 1 player, maximum of 4
     *
     * @return
     * 		the new configuration object, representing the default configuration
     */
    @Override
    public GameConfig createDefaultConfig() {

        // Define the allowed player types
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

        // Ludo has two player types:  human and computer
        playerTypes.add(new GamePlayerType("Local Human") {
            public GamePlayer createPlayer(String name) {
                return new HumanPlayer(name);
            }});
//
//        //TODO add smart computer player
//        playerTypes.add(new GamePlayerType("Smart Computer Player") {
//            public GamePlayer createPlayer(String name) {
//                return new ComputerSmartPlayer(name);
//            }});

        playerTypes.add(new GamePlayerType("Computer Easy") {
            public GamePlayer createPlayer(String name) {
                return new ComputerPlayer(name);
            }});

        // Create a game configuration class for Ludo:
        GameConfig defaultConfig = new GameConfig(playerTypes, 1, 4, "Ludo", PORT_NUMBER);
        defaultConfig.addPlayer("Human", 0); // player 1: a human player
        defaultConfig.addPlayer("ComputerEasy2", 1); // player 2: a computer player
        //TODO add smart computer Player
        defaultConfig.addPlayer("ComputerEasy3", 1);
        defaultConfig.addPlayer("ComputerEasy4", 1);
        defaultConfig.setRemoteData("Remote Human Player", "", 0);

        return defaultConfig;
    }//createDefaultConfig

    /**
     * create a local game
     *
     * @return
     * 		the local game, a Ludo game
     */
    @Override
    public LocalGame createLocalGame() {
        return new LudoLocalGame();
    }


}




