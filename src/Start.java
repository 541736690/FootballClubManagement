
// ------------------------------------------------------------------------------------------------
// 名称：AP大作业 Football Management    日期：2016/1/8
// 班级：高二（10）班   作者姓名：张梓宜
// ------------------------------------------------------------------------------------------------

// 主方法在这里！！！
public class Start {
    public static void main(String[ ] args){
        Management manage1=new Management(); //初始化一个管理系统
        manage1.alltheemployees(); //列出所有职员名单
        manage1.contractproblem(); //处理合同年的职员 （合同年：合同还有1年到期）
        manage1.search(); //查看职员名单
        manage1.afterayear(); //过了一个赛季
        manage1.check(); //列出离队的球员
        manage1.contractproblem(); //处理合同年的职员 （合同年：合同还有1年到期）
        manage1.search(); //查看职员名单
    }
}
