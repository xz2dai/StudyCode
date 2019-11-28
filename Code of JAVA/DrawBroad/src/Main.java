import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class Main {

    static JFrame frame = null;
    static File file = null;
    static   FileReader fr = null;
    static BufferedReader br = null;
    static int isStrat = 0,totol = 0;

    public static void main(String[] args) {



        frame = new JFrame("MultipesTest");
        frame.setSize(320,80);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextField textField = new JTextField("在这里输入单词");
        textField.setSize(180,50);
        JTextArea textArea = new JTextArea("程序开始！");
        textArea.setSize(180,50);
        JButton button1 = new JButton("程序开始");
        button1.addActionListener(actionEvent -> {
            if(isStrat == 0){
                button1.setText("下一单词!");
                try{
                    file = new File("words.txt");
                    fr = new FileReader(file);
                    br = new BufferedReader(fr);
                }catch (IOException e){
                    textArea.setText("未找到文件！");
                }
                isStrat =1;
            }else{
                try {
                    textArea.setText(br.readLine().toString());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        });
        JButton button2 = new JButton("程序结束");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
            }
        });
        frame.add(textArea);
        frame.add(textField);
        frame.add(button1);
        frame.add(button2);
        frame.setVisible(true);
    }


}
