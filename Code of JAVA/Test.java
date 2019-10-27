import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import javax.print.DocFlavor;
import javax.swing.*;

public class Test
{

    public static void main(String[] args) throws IOException {
        Phone myPhone = new Phone();
        myPhone.getInfo();
        myPhone.Call(10086);
    }

    public class Phone {
    String brand = "Huawei";
    String type = "Magic2";
    String os = "Emui9.0";

    public void Call(int number){
        System.out.println("Calling number " + number);
    }

    public void getInfo(){
        System.out.println("Brand:" + brand);
        System.out.println("Type:" + type);
        System.out.println("OS:" + os);
    }

    }

}