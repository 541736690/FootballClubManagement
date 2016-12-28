
// ------------------------------------------------------------------------------------------------
// 名称：AP大作业 Football Management    日期：2016/1/8
// 班级：高二（10）班   作者姓名：张梓宜
// ------------------------------------------------------------------------------------------------

// 职员
abstract public class Employee //这是一个抽象类
{
    String name; //姓名
    int salary; //工资
    int age; //年龄
    
    public Employee(String namein,int salaryin,int agein){
        name=namein;
        salary=salaryin;
        age=agein;
    }
    
    abstract public int getcontractyear(); //获取合同年限
    abstract public void GiveNewContract(int salaryin,int yearsin); // 签订新的合同（且改变薪水）
    abstract public void GiveNewContract(int yearsin);// 签订新的合同（且不改变薪水） 这是一个重载方法。
    abstract public String Job();// 职业是什么（这个在使用多态的时候会很有用）
    abstract public void afteraseason(); // 过了一个赛季会发生什么（年龄加一，合同年限减一）
    
    // 输出职员的姓名
    public String getname(){
        return name;
    }
    
    // 输出职员的薪资
    public int getsalary(){
        return salary;
    }
    
    // 输出职员的年龄
    public int getage(){
        return age;
    }
    
    // 输出职员的信息
    public String toString(){
        String res;
        res="一个普通的职员\n"+"姓名:"+name+"\n年龄:"+age+"\n薪水:"+salary+"\n";
        return res;
    }
}
