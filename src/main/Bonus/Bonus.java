package Bonus;

import java.util.Random;

public class Bonus {


    public int randomGenenerator;
    Random genarator = new Random();

    public Bonus()
    {
    }

    public boolean bonusActive()
    {
        randomGenenerator = genarator.nextInt(8);
        if(randomGenenerator>=3)
        {
            return false;
        }
        else {
            return true;
        }
    }

    public int choiceBonus()
    {
        if(bonusActive()) {
            randomGenenerator = genarator.nextInt(4);
            return randomGenenerator;
        }
        return -1;

    }
}
