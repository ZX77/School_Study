#include "stdio.h"

int a[100][3],j=0;//保存用户信息的二维数组  行：表示用户  列：表示用户信息字段 0、卡号 1、密码 2、余额

void kh();
void ck();
void qk();
void cx();
void zz();
void tc();

void clear();//清屏

int login();//登陆


void main(){
	int a;
	printf("**********************************◎**********************************\n");
	printf("*                                                                    *\n");
	printf("*                                                                    *\n");
	printf("*                        ◎欢迎进入中国银行                          *\n");
	printf("*                                                                    *\n");
	printf("*                                                                    *\n");
	printf("**********************************◎**********************************\n\n\n\n");
	
	do{
		printf("\t\t请选择您要办理的手续：\n");
		printf("\t\t\t1、开户\n");
		printf("\t\t\t2、存款\n");
		printf("\t\t\t3、取款\n");
		printf("\t\t\t4、查询余额\n");
		printf("\t\t\t5、转账\n");
		printf("\t\t\t6、退出\n");
		printf("\t\t请选择您要办理的业务：");
		scanf("%d",&a);
		switch(a){
			case 1:
				clear();//清屏
				kh();
				getch();
				clear();
				break;
			case 2:
				clear();
				ck();
				getch();
				clear();
				break;
			case 3:
				clear();
				qk();
				getch();
				clear();
				break;
			case 4:
				clear();
				cx();
				getch();
				clear();
				break;
			case 5:
				clear();
				zz();
				getch();
				clear();
				break;
			case 6:
				tc();
				break;
			default:printf("请在1-6之间选择！");
		}
		
	}while(a!=6);
}

//开户
void kh(){
	int card,pwd1,pwd2;
	printf("欢迎来到开户窗口\n");
	
	
	printf("请输入卡号：");
	scanf("%d",&card);
	printf("请输入密码：");
	
	while(1){
		scanf("%d",&pwd1);
		printf("请确认密码：");
		scanf("%d",&pwd2);
		
		//判断两次密码是否一致
		if(pwd1==pwd2){
			//保存用户信息
			a[j][0]=card;//卡号
			a[j][1]=pwd1;//保存
			a[j][2]=0;
			
			j++;//用户下标加1
			printf("开户成功!请按回车返回主界面:");
			break;
		}else{
			printf("两次密码不一致！\n");
			printf("请重新输入：");
		}
	
	}
}

int login(){
	int card, pwd,i,flag=-1;//-1表示登陆失败 其他值都表示登陆成功!
	printf("请先登录!\n");	
	printf("请输入卡号：");
	scanf("%d",&card);
	printf("请输入密码：");
	scanf("%d",&pwd);
	
	//登陆验证
	for(i=0;i<100;i++){
		//输入的账号密码和数组中的某一对账号密码匹配表示登陆成功
		if(card==a[i][0]&&pwd==a[i][1]){
			flag=i;//把用户下表赋给flag
			break;
		}
	}
	
	return flag;
	
}

//存款
void ck(){
	int flag = login();
	int money;
	if(flag!=-1){
		printf("请输入存款金额：");
		scanf("%d",&money);
		if(money>0){
			//给用户加上对应的存款金额
			a[flag][2]+=money;
			printf("存款成功！\n");
			printf("您本次存款%d元，账户余额%d元！\n",money,a[flag][2]);
		}else{
			printf("输入的金额有误！\n");
		}
		printf("按回车返回主界面：");
	}else{
		//登陆失败
		printf("账号或密码错误，请按回车返回主界面:");
	}
}

//取款
void qk(){
	int flag = login();
	int money;
	if(flag!=-1){
		printf("请输入取款金额：");
		scanf("%d",&money);
		
		if(money>0&&money<=a[flag][2]){
			//给用户减去对应金额
			a[flag][2]-=money;
			printf("取款成功！\n");
			printf("您本次取款%d元，账户余额%d元！\n",money,a[flag][2]);
		}else{
			printf("输入的金额有误或余额不足！\n");
		}
		printf("按回车返回主界面：");
	}else{
		//登陆失败
		printf("账号或密码错误，请按回车返回主界面:");
	}
}

//查询余额
void cx(){
	int flag = login();
	if(flag!=-1){
		printf("您的账户余额是%d元\n",a[flag][2]);
		printf("请按回车返回主界面：");
	}else{
		//登陆失败
		printf("账号或密码错误，请按回车返回主界面:");
	}
}

//转账
void zz(){
	int flag = login();
	int zh,i,k=0;//0表示账号不存在
	int zzmoney;//转账金额
	if(flag!=-1){
		printf("请输入转账账号：");
		scanf("%d",&zh);
		//验证账号是否存在
		for(i=0;i<100;i++){
			//只需验证账号是否存在
			if(zh==a[i][0]){
				k=1;//账号存在
				break;
			}
		}
		
		if(k==1){//账号存在
			printf("请输入转账金额：");
			scanf("%d",&zzmoney);
			//判断转账金额是否大于余额
			if(zzmoney<=a[flag][2]){
				//自己的账户减钱
				a[flag][2]-=zzmoney;
				
				//对方的账户加钱
				a[i][2]+=zzmoney;
				
				//提示成功
				printf("转账%d元成功！您的余额是%d元！\n",zzmoney,a[flag][2]);
				printf("请按回车返回主界面：");
				
			}else{
				printf("余额不足，请按回车回到主界面：");
			}
			
			
		}else{
			printf("对方账号有误，按回车回到主界面：");
		}
		
	}else{
		//登陆失败
		printf("账号或密码错误，请按回车返回主界面:");
	}
}

//退出
void tc(){
	
}

//清屏
void clear(){
	system("cls");
}