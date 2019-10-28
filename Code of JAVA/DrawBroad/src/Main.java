import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

    static JFrame frame = null;

    public static void main(String[] args) {

        Graphics2D g;
        frame = new JFrame("DrawBroad");
        frame.setBounds(600, 300, 500, 400);
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setBackground(Color.white);
        TextField LX = new TextField();
        TextField LY = new TextField();
        frame.add(LX);
        frame.add(LY);
        frame.setVisible(true);
        g = (Graphics2D)frame.getGraphics();
        g.setColor(Color.BLACK);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                LX.setText(Integer.toString(e.getX()));
                LY.setText(Integer.toString(e.getY()));
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                g.drawLine(e.getX(),e.getY(),e.getX(),e.getY());
            }
        });

    }


}
