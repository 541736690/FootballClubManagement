
// ------------------------------------------------------------------------------------------------
// 名称：AP大作业 Football Management    日期：2016/1/8
// 班级：高二（10）班   作者姓名：张梓宜
// ------------------------------------------------------------------------------------------------

import java.util.*;
public class Management
//主要是通过employeeList[i].Job()和System.out.println(employeeList[i]);这两个方式实现。
//因为出现次数过多，所以程序里面就不一一注释了。
{
    Scanner scan=new Scanner(System.in);
    private Employee[] employeeList; //职员列表
    private int[] isemployee; //该数组中的数均为0或者1 isemployee[i]代表着employeeList[i]中是否有职员
    private int totalnumber=5;//职员总数
    private String TF; // 输入是或否时的缓存
    private boolean k=true; // 记录是或否的缓存
    private String res;// 还是缓存
    private int thisyear=2015; //当前年份
    private int a,b,c,d,e,f,g; //很多缓存
    public Management() // 初始化球员
    {
        isemployee=new int[100];
        for(int i=0;i<100;i++){
            isemployee[i]=0;
        }
        employeeList=new Employee[100];
        employeeList[0]=new Coach("José Mourinho",13000,43,1);
        employeeList[1]=new OwnedPlayer("Lionel Messi",9800,26,"前场自由人",6,1);
        employeeList[2]=new OwnedPlayer("Xavier Hernandez Creus",7000,36,"中场核心",3,1);
        employeeList[3]=new OwnedPlayer("Manual Neuer",5600,30,"门将",5,4);
        employeeList[4]=new LoanedPlayer("Zlatan Ibrahimović",8000,35,"上帝",1,"Paris Saint German",2);
        for(int i=0;i<5;i++){ isemployee[i]=1; }
    }
    public void afterayear() // 过了一年
    {
        thisyear++;
        System.out.println("===============================\n"+"新的赛季到来了......\n"
            +"欢迎来到"+(thisyear)+"\\"+(thisyear+1)+"赛季！\n"
            +"===============================");
        for(int i=0;i<totalnumber;i++){
            if(isemployee[i]==1){
                employeeList[i].afteraseason();
            }
        }
        System.out.println();
    }
    public void check() // 检查是否有离队的球员
    {
        for(int i=0;i<totalnumber;i++){
            if(isemployee[i]==1){
                if(employeeList[i].getcontractyear()==0){
                    System.out.print(employeeList[i].name+"离开了球队");
                    if(employeeList[i].Job().equals("LoanedPlayer")){
                        System.out.println(",回归了"+((LoanedPlayer)employeeList[i]).getowningclub()+"。");
                    }
                    else{ System.out.println("。"); }
                    isemployee[i]=0;
                }
            }
        }
        System.out.println();
    }  
    public void alltheemployees() // 列出所有职员的名字
    {
        k=false;
        System.out.println("-------------------------\n"+"职员名单\n");
        System.out.println("教练");
        for(int i=0;i<totalnumber;i++){
            if(isemployee[i]==1&&employeeList[i].Job()=="Coach"){
                k=true;
                System.out.println(employeeList[i].name);//此后所有出现直接println(employeeList[i])的语句均为多态。
            }
        }
        if(!k) System.out.println("没有教练了。");
        System.out.println();
        k=false;
        System.out.println("买断球员");
        for(int i=0;i<totalnumber;i++){
            if(isemployee[i]==1&&employeeList[i].Job()=="OwnedPlayer"){
                k=true;
                System.out.println(employeeList[i].name);
            }
        }
        if(!k) System.out.println("没有买断球员了。");
        System.out.println();
        k=false;
        System.out.println("租借球员");
        for(int i=0;i<totalnumber;i++){
            if(isemployee[i]==1&&employeeList[i].Job()=="LoanedPlayer"){
                k=true;
                System.out.println(employeeList[i].name);
                
            }
        }
        if(!k) System.out.println("没有租借球员了。");
        System.out.println("\n-------------------------");
        System.out.println();
    }
    public void contractproblem()// 列出需要续约的球员 选择是否需要续约
    {
        for(int i=0;i<totalnumber;i++){
            if(isemployee[i]==1&&employeeList[i].getcontractyear()<=1){
                System.out.println(employeeList[i].name+"的合同还有"+employeeList[i].getcontractyear()+"年就要完成了"
                        +"\n是否要与他续约？(y/n)");
                TF=scan.next();
                if(TF.equals("y")){
                    System.out.println("续约几年？");
                    a=scan.nextInt();
                    System.out.println("薪水有变化吗？(y/n)");
                    TF=scan.next();
                    if(TF.equals("y")){
                        System.out.println("变为多少？");
                        b=scan.nextInt();
                        employeeList[i].GiveNewContract(b,a);
                        System.out.println("续约成功！");
                        System.out.println(employeeList[i].name+"续约到了"+(thisyear+employeeList[i].getcontractyear())
                            +"年！ 新的薪水是"+employeeList[i].getsalary()+"！");
                    }
                    else{
                        employeeList[i].GiveNewContract(a);
                        System.out.println("续约成功！");
                        System.out.println(employeeList[i].name+"续约到了"+(thisyear+employeeList[i].getcontractyear())
                            +"年！ 薪水不变！");
                    }
                    
                }
                else{
                    System.out.println("好的...那么"+employeeList[i].name+"将在下个赛季结束后离开球队.");
                }
                System.out.println();
            }
        }
    }
    public void search()// 查看职员详细信息
    {
        System.out.println("想看看你的职员名单吗？(y/n)");
        TF=scan.next();
        if(TF.equals("y")){
            System.out.println("想要看什么名单？\n1.教练\n2.球员\n3.退出");
            a=scan.nextInt();
            System.out.println();
            if(a==1){
                k=false;
                res="";
                for(int i=0;i<totalnumber;i++){
                    if(isemployee[i]==1&&employeeList[i].Job().equals("Coach")){
                        res+=employeeList[i]+"\n-----------------\n";
                        k=true;
                    }
                }
                if(k) System.out.println("好的，请看！\n\n"+res);
                else System.out.println("抱歉...我们没有教练了...");
            }
            else if(a==2){
                k=false;
                res="";
                for(int i=0;i<totalnumber;i++){
                    if(isemployee[i]==1&&employeeList[i].Job().equals("OwnedPlayer")){
                        res+=employeeList[i]+"\n-----------------\n";
                        k=true;
                    }
                }
                for(int i=0;i<totalnumber;i++){
                    if(isemployee[i]==1&&employeeList[i].Job().equals("LoanedPlayer")){
                        res+=employeeList[i]+"\n-----------------\n";
                        k=true;
                    }
                }
                if(k) System.out.println("好的，请看！\n\n"+res);
                else System.out.println("抱歉...我们没有球员了...");
            }
            else{
                System.out.println("好的");
            }
        }
        System.out.println();
    }
}
