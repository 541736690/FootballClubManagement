
// ------------------------------------------------------------------------------------------------
// 名称：AP大作业 Football Management    日期：2016/1/8
// 班级：高二（10）班   作者姓名：张梓宜
// ------------------------------------------------------------------------------------------------

// 教练
public class Coach extends Employee implements AnEmployee{
    private int contractyear; //合同年限
    
    public Coach(String namein,int salaryin,int agein,int contractyearin){
        super(namein,salaryin,agein);
        contractyear=contractyearin;
    }
    
    // 获取合同年限
    public int getcontractyear(){
        return contractyear;
    }
    
    // 签订新的合同（且改变薪水）
    public void GiveNewContract(int salaryin,int yearsin){
        contractyear+=yearsin;
        salary=salaryin;
    }
    
    // 签订新的合同（且不改变薪水） 这是一个重载方法。
    public void GiveNewContract(int yearsin){
        contractyear+=yearsin;
    }
    
    // 职业是什么（这个在使用多态的时候会很有用）
    public String Job(){
        return "Coach";
    }
    
    // 过了一个赛季会发生什么（年龄加一，合同年限减一）
    public void afteraseason(){
        age++;
        contractyear--;
    }
    
    // 输出教练的信息 这里是一个重写方法。
    public String toString(){
        String res;
        res="教练\n"+"姓名:"+name+"\n年龄:"+age+"\n薪水:"+salary+"\n合同年限:"+contractyear;
        return res;
    }
}
