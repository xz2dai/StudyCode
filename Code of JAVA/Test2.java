import java.io.*;
import java.util.*;
import javax.print.DocFlavor;
import javax.swing.*;

public class Main
{

    public static void main(String[] args){
        List<Voter> VoterList = new ArrayList<>();      //投票者数组
        int VoteForrrr = 0 ,VoteForzzz = 0;             //统计票数变量
        for(int i = 1;i <= 30;i++){                     //创建三十个投票者，并使用随机函数随机投票
            String name = "Voter" + i;

            VoterList.add(new Voter("name",ForWho()));  //加入投票者到数组
        }

        for(Voter voter:VoterList){                     //统计zzz和rrr的票数
            if(voter.getVoterFor().equals("zzz")){
                VoteForzzz++;
            }else{
                VoteForrrr++;
            }
            System.out.print(voter.getName() + " " + voter.getVoterFor() + "\n");
        }

        System.out.println("At least " + VoteForzzz + "guys vote for zzz" + "\n" +
                            "And " + VoteForrrr + " guys vote for rrr");      //最终输出票数

    }

    static String ForWho(){                             //随机被投票者函数
        Random random = new Random();
        int k = random.nextInt(2);
        if(k>=1){
            return "zzz";
        }else{
            return "rrr";
        }

    }

}

    class Voter {                                           //投票者类
    String name = "";
    String voterFor = "";

    public Voter(String name,String voterFor){              //构造函数，传入名字和被投票者
        this.name = name;
        this.voterFor = voterFor;
    }

    public String getName(){                                //返回投票者名字
        return name;
    }

    public String getVoterFor(){                            //返回被投票者名字
        return voterFor;
    }

}