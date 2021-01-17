package visualization;

import Blocks.Blocks;
import Bonus.Bonus;
import Constants.Constants;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import Ball.Ball;


import ColorBB.*;
import Board.Board;

public class DrawBlock extends JPanel implements ActionListener, KeyListener, EventListener {

    public Constants constants = new Constants();
    public Blocks blocks = new Blocks();
    public Board board = new Board();
    public Bonus bonus;
    public Ball ball;
    public int life;
    public int counter;
    public StatisticsPanel statisticsPanel;
    public int currentBonus=-1;
    public String playerName;




    public DrawBlock() throws IllegalAccessException {
        ball=new Ball(constants.startBall,constants.startBall);
        this.bonus= new Bonus();
        this.life=constants.life;
        this.statisticsPanel=new StatisticsPanel(this);
        playerName = JOptionPane.showInputDialog(null, "Podaj swoje imie: ", "Brick Breaker", JOptionPane.QUESTION_MESSAGE);
        if (playerName == null) {
            System.exit(0);
        }
        if (playerName.equalsIgnoreCase("Mariusz") || playerName.equalsIgnoreCase("Paweł" )|| playerName.equalsIgnoreCase("Mateusz" )) {
            blocks.points += 1000;
            life+=1;
            JOptionPane.showMessageDialog(null, "Dostajesz bonus w postawci 1000 punktów i jednego życia więcej", "Bonus", JOptionPane.INFORMATION_MESSAGE);
        }
        addKeyListener(this);
        initializeVariables();
        initializeLayout();

    }

    private void initializeLayout() {
        setPreferredSize(new Dimension(constants.widthMap+1, constants.heightMap));
    }

    private void initializeVariables() {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < constants.quantityLine; i++) {
            for (int j = 0; j < constants.quantityColumn; j++) {
                if (blocks.blockDestroy[i][j]) {
                    counter = blocks.block[i][j];
                    ColorEnum colorB = ColorChange.changeToColor(counter);
                    g.setColor(colorB.color());

                    g.fillRect(i * constants.widthBlock,
                            j * constants.heightBlock,
                            constants.widthBlock - 1,
                            constants.heightBlock - 1);
                }
            }

        }
        g.setColor(Color.getHSBColor(0,0,0));
        g.fillRect(constants.widthMap-16,0,20,constants.heightMap);
        g.setColor(Color.black);
        g.fillRect(board.boardLeftX, board.boardPositionYInMap, board.boardWeight, board.boardHeight);
        g.setColor(Color.black);
        g.fillOval(ball.x,ball.y,constants.ballWidht, constants.ballWidht);
        g.setColor(Color.black);
        g.fillRect(0,700,10,700);
    }

    public void doOneLoop() throws InterruptedException {
        update();
        repaint();
        blocks.block=ball.destroyBlock(blocks.block,blocks.blockDestroy);
        if(blocks.bonusBlock())
        {
            currentBonus = bonus.choiceBonus();
            if(currentBonus == 3 )
            {
                life=life+1;
            }
            if (currentBonus == 2) {
                if (ball.changeX == 1 || ball.changeX == -1) {
                    ball.changeX *= 2;
                    ball.changeY *= 2;
                } else {
                    ball.changeX /= 2;
                    ball.changeY /= 2;
                }
            }
            if (currentBonus == 1) {
                board.boardWeight += 50;
                if (board.boardWeight >= constants.widthMap / 2) {
                    board.boardWeight = constants.widthMap / 2;
                }
            }
            if (currentBonus == 0) {
                board.boardWeight -= 25;
                if (board.boardWeight < constants.widthMap / 15) {
                    board.boardWeight = (int) constants.widthMap / 15;
                }
            }
        }
        ball.move(board.boardPositionYInMap,board.boardLeftX,board.boardWeight);

        blocks.blockDestroy();
        if(ball.changeX==0 && ball.changeY==0)
        {
            if(life>0)
            {
                life=life-1;

            }
            if(life==0)
            {
                JOptionPane.showMessageDialog(null,
                        "Zawodnik: "+ playerName +"" +
                                "\n Ilość punktów zdobytych: " + blocks.points, "Twój wynik", JOptionPane.INFORMATION_MESSAGE);

            }
            ball=new Ball(constants.startBall,constants.startBall);
            board.boardWeight=constants.widthBoard;
            board.boardLeftX=(int)constants.widthMap/2-board.boardWeight/2;
            currentBonus=-1;
        }
        blocks.newBlock(ball.x,ball.y);
        statisticsPanel.doOneLoopSP();

    }

    private void update() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

