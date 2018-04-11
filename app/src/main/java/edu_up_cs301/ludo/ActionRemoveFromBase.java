package edu_up_cs301.ludo;

import edu_up_cs301.game.GamePlayer;
import edu_up_cs301.game.actionMsg.GameAction;

/**
 * ActionRemoveFromBase
 *
 * Game action that is sent to ludo local game. it is used to indicate if the
 * player wishes to bring a piece out of base
 */
public class ActionRemoveFromBase extends GameAction {

    int index;

    /**
     * constructor for GameAction
     * @param player the player who created the action
     * @param index the pieces that wants to be moved.
     */
    public ActionRemoveFromBase(GamePlayer player, int index) {
        super(player);
        this.index = index;
    }
    public int getIndex(){ return index; }
}
