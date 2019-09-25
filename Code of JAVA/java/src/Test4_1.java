import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Test4_1 implements TestTemplate {

    @Override
    public void QuestionAnswer() {
        int[] array={1,6,3,6,7,9,8,6,7,8,8,0,4,5,2,9};
        int[] cup = new int[11];
        Arrays.fill(cup,0);
        for(int i:array){
            cup[i] +=1;
        }
        for(int i=0;i<=10;i++){
            if(cup[i] != 0){
                System.out.println("The number of "+i+" is "+cup[i] );
            }
        }
    }
}
