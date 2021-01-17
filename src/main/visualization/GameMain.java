package visualization;

import Constants.Constants;
import Images.Image;
import Images.ImageFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EventListener;

public class GameMain extends JFrame implements ActionListener,KeyListener, EventListener {

    public Constants constants= new Constants();
    public DrawBlock drawBlock;
    public Timer timer;
    public int lifeBall;
    public int counterGame=1;

    public GameMain() throws IllegalAccessException {


        timer = new Timer(10, this);
        iniitializeLayout();

    }

    private void iniitializeLayout() throws IllegalAccessException {
        setTitle(constants.TITLE);
        setIconImage(ImageFactory.createImage(Image.BacKGroundPhoto2).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(constants.widthMap+constants.statisticsPanelWidht, constants.heightMap);
        drawBlock=new DrawBlock();
        lifeBall=drawBlock.life;
        add(drawBlock, BorderLayout.LINE_START);
        add(drawBlock.statisticsPanel,BorderLayout.LINE_END);
        addKeyListener(this);
        setLocation(500,200);
        setResizable(false);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            drawBlock.doOneLoop();


        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        if(lifeBall> drawBlock.life)
        {
            JOptionPane.showMessageDialog(null, "Straciłeś życie", ":(", JOptionPane.INFORMATION_MESSAGE);

            lifeBall= drawBlock.life;
            if(drawBlock.life==0) {
                timer.stop();

            }
        }
        if(lifeBall==0)
        {
            timer.stop();
            try {
                writeFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Naciśniej enter i graj dalej", "Kolejna gra?", JOptionPane.INFORMATION_MESSAGE);

        }


    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        if(key == KeyEvent.VK_LEFT && timer.isRunning())
        {
            drawBlock.board.changePosition(false);

        }
        if(key== KeyEvent.VK_RIGHT&& timer.isRunning())
        {
            drawBlock.board.changePosition(true);
        }
        if(key == KeyEvent.VK_UP && timer.isRunning())
        {
            drawBlock.board.fastChangePosition(true);
        }
        if(key == KeyEvent.VK_DOWN && timer.isRunning())
        {
            drawBlock.board.fastChangePosition(false);
        }
        if(key == KeyEvent.VK_SPACE)
        {
            if(timer.isRunning())
            {
                timer.stop();
            }
            else if(!timer.isRunning())
            {
                timer.start();
            }
        }
        if(key == KeyEvent.VK_ENTER && lifeBall==0 && !timer.isRunning())
        {
            drawBlock.blocks.points =0;
            drawBlock.life=2;
            drawBlock.board.boardWeight=constants.widthBoard;
            drawBlock.board.boardLeftX=(int)constants.widthMap/2-drawBlock.board.boardWeight/2;


            if (drawBlock.playerName.equalsIgnoreCase("Mariusz") || drawBlock.playerName.equalsIgnoreCase("Paweł" )|| drawBlock.playerName.equalsIgnoreCase("Mateusz" )) {
                drawBlock.blocks.points += 1000;
                drawBlock.life+=1;
                JOptionPane.showMessageDialog(null, "Dostajesz bonus w postawci 1000 punktów i jednego życia więcej", "Bonus", JOptionPane.INFORMATION_MESSAGE);
            }
            drawBlock.blocks.creatBlock();
            lifeBall=drawBlock.life;
            counterGame+=1;
            timer.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    public void writeFile() throws IOException {
        FileWriter  file = new FileWriter("src/main/SaveFile" + counterGame +".txt");
        file.write("Zawodnik: "+ drawBlock.playerName +"" +
                "\nIlość punktów zdobytych: " + drawBlock.blocks.points);
        file.close();

    }
}
