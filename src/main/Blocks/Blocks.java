package Blocks;
import Constants.Constants;

import java.util.Random;

public class Blocks {

    public int quantityColumn;
    public int quantityLine;
    public int points;
    public Constants constants = new Constants();
    public int randomGenenerator;
    public int randomGenenerator2;
    Random genarator = new Random();
    public int[][] block = new int[constants.quantityLine][constants.quantityColumn];
    public boolean[][] blockDestroy = new boolean[constants.quantityLine][constants.quantityColumn];

    public Blocks() {
        this.quantityColumn = constants.quantityColumn;
        this.quantityLine = constants.quantityLine;
        creatBlock();
    }

    public void creatBlock() {
        for (int i = 0; i < constants.quantityLine; i++) {
            for (int j = 0; j < constants.quantityColumn; j++) {
                randomGenenerator = genarator.nextInt(5);
                block[i][j] = randomGenenerator;
                blockDestroy[i][j] = true;
            }
        }
    }

    public void blockDestroy() {
        for (int i = 0; i < constants.quantityLine; i++) {
            for (int j = 0; j < constants.quantityColumn; j++) {
                if (block[i][j] == -1)
                {
                    if(blockDestroy[i][j])
                    {
                        points+=constants.blockPoints;
                    }
                    blockDestroy[i][j] = false;

                }

            }
        }
    }
    public boolean bonusBlock() {
        for (int i = 0; i < constants.quantityLine; i++) {
            for (int j = 0; j < constants.quantityColumn; j++) {
                if (block[i][j] == -1 && blockDestroy[i][j])
                {
                    return true;
                }
            }
        }
        return false;
    }
    public void newBlock(int x, int y)
    {
        int counterBlock=0;
        for (int i = 0; i < constants.quantityLine; i++) {
            for (int j = 0; j < constants.quantityColumn; j++)
            {
                if(!blockDestroy[i][j])
                {
                    counterBlock+=1;
                }
            }
        }
        int newBlockCounter=0;
        if(counterBlock>constants.minBlockDestroy)
        {
            randomGenenerator = genarator.nextInt(constants.quantityColumn*constants.quantityLine-constants.minBlockDestroy+1);
            for (int i = 0; i < constants.quantityLine; i++) {
                for (int j = 0; j < constants.quantityColumn; j++)
                {
                    if(!blockDestroy[i][j])
                    {
                        if(newBlockCounter==randomGenenerator &&
                                !(i*constants.widthBlock>=x && (i+1)*(constants.widthBlock)<=x
                                && j*constants.heightBlock>=y && (j+1)*constants.heightBlock<=y))
                        {
                            randomGenenerator2 = genarator.nextInt(5);
                            block[i][j] = randomGenenerator2;
                            blockDestroy[i][j] = true;
                            return;
                        }
                        else if(newBlockCounter==randomGenenerator)
                        {
                            return;
                        }
                        else
                        {
                            newBlockCounter+=1;
                        }
                    }
                }
            }

        }


    }
}
