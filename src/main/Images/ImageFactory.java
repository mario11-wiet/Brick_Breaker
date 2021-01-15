package Images;

import Constants.Constants;

import javax.swing.*;

public class ImageFactory {

    public static ImageIcon createImage(Image image) throws IllegalAccessException {
        Constants constants=new Constants();

        ImageIcon imageIcon=null;

        switch (image){
            case BacKGroundPhoto:
                imageIcon=new ImageIcon(constants.BacKGroundPhoto);
                break;
            case BacKGroundPhoto2:
                imageIcon=new ImageIcon(constants.BacKGroundPhoto2);
                break;
            default:
                return null;
        }
        return imageIcon;
    }
}
