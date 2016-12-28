
// ------------------------------------------------------------------------------------------------
// 名称：AP大作业 Football Management    日期：2016/1/8
// 班级：高二（10）班   作者姓名：张梓宜
// ------------------------------------------------------------------------------------------------

// 球员
abstract public class Player extends Employee //这是一个抽象类
{
    int contractyear; //合同年限
    String position;//位置（前锋？中场？）
    int condition; //竞技状态
    
    public Player(String namein, int salaryin,int agein,String positionin,int contractyearin,int conditionin){
        super(namein,salaryin,agein);
        position=positionin;
        contractyear=contractyearin;
        condition=conditionin;
    }

}
