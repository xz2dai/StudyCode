package MyServlets;
public class CustomerBean{
    // 属性声明
    private String custName;
    private String email;
    private String phone;
    // 构造方法的定义
    public CustomerBean(){}
    public CustomerBean(String custName, String email, String phone){
        this.custName = custName;
        this.email = email;
        this.phone = phone;
    }
// 这里需添加属性的访问方法和修改方法
}