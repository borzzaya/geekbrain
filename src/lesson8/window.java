package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class window extends JFrame {
    private int windowSize = 500;
    private TicTacToe ticTacToe = new TicTacToe();
    private board board;
    private String infoForUser;
    private JDialog dialog;
    private JTextArea info;

    public window() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, windowSize, windowSize);

        initDialog();
        initBoard();
    }

    private void initBoard() {
        board = null;
        getContentPane().removeAll();

        board = new board(windowSize - 30, ticTacToe);

        getContentPane().add(board);

        board.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                mouseOn(e.getX(), e.getY());
                System.out.println("MousePos: " + e.getX() + " " + e.getY());
            }
        });

        revalidate();
        repaint();
    }

    private void initDialog() {
        dialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setBounds(350, 350, 200, 200);
        dialog.setLayout(null);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JButton yes = createButton(70, 40, 10, 100, "Да");
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                initGame();
                dialog.setVisible(false);
            }
        });

        dialog.add(yes);


        JButton no = createButton(70, 40, 110, 100, "Нет");
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        dialog.add(no);

        info = createTextArea(200, 20, 10, 50, infoForUser);
        dialog.add(info);
        dialog.add(createTextArea(200, 20, 10, 70, "Хотите сыграть еще раз ?"));
    }

    private void showDialog() {
        info.setText(infoForUser);
        dialog.repaint();
        dialog.setVisible(true);
    }

    public JButton createButton(int width, int height, int xPos, int yPos, String text) {
        JButton button = new JButton();
        button.setBounds(xPos, yPos, width, height);
        button.setText(text);
        button.setVisible(true);
        return button;
    }

    public JTextArea createTextArea(int width, int height, int xPos, int yPos, String text) {
        JTextArea txt = new JTextArea();
        txt.setBounds(xPos, yPos, width, height);
        txt.setText(text);
        txt.setEditable(false);
        txt.setVisible(true);
        return txt;
    }


    public void mouseOn(int x, int y) {
        int gridX = (int) x / (windowSize / 3);
        int gridY = (int) y / ((windowSize - 35) / 3);


        if (!ticTacToe.setMove('X', gridY, gridX)) {
            return;
        }
        board.repaint();
        ticTacToe.showField();

        if (ticTacToe.getFinish()) {
            if (ticTacToe.checkWin()) {
                infoForUser = "Вы выиграли!";
            } else {
                infoForUser = "Ничья";
            }
            showDialog();
            return;
        }

        ticTacToe.moveComputer();
        ticTacToe.showField();
        board.repaint();

        if (ticTacToe.getFinish()) {
            if (ticTacToe.checkWin()) {
                infoForUser = "Компьютер выиграл!";
            } else {
                infoForUser = "Ничья";
            }
            showDialog();
            return;
        }
    }

    public void initGame() {
        ticTacToe.initGame();
        initBoard();
    }

}
