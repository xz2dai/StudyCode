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

}
