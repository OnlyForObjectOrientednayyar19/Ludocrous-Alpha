package edu_up_cs301.ludo;

import edu_up_cs301.game.GamePlayer;
import edu_up_cs301.game.actionMsg.GameAction;

/**
 * ActionMoveToken class
 * Game action that is sent to LudoLocalgame
 */
public class ActionMoveToken extends GameAction {

    private int index;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     * @param index index of piece
     */
    public ActionMoveToken(GamePlayer player, int index){
        super(player);
        this.index = index;
    }


    /**
     * getter method for index of piece
     * @return the index
     */
    public int getIndex() {
        return this.index;
    }
}
