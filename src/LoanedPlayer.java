
// ------------------------------------------------------------------------------------------------
// 名称：AP大作业 Football Management    日期：2016/1/8
// 班级：高二（10）班   作者姓名：张梓宜
// ------------------------------------------------------------------------------------------------

// 职员
public class LoanedPlayer extends Player implements AnEmployee,APlayer{
    private String owningclub;// which club owns the player
    
    public LoanedPlayer(String namein,int salaryin,int agein,String positionin,int contractyearin,String owningclubin,int conditionin){
        super(namein,salaryin,agein,positionin,contractyearin,conditionin);
        owningclub=owningclubin;
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
    
    //球员的位置（前锋？中场？）
    public String getposition(){
        return position;
    };
    
    //球员的竞技状态
    public String getcondition(){
        String res;
        if(condition==1) res="优秀";
        else if(condition==2) res="良好";
        else if(condition==3) res="一般";
        else if(condition==4) res="较差";
        else res="低劣";
        return res;
    }
    
    // 职业是什么（这个在使用多态的时候会很有用）
    public String Job(){
        return "LoanedPlayer";
    }
    
    // 过了一个赛季会发生什么（年龄加一，合同年限减一）
    public void afteraseason(){
        age++;
        contractyear--;
        condition=(int)(5*Math.random())+1;
    }
    
    // 这位租借球员来自哪个俱乐部
    public String getowningclub(){
        return owningclub;
    }
   
    // 输出球员的信息 这里是一个重写方法。
    public String toString(){
        String res;
        res="租借球员\n"+"姓名:"+name+"\n年龄:"+age+"\n薪水:"+salary+"\n位置:"+position+"\n合同年限:"+contractyear+
                "\n所属俱乐部:"+owningclub+"\n竞技状态："+this.getcondition();
        return res;
    }
}
