package lesson8;

import javax.swing.*;
import java.awt.*;

public class board extends JPanel {
    private int windowSize = 0;
    private TicTacToe ticTacToe;

    public board(int windowSize, TicTacToe ticTacToe ) {
        this.windowSize = windowSize;
        this.ticTacToe = ticTacToe;
    }

    public void paint(Graphics g) {
        drawGrid(g);


        for (int gridX = 0; gridX < 3; gridX++) {
            for (int gridY = 0; gridY < 3; gridY++) {
                char val = ticTacToe.getFieldValue(gridY, gridX);
                if (val == 'X') {
                    drawX(g, gridX, gridY);
                }

                if (val == 'O') {
                    drawO(g, gridX, gridY);
                }
            }
        }
    }

    public void setWindowSize(int windowSize) {
        this.windowSize = windowSize;
    }

    public void drawO(Graphics g, int gridX, int gridY) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLUE);
        //Stroke stroke = new BasicStroke(6f);
        Stroke stroke = new BasicStroke(6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2.setStroke(stroke);

        int interval = (int) windowSize / 3;

        int centerX = gridX * interval + interval / 2;
        int centerY = gridY * interval + interval / 2;

        int size = interval / 4;

        g2.drawOval(centerX - size, centerY - size, 2 * size, 2 * size);
    }


    public void drawGrid(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLUE);
        //Stroke stroke = new BasicStroke(6f);
        Stroke stroke = new BasicStroke(6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2.setStroke(stroke);

        int startx = (int) (windowSize / 100 * 5);
        int interval = (int) windowSize / 3;
        g2.drawLine(startx, interval, windowSize - startx, interval);
        g2.drawLine(startx, interval * 2, windowSize - startx, interval * 2);

        g2.drawLine(interval, startx, interval, windowSize - startx);
        g2.drawLine(interval * 2, startx, interval * 2, windowSize - startx);
    }

    public void drawX(Graphics g, int gridX, int gridY) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLUE);
        //Stroke stroke = new BasicStroke(6f);
        Stroke stroke = new BasicStroke(6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2.setStroke(stroke);

        //System.out.println(startx);
        int interval = (int) windowSize / 3;

        int centerX = gridX * interval + interval / 2;
        int centerY = gridY * interval + interval / 2;

        int size = interval / 4;

        g2.drawLine(centerX - size, centerY - size, centerX + size, centerY + size);
        g2.drawLine(centerX + size, centerY - size, centerX - size, centerY + size);
    }

    public void clear() {

        Graphics2D g = (Graphics2D) getGraphics();
        g.dispose();
        g.create();
        g.clearRect(0,0,getWidth(), getHeight());
        repaint();
    }



}
