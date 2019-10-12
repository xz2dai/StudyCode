import java.util.Random;

public class Test6_2 implements TestTemplate {
    @Override
    public void QuestionAnswer() {
        Employee[] employees = new Employee[20];
        for(int i = 0; i < employees.length; i++) {
        // 随机产生 20 个 YearWorker 、 MonthWorker 和 WeekWorker 对象赋值给数组
            Random random = new Random();
            int key = random.nextInt(3);
            switch (key){
                case 0:{
                    employees[i] = new YearWorker();
                    break;
                }
                case 1:{
                    employees[i] = new MonthWorker();
                    break;
                }
                case 2:{
                    employees[i] = new WeekWorker();
                    break;
                }
                default:
                    break;
            }
        }
        Company company = new Company(employees);
        System.out.println(" 公司年工资总额 :" + company.salariesPay() + "万");
    }

    abstract class Employee {
        public abstract double earnings();
    }
    class YearWorker extends Employee {
        @Override
        public double earnings() {
            return 15.0;
        }
    }
    class MonthWorker extends Employee {
        @Override
        public double earnings() {
            return 1.0*12;
        }
    }
    class WeekWorker extends Employee {
        @Override
        public double earnings() {
            return 0.5*12*4;
        }
    }
    class Company {
        Employee[] employees;
        Company(Employee[] employees) {
            this.employees = employees;
        }
        public double salariesPay() {
            double salaries = 0;
            for(Employee e : employees){
                salaries+=e.earnings();
            }

            return salaries;
        }
    }


}
