/* Note:Your choice is C IDE */
#include "stdio.h"

int acc[10][3],i=0;//用户账号信息 卡号，密码，余额   i 标识系统当前注册的用户数


void kaihu();
void cunkuan();
void qukuan();
void chaxun();
void zhuanzhang();
void cls();
int login();


void main()
{
	int i;
    printf("************************⊙************************\n");
    printf("*                                                *\n");
    printf("*                                                *\n");
    printf("*                欢迎进入宏图银行！              *\n");
    printf("*                                                *\n");
    printf("*                                                *\n");
    printf("************************⊙************************\n");
    printf("\n\n\n");
    
    
    while(1){
    printf("\t请选择您要办理的手续：\n");
    printf("\t\t1、开户\n");
    printf("\t\t2、存款\n");
    printf("\t\t3、取款\n");
    printf("\t\t4、查询余额\n");
    printf("\t\t5、转账\n");
    printf("\t\t6、退出\n");
    printf("\t请输入您要办理的项目：");
    scanf("%d",&i);
    if(i==6){
    	break;
    }
    switch(i){
    	case 1 :
    		cls();
    		kaihu();
    		getch();//暂停 输入任何字符后继续运行
    		cls();
 			break;
 		case 2 :
 			cunkuan();
    		getch();
    		cls();
 			break;
 		case 3 :
    		qukuan();
    		getch();
 			break;
 		case 4 :
    		chaxun();
    		getch();
    		cls();
 			break;
 		case 5 :
    		zhuanzhang();
    		getch();
 			break;
 		default:
 			printf("请输入正确的操作编号！");
    }
    
    }
    
}

//开户    
void kaihu(){
	int card,mima;
	printf("\t\t欢迎来到开户界面：\n");
	//卡号  密码  余额
	printf("请输入卡号：");
	scanf("%d",&card);
	printf("请输入密码：");
	scanf("%d",&mima);
	
	acc[i][0]=card;//把卡号赋给数组的第一列
	acc[i][1]=mima;//把密码付给第二列
	acc[i][2]=0;//余额，初始化为0
	
	
	i++;//用户数加1
	
	printf("恭喜您注册成功，请按任意键返回主界面！");
	
}

//存款
void cunkuan(){
	int jine=0;
	int flag = login();
	if(flag!=-1){
		
		printf("请输入存款金额：");
		scanf("%d",&jine);
		acc[flag][2]=acc[flag][2]+jine;//将用户存入的金额，加到账户余额中
		printf("您当次存款%d，账户余额为%d\n",jine,acc[flag][2]);
		printf("请按回车键返回主界面:");
	}else{
		printf("登录失败，按回车键返回主界面!");
	}
}

//取款
void qukuan(){
	printf("您选择的是取款业务！\n");
}

//查询余额
void chaxun(){
	int flag = login();
	//-1表示登录失败
	//flag 是用户行号（id）
	if(flag!=-1){
		//登录成功！余额在第三列
		printf("用户ID是 %d 您的账户余额是%d\n",flag,acc[flag][2]);
		printf("请按任意键返回主界面:");
	}else{
		printf("登录失败，按回车键返回主界面!");
	}
	
}

//转账
void zhuanzhang(){
	
	printf("您选择的是转账业务！\n");
}

//登录
int login(){
	int card,mima,i,flag=-1;//表示登录失败
	printf("请先登录：\n");
	printf("请输入卡号：");
	scanf("%d",&card);
	printf("请输入卡密码：");
	scanf("%d",&mima);	
	
	//判断有没有这个用户
	for(i=0;i<10;i++){
		//输入的卡号密码要和账号数组中的同时匹配
		if(card==acc[i][0]&&mima==acc[i][1]){
			flag=i;//找到匹配的账号密码，改变标识
			break;
		}
	}
	return flag;//将登录结果标识返回调用的地方
	
}


//清屏的自定义函数
void cls(){
	system("cls");//清屏	
}