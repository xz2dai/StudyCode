import java.util.Random;
import java.util.Scanner;

public class TestRandom {

    int LuckyNumber;    //中奖序号
    int NumberLength;   //中奖序号长度
    int MaxNumber;      //中奖序号最大值 = 多少人来抽奖
    int NumofLuckyTimes;       //一次抽出多少中奖序号（1~2）
    int NumofLuckyGuys;         //抽出多少人中奖
    int Terms = 0;                  //抽奖轮次
    public static void main(String[] args) {
        GetNumbers();
        while(NumofLuckyGuys > 0){         //抽奖轮次
            for(int i =1;i<=NumofLuckyTimes;i++){
                if(NumofLuckyGuys <= 0) break;
                GetLuckyNumber();
                System.out.println("本次中奖的序号为："+LuckyNumber+"!让我们恭喜TA");
                NumofLuckyGuys--;
            }
            Terms++;
            System.out.println("第"+Terms+"轮抽奖结束了");
        }
        System.out.println("抽奖结束，让我恭喜中奖者们！");
    }

    private void GetNumbers(){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入中奖序号长度:");
        this.NumberLength = sc.nextInt();
        System.out.print("请输入中奖序号最大值:");
        this.MaxNumber = sc.nextInt();
        while((MaxNumber+"").length() > NumberLength){
            System.out.println("最大值超出限制长度！请重新输入");
            System.out.print("请输入中奖序号最大值:");
            this.MaxNumber = sc.nextInt();
        }
        System.out.print("请输入一次抽出多少中奖序号(1~2):");
        this.NumofLuckyTimes = sc.nextInt();
        while(NumofLuckyTimes>2 || NumofLuckyTimes <= 0){
            System.out.println("输入数字不在1~2！请重新输入");
            System.out.print("请输入一次抽出多少中奖序号(1~2):");
            this.NumofLuckyTimes = sc.nextInt();
        }
        System.out.print("请输入多少人中奖(不少于五人)：");
        this.NumofLuckyGuys = sc.nextInt();
        while(NumofLuckyGuys<5 || NumofLuckyGuys>=Integer.MAX_VALUE){
            System.out.println("输入数字长度小于5！请重新输入");
            System.out.print("请输入多少人中奖(不少于五人)：");
            this.NumofLuckyGuys = sc.nextInt();
        }
        System.out.println("所有数据输入完毕！现在开始随机中奖序号以及抽取中奖者");
    }

    private void GetLuckyNumber(){
        Random rd = new Random();
        this.LuckyNumber = rd.nextInt(MaxNumber-(int)Math.pow(10,NumberLength-1))+ (int)Math.pow(10,NumberLength-1);

    }

}