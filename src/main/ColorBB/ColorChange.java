package ColorBB;

public class ColorChange {
    public static ColorEnum changeToColor(int imput)
    {
        return ColorEnum.values()[imput];
    }
    public static int changeToInt(ColorEnum imput)
    {
        return imput.ordinal();
    }
}
