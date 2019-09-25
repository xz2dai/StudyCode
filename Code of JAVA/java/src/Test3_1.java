public class Test3_1 implements TestTemplate {
    public static void Question1Result(){
        for(int i = 0 ; i <= 100 ;i+=5){
            System.out.println("摄氏度："+i+" 华氏度："+ String.valueOf(GiveAnswer(i)));
        }
    }
    public static double GiveAnswer(double cTemp){
        double fTemp;
        fTemp = cTemp*9/5+32;
        return fTemp;
    }

    public void QuestionAnswer() {

    }
}
