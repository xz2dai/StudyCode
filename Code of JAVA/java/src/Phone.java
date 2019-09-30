public class Phone {
    String brand = "Huawei";
    String type = "Magic2";
    String os = "Emui9.0";

    public void Call(int number){
        System.out.println("Calling number " + number);
        getInfo();
    }

    public void getInfo(){
        System.out.println("Brand:" + brand);
        System.out.println("Type:" + type);
        System.out.println("OS:" + os);
    }

}
