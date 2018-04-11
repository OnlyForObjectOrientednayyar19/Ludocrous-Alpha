package edu_up_cs301.ludo;

import edu_up_cs301.game.GamePlayer;
import edu_up_cs301.game.actionMsg.GameAction;

/**
 * ActionRollDice
 *  Game action that is sent to ludo local game. it is used to indicate if the
 *  player wishes to roll a dice.
 */
public class ActionRollDice extends GameAction {

    /**
     * constructor for GameAction
     * @param player the player who created the action
     */
    public ActionRollDice(GamePlayer player) {
        super(player);
    }
}
