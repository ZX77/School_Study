#include "stdio.h"


int a[100][3];//�ö�ά���鱣���û�������Ϣ�������������û�����  �б�ʾ 0���� 1������ 2�����
int j=0;//�û��������е��±�

void kh();
void ck();
void qk();
void cx();
void zz();
void tc();

int login();//��½

void qp();//����

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
				qp();//����
				kh();//����ҵ��
				getch();//��ͣ ���뵥���ַ�(�����������ַ���ʾ����)   getchar() �����������ַ���ʾ������
				qp();//����
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
				qp();//����
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
			default:printf("����1-6֮��ѡ��");
		}
		
	}while(a!=6);
}


//����
void kh(){
	int card,pwd;//���ţ�����
	printf("��ӭ������������!\n");
	printf("�����뿨�ţ�");
	scanf("%d",&card);
	printf("���������룺");
	scanf("%d",&pwd);
	
	a[j][0]=card;//���û���д�Ŀ��Ÿ�������ĵ�һ��
	a[j][1]=pwd;//��������
	a[j][2]=0;//���Ĭ��Ϊ0
	
	printf("�����ɹ������س��ص������棺");
	j++;//��������һ
}

//��½
int login(){
	int card,pwd,i,flag=-1;//-1��ʾ��½ʧ�� ���������û��±� 
	printf("���ȵ�½!\n");
	printf("�����뿨�ţ�");
	scanf("%d",&card);
	printf("���������룺");
	scanf("%d",&pwd);
	
	//��½��֤����������˺��������û����н��жԱȲ�ѯ��
	for(i=0;i<100;i++){
		//���ź��û���Ϳ�����ͬ�Լ�����ҲҪһ��
		if(card==a[i][0]&&pwd==a[i][1]){
			flag=i;//���û��±���flag
			break;
		}
	}
	
	return flag;
	
	
}



void ck(){
	int flag=login();
	int ckje;
	if(flag!=-1){
		printf("����������:");
		scanf("%d",&ckje);
		
		//���û��Ĵ����ӵ������
		a[flag][2]+=ckje;
		
		printf("���ɹ��������δ��%dԪ���˻����%dԪ\n",ckje,a[flag][2]);
		printf("�밴�س���������ѡ������ҵ��");
		
	}else{
		printf("�˺Ż���������밴�س����������棡");
	}
}

void qk(){
	printf("��ѡ����ȡ��ҵ��!");
}

void cx(){
	int flag= login();//���õ�½����
	
	if(flag!=-1){//��½�ɹ�
		printf("��������� %d !\n",a[flag][2]);
		printf("�밴�س��ص������棺");
		
	}else{
		printf("�˺Ż���������밴�س����������棡");
	}
	
}

void zz(){
	printf("��ѡ����ת��ҵ��!");
}

void tc(){
	printf("��ѡ�����˳�!");
}

void qp(){
	system("cls");	
}