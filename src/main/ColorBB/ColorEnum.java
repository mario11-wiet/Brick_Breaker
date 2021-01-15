package ColorBB;
import Constants.Constants;
import java.awt.*;

public enum ColorEnum {
    onelife,
    twolife,
    threelife,
    fourlife,
    fivelife;

    Constants constants= new Constants();

    public Color color(){
        switch (this){
            case onelife:
                return constants.oneLife;
            case twolife:
                return constants.twoLife;
            case threelife:
                return constants.threeLife;
            case fourlife:
                return constants.fourLife;
            case fivelife:
                return constants.fiveLife;
            default:
                break;
        }

        return null;
    }
}
