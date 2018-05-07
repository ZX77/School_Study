#include "stdio.h"

//使用结构体数组作为用户库
struct users{
	int num;//卡号
	int pwd;//密码
	char uname[20];//用户名
	float money;//余额
}u[100];

int j=0;//记录用户数

void kh();
void ck();
void qk();
void cx();
void zz();
void tc();

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
				system("cls");
				kh();
				getch();
				system("cls");
				break;
			case 2:
				system("cls");
				ck();
				getch();
				system("cls");
				break;
			case 3:
				qk();
				break;
			case 4:
				cx();
				break;
			case 5:
				zz();
				break;
			case 6:
				tc();
				break;
			default:printf("请在1-6之间选择！");
		}
		
	}while(a!=6);
}

int login(){
	int num,pwd,i,flag=-1;
	
	printf("请先登陆!\n");
	printf("请输入账号：");
	scanf("%d",&num);
	printf("请输入密码：");
	scanf("%d",&pwd);
	
	for(i=0;i<100;i++){
		if(num==u[i].num&&pwd==u[i].pwd){
			flag=i;
			break;
		}
	}
	
	return flag;
	
}

void kh(){
	
	
	printf("您选择了开户业务!\n");
	printf("请输入卡号：");
	scanf("%d",&u[j].num);
	printf("请输入密码：");
	scanf("%d",&u[j].pwd);
	fflush(stdin);
	printf("请输入姓名：");
	scanf("%s",&u[j].uname);
	u[j].money=0;//余额默认为0
	
	j++;
	
	printf("开户成功，按回车返回主界面：");
}

void ck(){
	int flag = login();
	int je;
	if(flag!=-1){
		printf(" [%s] 贵宾，欢迎您！\n",u[flag].uname);
		printf("请输入存款金额:");
		scanf("%d",&je);
		u[flag].money+=je;
		printf("存款成功，本次存款%d元，账户余额%.2f元!\n",je,u[flag].money);
		printf("按回车返回主界面：");
		
	}else{
		printf("登陆失败，按回车返回主界面：");
	}
}

void qk(){
	printf("您选择了取款业务!");
}

void cx(){
	printf("您选择了查询余额业务!");
}

void zz(){
	printf("您选择了转账业务!");
}

void tc(){
	printf("您选择了退出!");
}