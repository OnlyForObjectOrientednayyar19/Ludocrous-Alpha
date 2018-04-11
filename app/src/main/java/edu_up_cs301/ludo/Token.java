package edu_up_cs301.ludo;
/**
 * Token class
 * This class contains the pieces of the game (4 re, 4 blue, 4 green, and 4 yellow)
 * as well as the hardcoded paths that the tokens can take along the board. This class also
 * determines if a piece can move or not, and its initial positions at the start of the game

 */

public class Token {

    //instance variables
    private int numSpacesMoved;
    private int owner;
    private boolean isMovable;
    private boolean isHome;
    private double startXPos; //Important!: This value should never be changed!
    private double startYPos; //Important!: This value should never be changed!
    private boolean reachedHomeBase;
    private int path[][];


    /**
     * constructor
     * The constructor defines the hardcoded paths for each piece.
     */
    public Token(int ownsMe, double startX, double startY){
        numSpacesMoved = 0;
        isMovable=false;
        isHome = true;
        owner = ownsMe;
        this.startXPos = startX;
        this.startYPos = startY;
        this.reachedHomeBase = false;

        switch(ownsMe){
            case 0:
                path = new int[][]{{1, 6}, {2, 6},
                        {3, 6}, {4, 6}, {5, 6}, {6, 5}, {6, 4}, {6, 3},
                        {6, 2}, {6, 1}, {6, 0}, {7, 0}, {8, 0},
                        {8, 1}, {8, 2}, {8, 3}, {8, 4}, {8, 5},
                        {9, 6}, {10, 6}, {11, 6}, {12, 6}, {13, 6}, {14, 6},
                        {14, 7}, {14, 8}, {13, 8}, {12, 8}, {11, 8}, {10, 8},
                        {9, 8}, {8, 9}, {8, 10}, {8, 11}, {8, 12}, {8, 13},
                        {8, 14}, {7, 14}, {6, 14}, {6, 13}, {6, 12}, {6, 11},
                        {6, 10}, {6, 9}, {5, 8}, {4, 8}, {3, 8}, {2, 8},
                        {1, 8}, {0, 8}, {0, 7}, {1, 7}, {2, 7}, {3, 7}, {4, 7}, {5, 7}, {6, 7}};
                break;

            case 1:
                path = new int[][]{{8, 1}, {8, 2}, {8, 3}, {8, 4}, {8, 5},
                        {9, 6}, {10, 6}, {11, 6}, {12, 6}, {13, 6}, {14, 6},
                        {14, 7}, {14, 8}, {13, 8}, {12, 8}, {11, 8}, {10, 8},
                        {9, 8}, {8, 9}, {8, 10}, {8, 11}, {8, 12}, {8, 13},
                        {8, 14}, {7, 14}, {6, 14}, {6, 13}, {6, 12}, {6, 11},
                        {6, 10}, {6, 9}, {5, 8}, {4, 8}, {3, 8}, {2, 8},
                        {1, 8}, {0, 8}, {0, 7}, {0, 6}, {1, 6}, {2, 6},
                        {3, 6}, {4, 6}, {5, 6}, {6, 5}, {6, 4}, {6, 3},
                        {6, 2}, {6, 1}, {6, 0}, {7, 0}, {7, 1}, {7, 2},
                        {7, 3}, {7, 4}, {7, 5}, {7, 6}};
                break;
            case 2:
                path = new int[][]{{13, 8}, {12, 8}, {11, 8}, {10, 8},
                        {9, 8}, {8, 9}, {8, 10}, {8, 11}, {8, 12}, {8, 13},
                        {8, 14}, {7, 14}, {6, 14}, {6, 13}, {6, 12}, {6, 11},
                        {6, 10}, {6, 9}, {5, 8}, {4, 8}, {3, 8}, {2, 8},
                        {1, 8}, {0, 8}, {0, 7}, {0, 6}, {1, 6}, {2, 6},
                        {3, 6}, {4, 6}, {5, 6}, {6, 5}, {6, 4}, {6, 3},
                        {6, 2}, {6, 1}, {6, 0}, {7, 0}, {8, 0},
                        {8, 1}, {8, 2}, {8, 3}, {8, 4}, {8, 5},
                        {9, 6}, {10, 6}, {11, 6}, {12, 6}, {13, 6}, {14, 6},
                        {14, 7}, {13, 7}, {12, 7}, {11, 7}, {10, 7}, {9, 7}, {8, 7}};

                break;
            case 3:
                path = new int[][]{{6, 13}, {6, 12}, {6, 11},
                        {6, 10}, {6, 9}, {5, 8}, {4, 8}, {3, 8}, {2, 8},
                        {1, 8}, {0, 8}, {0, 7}, {0, 6}, {1, 6}, {2, 6},
                        {3, 6}, {4, 6}, {5, 6}, {6, 5}, {6, 4}, {6, 3},
                        {6, 2}, {6, 1}, {6, 0}, {7, 0}, {8, 0},
                        {8, 1}, {8, 2}, {8, 3}, {8, 4}, {8, 5},
                        {9, 6}, {10, 6}, {11, 6}, {12, 6}, {13, 6}, {14, 6},
                        {14, 7}, {14, 8}, {13, 8}, {12, 8}, {11, 8}, {10, 8},
                        {9, 8}, {8, 9}, {8, 10}, {8, 11}, {8, 12}, {8, 13},
                        {8, 14}, {7, 14}, {7, 13}, {7, 12}, {7, 11}, {7, 10}, {7, 9}, {7, 8}};
                break;
        }
    }

    /**
     * copy constructor
     * @param original
     */
    public Token(Token original){
        this.numSpacesMoved = original.numSpacesMoved;
        this.isMovable = original.isMovable;
        this.isHome = original.isHome;
        this.owner = original.owner;
        this.startXPos = original.startXPos;
        this.startYPos = original.startYPos;
        this.reachedHomeBase = original.reachedHomeBase;
        this.path = original.path;
    }

    public int getCurrentXLoc(){
        return this.path[this.numSpacesMoved][0];
    }
    public int getCurrentYLoc(){
        return this.path[this.numSpacesMoved][1];
    }
    public int getNumSpacesMoved() {
        return numSpacesMoved;
    }
    public void incNumSpacesMoved(int numDiceVal) {
        this.numSpacesMoved = numDiceVal + this.numSpacesMoved;
    }
    public double getStartXPos() {
        return this.startXPos;
    }
    public double getStartYPos() {
        return this.startYPos;
    }
    public boolean getIsMovable() {
        return isMovable;
    }
    public void setIsMovable(boolean movable) {
        isMovable = movable;
    }
    public boolean getIsHome() {
        return isHome;
    }
    public void setIsHome(boolean home) {
        if(home){
            this.numSpacesMoved = 0;
        }
        isHome = home;
    }
    public int getOwner() {
        return owner;
    }
    public void setReachedHomeBase(boolean bol){
        this.reachedHomeBase = bol;
    }
    public boolean getReachedHomeBase(){
        return reachedHomeBase;
    }
}
