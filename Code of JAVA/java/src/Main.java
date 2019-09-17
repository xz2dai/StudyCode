import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Main
{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals("END")){
            return;
        } else {
            System.out.println(str.toUpperCase());
        }
    }
}
