import java.io.*;
import java.util.*;
import javax.print.DocFlavor;
import javax.swing.*;

public class Main
{

    public static void main(String[] args) throws IOException {
        List<Voter> VoterList = new ArrayList<>();
        int VoteForrrr = 0 ,VoteForzzz = 0;
        for(int i = 1;i <= 30;i++){
            String name = "Voter" + i;

            VoterList.add(new Voter("name",ForWho()));
        }

        for(Voter voter:VoterList){
            if(voter.getVoterFor().equals("zzz")){
                VoteForzzz++;
            }else{
                VoteForrrr++;
            }
            System.out.print(voter.getName() + " " + voter.getVoterFor() + "\n");
        }

        System.out.println("At least " + VoteForzzz + "guys vote for zzz" + "\n" +
                            "And " + VoteForrrr + " guys vote for rrr");

    }

    static String ForWho(){
        Random random = new Random();
        int k = random.nextInt(2);
        if(k>=1){
            return "zzz";
        }else{
            return "rrr";
        }

    }

}


