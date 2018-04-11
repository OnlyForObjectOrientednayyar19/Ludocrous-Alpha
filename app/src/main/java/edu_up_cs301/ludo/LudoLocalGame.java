package edu_up_cs301.ludo;

import android.util.Log;

import edu_up_cs301.game.GamePlayer;
import edu_up_cs301.game.LocalGame;
import edu_up_cs301.game.actionMsg.GameAction;

/**
 * A class that represents the state of our game available to the player.
 * Defines and enforces the game rules; handles interactions with players.
 * @author God, through which all is possible
 * @author Avery Guillermo
 * @author Ravi Nayyar
 * @author Luke Danowski
 * @author Chris Sebrechts
 * @author Nuxoll, Andrew
 * @author Veghdal, Steven
 */

public class LudoLocalGame extends LocalGame {

    // the game's state
    private LudoState state;

    public LudoLocalGame() {
        state = new LudoState();
    }


    /**
     * send the updated state to a given player
     * @param p GamePlayerObject
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        LudoState copy = new LudoState(state);
        p.sendInfo(copy);
    }

    /**
     * canMove
     * can this player make a move
     * @param playerIdx the player's player-number (ID)
     * @return true if matches
     */
    @Override
    protected boolean canMove(int playerIdx) {
        return playerIdx == state.getWhoseMove();
    }

    /**
     * checkIfGameOver
     * Check if the game is over / if the player has won.
     * @return a message that tells who has won the game, or null if the
     * game is not over
     */
    @Override
    protected String checkIfGameOver() {
        for(int i = 0 ; i < state.getNumPlayers() ; i++) {
            if(state.getPlayerScore(i) == 4){
                return "Congrats!" + playerNames[i] + " wins!!!";
            }
        }
        return null;
    }

    /**
     * makeMove
     * this determines what moves can be made and verifies if the move made by the
     * player legal.
     * @param action
     * 			The move that the player has sent to the game
     * @return true if any move is possuble
     */
    @Override
    protected boolean makeMove(GameAction action) {
        int playerID;
        //if its the person's turn and they are trying to make a move
        if (canMove(playerID = getPlayerIdx(action.getPlayer()))) {
            if (action instanceof ActionMoveToken && state.getCanMovePiece() == true) {
                //move forward, consider and react to landing on another piece
                return state.advanceToken(playerID, ((ActionMoveToken) action).getIndex());

            }
            else if (action instanceof ActionRollDice && state.getIsRollable()== true) {

                state.newRoll();
            //    Log.i("diceval", " " + state.getDiceVal());
                //if the player can't make any moves
                if(state.getDiceVal() !=6 && state.getNumMovableTokens(playerID) ==0){
                    state.changePlayerTurn();
                    return true;
                }
                state.setCanMovePiece(true);
                //if the player did not roll a six but can move a single piece
                if(state.getDiceVal() !=6 && state.getNumMovableTokens(playerID) == 1){
                    state.setIsRollable(false);
                    int index = state.getTokenIndexOfFirstPieceOutOfStart(playerID);
                    state.advanceToken(playerID, index);
                    return true;
                }
                //if the player did not roll a six but can move multiple pieces
                if(state.getDiceVal() !=6 && state.getNumMovableTokens(playerID) > 1){
                    state.setIsRollable(false);
                    state.setStillPlayersTurn(true);
                    return true;
                }
                //if the player rolls a six, let them take a piece out of base or move a piece
                if(state.getDiceVal() ==6){
                    state.setStillPlayersTurn(true);
                    state.setIsRollable(false);
                    state.setCanBringOutOfStart(true);
                    return true;
                }
            }
            else if (action instanceof ActionRemoveFromBase && state.getDiceVal() == 6 && state.isCanBringOutOfStart() == true) {
                //toggle boolean to false
                state.pieces[((ActionRemoveFromBase) action).getIndex()].setIsHome(false);
                state.setIsRollable(true);
                state.setStillPlayersTurn(true);
                state.setCanBringOutOfStart(false);
                state.setCanMovePiece(false);
                return true;
            }
        }
        return true; // do nothing since the move was not valid!
    }
}
