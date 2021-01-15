package Constants;

import java.awt.Color;

public class Constants {

    public int widthMap;
    public int heightMap;
    public int widthBlock;
    public int heightBlock;
    public Color oneLife;
    public Color twoLife;
    public Color threeLife;
    public Color fourLife;
    public Color fiveLife;
    public int quantityColumn;
    public int quantityLine;
    public int heightBoard;
    public int widthBoard;
    public int oneClick;
    public int ballWidht;
    public int speed;
    public int life;
    public int startBall;
    public int startCounterBall;
    public int statisticsPanelWidht;
    public String BacKGroundPhoto;
    public String BacKGroundPhoto2;
    public int blockPoints;
    public String TITLE;
    public int minBlockDestroy;



    public Constants(){
        this.widthBlock=88;
        this.widthMap=720;
        this.heightBlock=40;
        this.heightMap=600;
        this.oneLife= new Color(0x9C0404);
        this.twoLife= new Color(0xFFD0C80C);
        this.threeLife= new Color(0x2CD7D7);
        this.fourLife= new Color(0x95F1C1);
        this.fiveLife= new Color(0x29EA29);
        this.quantityColumn=5;
        this.quantityLine=8;
        this.heightBoard=10;
        this.widthBoard=100;
        this.oneClick=5;
        this.ballWidht=16;
        this.speed=1;
        this.life=2;
        this.startBall=270;
        this.startCounterBall=2;
        this.statisticsPanelWidht=500;
        this.blockPoints=50;
        this.minBlockDestroy=10;
        this.TITLE="Brick breaker";
        this.BacKGroundPhoto="src/main/Images/w1.png";
        this.BacKGroundPhoto2="src/main/Images/w2.png";



    }
}
