/* Note:Your choice is C IDE */
#include "stdio.h"

int acc[10][3],i=0;//�û��˺���Ϣ ���ţ����룬���   i ��ʶϵͳ��ǰע����û���


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
    printf("************************��************************\n");
    printf("*                                                *\n");
    printf("*                                                *\n");
    printf("*                ��ӭ�����ͼ���У�              *\n");
    printf("*                                                *\n");
    printf("*                                                *\n");
    printf("************************��************************\n");
    printf("\n\n\n");
    
    
    while(1){
    printf("\t��ѡ����Ҫ�����������\n");
    printf("\t\t1������\n");
    printf("\t\t2�����\n");
    printf("\t\t3��ȡ��\n");
    printf("\t\t4����ѯ���\n");
    printf("\t\t5��ת��\n");
    printf("\t\t6���˳�\n");
    printf("\t��������Ҫ�������Ŀ��");
    scanf("%d",&i);
    if(i==6){
    	break;
    }
    switch(i){
    	case 1 :
    		cls();
    		kaihu();
    		getch();//��ͣ �����κ��ַ����������
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
 			printf("��������ȷ�Ĳ�����ţ�");
    }
    
    }
    
}

//����    
void kaihu(){
	int card,mima;
	printf("\t\t��ӭ�����������棺\n");
	//����  ����  ���
	printf("�����뿨�ţ�");
	scanf("%d",&card);
	printf("���������룺");
	scanf("%d",&mima);
	
	acc[i][0]=card;//�ѿ��Ÿ�������ĵ�һ��
	acc[i][1]=mima;//�����븶���ڶ���
	acc[i][2]=0;//����ʼ��Ϊ0
	
	
	i++;//�û�����1
	
	printf("��ϲ��ע��ɹ����밴��������������棡");
	
}

//���
void cunkuan(){
	int jine=0;
	int flag = login();
	if(flag!=-1){
		
		printf("���������");
		scanf("%d",&jine);
		acc[flag][2]=acc[flag][2]+jine;//���û�����Ľ��ӵ��˻������
		printf("�����δ��%d���˻����Ϊ%d\n",jine,acc[flag][2]);
		printf("�밴�س�������������:");
	}else{
		printf("��¼ʧ�ܣ����س�������������!");
	}
}

//ȡ��
void qukuan(){
	printf("��ѡ�����ȡ��ҵ��\n");
}

//��ѯ���
void chaxun(){
	int flag = login();
	//-1��ʾ��¼ʧ��
	//flag ���û��кţ�id��
	if(flag!=-1){
		//��¼�ɹ�������ڵ�����
		printf("�û�ID�� %d �����˻������%d\n",flag,acc[flag][2]);
		printf("�밴���������������:");
	}else{
		printf("��¼ʧ�ܣ����س�������������!");
	}
	
}

//ת��
void zhuanzhang(){
	
	printf("��ѡ�����ת��ҵ��\n");
}

//��¼
int login(){
	int card,mima,i,flag=-1;//��ʾ��¼ʧ��
	printf("���ȵ�¼��\n");
	printf("�����뿨�ţ�");
	scanf("%d",&card);
	printf("�����뿨���룺");
	scanf("%d",&mima);	
	
	//�ж���û������û�
	for(i=0;i<10;i++){
		//����Ŀ�������Ҫ���˺������е�ͬʱƥ��
		if(card==acc[i][0]&&mima==acc[i][1]){
			flag=i;//�ҵ�ƥ����˺����룬�ı��ʶ
			break;
		}
	}
	return flag;//����¼�����ʶ���ص��õĵط�
	
}


//�������Զ��庯��
void cls(){
	system("cls");//����	
}