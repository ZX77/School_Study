#include "stdio.h"

int a[100][3],j=0;//�����û���Ϣ�Ķ�ά����  �У���ʾ�û�  �У���ʾ�û���Ϣ�ֶ� 0������ 1������ 2�����

void kh();
void ck();
void qk();
void cx();
void zz();
void tc();

void clear();//����

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
				clear();//����
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
			default:printf("����1-6֮��ѡ��");
		}
		
	}while(a!=6);
}

//����
void kh(){
	int card,pwd1,pwd2;
	printf("��ӭ������������\n");
	
	
	printf("�����뿨�ţ�");
	scanf("%d",&card);
	printf("���������룺");
	
	while(1){
		scanf("%d",&pwd1);
		printf("��ȷ�����룺");
		scanf("%d",&pwd2);
		
		//�ж����������Ƿ�һ��
		if(pwd1==pwd2){
			//�����û���Ϣ
			a[j][0]=card;//����
			a[j][1]=pwd1;//����
			a[j][2]=0;
			
			j++;//�û��±��1
			printf("�����ɹ�!�밴�س�����������:");
			break;
		}else{
			printf("�������벻һ�£�\n");
			printf("���������룺");
		}
	
	}
}

int login(){
	int card, pwd,i,flag=-1;//-1��ʾ��½ʧ�� ����ֵ����ʾ��½�ɹ�!
	printf("���ȵ�¼!\n");	
	printf("�����뿨�ţ�");
	scanf("%d",&card);
	printf("���������룺");
	scanf("%d",&pwd);
	
	//��½��֤
	for(i=0;i<100;i++){
		//������˺�����������е�ĳһ���˺�����ƥ���ʾ��½�ɹ�
		if(card==a[i][0]&&pwd==a[i][1]){
			flag=i;//���û��±���flag
			break;
		}
	}
	
	return flag;
	
}

//���
void ck(){
	int flag = login();
	int money;
	if(flag!=-1){
		printf("���������");
		scanf("%d",&money);
		if(money>0){
			//���û����϶�Ӧ�Ĵ����
			a[flag][2]+=money;
			printf("���ɹ���\n");
			printf("�����δ��%dԪ���˻����%dԪ��\n",money,a[flag][2]);
		}else{
			printf("����Ľ������\n");
		}
		printf("���س����������棺");
	}else{
		//��½ʧ��
		printf("�˺Ż���������밴�س�����������:");
	}
}

//ȡ��
void qk(){
	int flag = login();
	int money;
	if(flag!=-1){
		printf("������ȡ���");
		scanf("%d",&money);
		
		if(money>0&&money<=a[flag][2]){
			//���û���ȥ��Ӧ���
			a[flag][2]-=money;
			printf("ȡ��ɹ���\n");
			printf("������ȡ��%dԪ���˻����%dԪ��\n",money,a[flag][2]);
		}else{
			printf("����Ľ����������㣡\n");
		}
		printf("���س����������棺");
	}else{
		//��½ʧ��
		printf("�˺Ż���������밴�س�����������:");
	}
}

//��ѯ���
void cx(){
	int flag = login();
	if(flag!=-1){
		printf("�����˻������%dԪ\n",a[flag][2]);
		printf("�밴�س����������棺");
	}else{
		//��½ʧ��
		printf("�˺Ż���������밴�س�����������:");
	}
}

//ת��
void zz(){
	int flag = login();
	int zh,i,k=0;//0��ʾ�˺Ų�����
	int zzmoney;//ת�˽��
	if(flag!=-1){
		printf("������ת���˺ţ�");
		scanf("%d",&zh);
		//��֤�˺��Ƿ����
		for(i=0;i<100;i++){
			//ֻ����֤�˺��Ƿ����
			if(zh==a[i][0]){
				k=1;//�˺Ŵ���
				break;
			}
		}
		
		if(k==1){//�˺Ŵ���
			printf("������ת�˽�");
			scanf("%d",&zzmoney);
			//�ж�ת�˽���Ƿ�������
			if(zzmoney<=a[flag][2]){
				//�Լ����˻���Ǯ
				a[flag][2]-=zzmoney;
				
				//�Է����˻���Ǯ
				a[i][2]+=zzmoney;
				
				//��ʾ�ɹ�
				printf("ת��%dԪ�ɹ������������%dԪ��\n",zzmoney,a[flag][2]);
				printf("�밴�س����������棺");
				
			}else{
				printf("���㣬�밴�س��ص������棺");
			}
			
			
		}else{
			printf("�Է��˺����󣬰��س��ص������棺");
		}
		
	}else{
		//��½ʧ��
		printf("�˺Ż���������밴�س�����������:");
	}
}

//�˳�
void tc(){
	
}

//����
void clear(){
	system("cls");
}