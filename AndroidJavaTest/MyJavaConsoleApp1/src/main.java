import java.util.*;

class Parent{

	Parent(){
		System.out.println("Parent build");
	}
}
class SubParent extends Parent{
	SubParent(){
		System.out.println("SubParent build");
	}
}
public class main extends SubParent{
	main(){
		System.out.println("Subroutine build");
	}
	public static void main(String[] args){
		main s=new main();
	}
}

