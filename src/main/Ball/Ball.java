package Ball;

import Constants.Constants;
import com.sun.jdi.Value;

import java.awt.*;

public class Ball {

    public int x;
    public int y;
    public int changeX;
    public int changeY;
    Constants constants= new Constants();


    public Ball(int startX, int startY)
    {
        this.x=startX;
        this.y=startY;
        this.changeX=-constants.speed;
        this.changeY=-constants.speed;
    }


    public void move(int boardPositionYInMap,int boardLeftX,int boardWeight){

        changeOrientation(boardPositionYInMap,boardLeftX,boardWeight);
        this.x+=this.changeX;
        this.y+=this.changeY;
    }

    private void changeOrientation(int boardPositionYInMap,int boardLeftX,int boardWeight) {
        if(this.x==0)
        {
            this.changeX=-this.changeX;
        }
        else if(this.x==constants.widthMap-2*constants.ballWidht)
        {
            this.changeX=-this.changeX;
        }
        else if (hitBall(boardPositionYInMap,boardLeftX,boardWeight))
        {
            this.changeY=-this.changeY;
        }
        else if(this.y==boardPositionYInMap+ constants.ballWidht)
        {
            this.changeY=0;
            this.changeX=0;
        }
        else if(this.y==0)
        {
            this.changeY=-changeY;
        }
    }
    public int[][] destroyBlock(int[][] tab, boolean[][] value) {
        for (int i = 0; i < constants.quantityLine; i++) {
            for (int j = 0; j < constants.quantityColumn; j++) {
                if (hitBottom(i,j) && value[i][j])
                {
                    tab[i][j]=tab[i][j]-1;
                    this.changeY=-this.changeY;
                }
                else if(hitTop(i,j) &&value[i][j])
                {
                    tab[i][j]=tab[i][j]-1;
                    this.changeY=-this.changeY;
                }
                else if(hitLeft(i,j) &&value[i][j])
                {
                    tab[i][j]=tab[i][j]-1;
                    this.changeX=-this.changeX;
                }
                else if(hitRight(i,j) &&value[i][j])
                {
                    tab[i][j]=tab[i][j]-1;
                    this.changeX=-this.changeX;
                }

            }
        }
        return tab;
    }

    public boolean hitBottom(int i, int j)
    {
        return (this.x>=i*constants.widthBlock && this.x<=(i+1)*constants.widthBlock+constants.speed && (j+1)*constants.heightBlock==this.y);

    }
    public boolean hitTop(int i, int j) {
        return (this.x+constants.speed>= i * constants.widthBlock && this.x <= (i + 1) * constants.widthBlock && (j) * constants.heightBlock == this.y + constants.ballWidht);
    }
    public boolean hitLeft(int i, int j)
    {
        return (this.y>=j*constants.heightBlock && this.y<=(j+1)*constants.heightBlock+constants.speed && (i)*constants.widthBlock==this.x+constants.ballWidht);

    }
    public boolean hitRight(int i, int j) {
        return (this.y+constants.speed >= j * constants.heightBlock && this.y <= (j + 1) * constants.heightBlock && (i + 1) * constants.widthBlock == this.x);
    }
    public boolean hitBall(int boardPositionYInMap, int boardLeftX,int boardWeight)
    {
        return (this.y==boardPositionYInMap-constants.ballWidht && this.x+constants.speed>=boardLeftX && this.x<=boardLeftX+boardWeight);
    }


}