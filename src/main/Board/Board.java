package Board;
import Constants.Constants;

public class Board {

    Constants constants= new Constants();
    public int boardHeight;
    public int boardWeight;
    public int boardLeftX;
    public int boardPositionYInMap;

    public Board()
    {
        this.boardHeight=constants.heightBoard;
        this.boardWeight=constants.widthBoard;
        this.boardLeftX=(int)constants.widthMap/2-boardWeight/2;
        this.boardPositionYInMap=constants.heightMap-80;
    }

    public void changePosition(boolean move)
    {
        if(move)
        {
            this.boardLeftX=this.boardLeftX+constants.oneClick;
        }
        else {
            this.boardLeftX=this.boardLeftX-constants.oneClick;
        }
        if(this.boardLeftX<0)
        {
            this.boardLeftX=0;
        }
        if(this.boardLeftX+boardWeight+15>constants.widthMap)
        {
            this.boardLeftX=-boardWeight+constants.widthMap-15;
        }
    }
    public void fastChangePosition(boolean move)
    {
        if(move)
        {
            this.boardLeftX=0;
        }
        else {
            this.boardLeftX=constants.widthMap-boardWeight-15;
        }
    }

}
