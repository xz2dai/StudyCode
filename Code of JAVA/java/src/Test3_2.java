import java.util.Scanner;

public class Test3_2 implements TestTemplate {
    public void QuestionAnswer(){
        int x,n,k,totol = 0 ;
        Scanner scanner = new Scanner(System.in);
        k = x = scanner.nextInt();n = scanner.nextInt();    //从键盘读入
        for(int i = 1; i <= n ; i++){
            //循环计算x+xx+xxx+....
            totol += k;
            k += x*Math.pow(10,i);
        }
        System.out.println(totol);
    }
}
