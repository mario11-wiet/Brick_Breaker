package StartGame;
import visualization.GameMain;

import java.awt.*;

public class StartGame {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new GameMain();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    }

