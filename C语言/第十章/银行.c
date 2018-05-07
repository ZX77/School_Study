#include "stdio.h"


int a[100][3];//用二维数组保存用户开户信息：行数：保存用户个数  列表示 0卡号 1、密码 2、余额
int j=0;//用户在数组中的下标

void kh();
void ck();
void qk();
void cx();
void zz();
void tc();

int login();//登陆

void qp();//清屏

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
				qp();//清屏
				kh();//开户业务
				getch();//暂停 输入单个字符(不会吧输出的字符显示出来)   getchar() （会把输出的字符显示出来）
				qp();//清屏
				break;
			case 2:
				qp();
				ck();
				getch();
				qp();
				break;
			case 3:
				qp();
				qk();
				getch();
				qp();
				break;
			case 4:
				qp();//清屏
				cx();
				getch();
				qp();
				break;
			case 5:
				qp();
				zz();
				getch();
				qp();
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
	int card,pwd;//卡号，密码
	printf("欢迎来到开户窗口!\n");
	printf("请输入卡号：");
	scanf("%d",&card);
	printf("请输入密码：");
	scanf("%d",&pwd);
	
	a[j][0]=card;//把用户填写的卡号赋给数组的第一列
	a[j][1]=pwd;//保存密码
	a[j][2]=0;//余额默认为0
	
	printf("开户成功！按回车回到主界面：");
	j++;//开户数加一
}

//登陆
int login(){
	int card,pwd,i,flag=-1;//-1表示登陆失败 ，其他是用户下标 
	printf("请先登陆!\n");
	printf("请输入卡号：");
	scanf("%d",&card);
	printf("请输入密码：");
	scanf("%d",&pwd);
	
	//登陆验证（用输入的账号密码在用户库中进行对比查询）
	for(i=0;i<100;i++){
		//卡号和用户库和卡号相同以及密码也要一致
		if(card==a[i][0]&&pwd==a[i][1]){
			flag=i;//把用户下表赋给flag
			break;
		}
	}
	
	return flag;
	
	
}



void ck(){
	int flag=login();
	int ckje;
	if(flag!=-1){
		printf("请输入存款金额:");
		scanf("%d",&ckje);
		
		//把用户的存款金额加到余额中
		a[flag][2]+=ckje;
		
		printf("存款成功，您本次存款%d元，账户余额%d元\n",ckje,a[flag][2]);
		printf("请按回车到主界面选择其他业务：");
		
	}else{
		printf("账号或密码错误，请按回车返回主界面！");
	}
}

void qk(){
	printf("您选择了取款业务!");
}

void cx(){
	int flag= login();//调用登陆方法
	
	if(flag!=-1){//登陆成功
		printf("您的余额是 %d !\n",a[flag][2]);
		printf("请按回车回到主界面：");
		
	}else{
		printf("账号或密码错误，请按回车返回主界面！");
	}
	
}

void zz(){
	printf("您选择了转账业务!");
}

void tc(){
	printf("您选择了退出!");
}

void qp(){
	system("cls");	
}