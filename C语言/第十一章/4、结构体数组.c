/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //�ṹ������
    struct student{
    	int num;
    	char name[20];
    	float score;
    }stu[3];
    
    int i;
    for(i=0;i<3;i++){
    	printf("�������%d��ѧ����ѧ��:",i+1);
    	scanf("%d",&stu[i].num);
    	printf("�������%d��ѧ��������:",i+1);
    	fflush(stdin);
    	scanf("%s",&stu[i].name);
    	printf("�������%d��ѧ���ĳɼ�:",i+1);
    	scanf("%f",&stu[i].score);
    }
    
    //����ѧ������Ϣ
    printf("����ѧ������Ϣ���£�\n");
    printf("ѧ��\t����\t�ɼ�\n");
    for(i=0;i<3;i++){
    	 printf("%d\t%s\t%.2f\n",stu[i].num,stu[i].name,stu[i].score);
    }
    
}