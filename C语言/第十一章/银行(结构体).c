#include "stdio.h"

//ʹ�ýṹ��������Ϊ�û���
struct users{
	int num;//����
	int pwd;//����
	char uname[20];//�û���
	float money;//���
}u[100];

int j=0;//��¼�û���

void kh();
void ck();
void qk();
void cx();
void zz();
void tc();

int login();//��½

void main(){
	int a;
	printf("**********************************��**********************************\n");
	printf("*                                                                    *\n");
	printf("*                                                                    *\n");
	printf("*                        ��ӭ�����й�����                          *\n");
	printf("*                                                                    *\n");
	printf("*                                                                    *\n");
	printf("**********************************��**********************************\n\n\n\n");
	
	do{
		printf("\t\t��ѡ����Ҫ�����������\n");
		printf("\t\t\t1������\n");
		printf("\t\t\t2�����\n");
		printf("\t\t\t3��ȡ��\n");
		printf("\t\t\t4����ѯ���\n");
		printf("\t\t\t5��ת��\n");
		printf("\t\t\t6���˳�\n");
		printf("\t\t��ѡ����Ҫ�����ҵ��");
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
			default:printf("����1-6֮��ѡ��");
		}
		
	}while(a!=6);
}

int login(){
	int num,pwd,i,flag=-1;
	
	printf("���ȵ�½!\n");
	printf("�������˺ţ�");
	scanf("%d",&num);
	printf("���������룺");
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
	
	
	printf("��ѡ���˿���ҵ��!\n");
	printf("�����뿨�ţ�");
	scanf("%d",&u[j].num);
	printf("���������룺");
	scanf("%d",&u[j].pwd);
	fflush(stdin);
	printf("������������");
	scanf("%s",&u[j].uname);
	u[j].money=0;//���Ĭ��Ϊ0
	
	j++;
	
	printf("�����ɹ������س����������棺");
}

void ck(){
	int flag = login();
	int je;
	if(flag!=-1){
		printf(" [%s] �������ӭ����\n",u[flag].uname);
		printf("����������:");
		scanf("%d",&je);
		u[flag].money+=je;
		printf("���ɹ������δ��%dԪ���˻����%.2fԪ!\n",je,u[flag].money);
		printf("���س����������棺");
		
	}else{
		printf("��½ʧ�ܣ����س����������棺");
	}
}

void qk(){
	printf("��ѡ����ȡ��ҵ��!");
}

void cx(){
	printf("��ѡ���˲�ѯ���ҵ��!");
}

void zz(){
	printf("��ѡ����ת��ҵ��!");
}

void tc(){
	printf("��ѡ�����˳�!");
}