package visualization;
import Constants.Constants;
import Images.*;
import Images.Image;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatisticsPanel extends JPanel {

    public DrawBlock drawBlock;
    public Constants constants=new Constants();
    private ImageIcon backgroundImage;
    public JLabel text1;
    public JLabel text2;
    public JLabel text3;
    public JLabel text4;

    public StatisticsPanel(DrawBlock drawBlock) throws IllegalAccessException {
        this.drawBlock=drawBlock;
        initializeVariables();
        initializeLayout();
    }

    private void initializeLayout() throws IllegalAccessException {
        setPreferredSize(new Dimension(constants.statisticsPanelWidht-17, constants.heightMap));
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        text4 = new JLabel("Zawodnik: "+drawBlock.playerName);
        text1 = new JLabel("Liczba żyć: "+drawBlock.life);
        text2 = new JLabel("Liczba punktów: "+drawBlock.blocks.points);
        text3 = new JLabel("Obecny bonus: brak");

        textModyfication(text4);
        textModyfication(text1);
        textModyfication(text2);
        textModyfication(text3);

    }

    private void initializeVariables() throws IllegalAccessException {
        this.backgroundImage= ImageFactory.createImage(Image.BacKGroundPhoto);

    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(),0,0, constants.statisticsPanelWidht, constants.heightMap,null);
    }
    public void textModyfication(JLabel text){
        EmptyBorder border = new EmptyBorder(10,  40 , 20, 40);
        text.setFont(new Font("Courier New", (Font.BOLD | Font.ITALIC), 25));
        text.setForeground(Color.WHITE);
        text.setBorder(border);
        add(text);
    }
    public void doOneLoopSP() throws InterruptedException {
        update();
        repaint();

    }

    private void update() {
        updateInformation();

    }

    public void updateInformation() {
        text4.setText("Zawodnik: "+ drawBlock.playerName);
        text1.setText("Liczba żyć: "+drawBlock.life);
        text2.setText("Liczba punktów: "+drawBlock.blocks.points);
        if(drawBlock.currentBonus==3) {
            text3.setText("Ostatni bonus: +1 życie");
        }
        if(drawBlock.currentBonus==2) {
            text3.setText("Ostatni bonus: predkosc");
        }
        if(drawBlock.currentBonus==1) {
            text3.setText("Ostatni bonus: powiekszenie");
        }
        if(drawBlock.currentBonus==0) {
            text3.setText("Ostatni bonus: zmniejszenie");
        }
        if(drawBlock.currentBonus==0) {
            text3.setText("Ostatni bonus: brak");
        }

    }

}
