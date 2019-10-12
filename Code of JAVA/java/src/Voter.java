import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Voter {
    String name = "";
    String voterFor = "";

    public Voter(String name,String voterFor){
        this.name = name;
        this.voterFor = voterFor;
    }

    public String getName(){
        return name;
    }

    public String getVoterFor(){
        return voterFor;
    }

    static String ForWho(){             //直接由主类迁移来的，需要修改才能使用
        Random random = new Random();
        int k = random.nextInt(2);
        if(k>=1){
            return "zzz";
        }else{
            return "rrr";
        }

    }


    public void ForResult(){           //拷贝到main使用
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


}
