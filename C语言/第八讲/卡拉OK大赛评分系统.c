/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //����OK��������ϵͳ
    float a[10],max,min,sum=0;
    int i;
    printf("*                 ����OK��������ϵͳ                *\n");
    printf("-----------------------------------------------------\n");
    printf("        ��һ���ͼ������OK������ʽ��ʼ               \n");
    printf("-----------------------------------------------------\n");
    for(i=0;i<10;i++){
    	printf("���%dλ���д��:",i+1);
    	scanf("%f",&a[i]);
    }
    max=a[0];
    min=a[0];
    printf("�����д������:\n");
    for(i=0;i<10;i++){
    	printf("%.2f\t",a[i]);
    	if(i==4){
    		printf("\n");
    	}
    	if(a[i]>max){
    		max=a[i];
    	}
    	if(a[i]<min){
    		min=a[i];
    	}
    	sum+=a[i];
    }
    
    printf("\nȥ��һ����߷�:%.2f\n",max);
    printf("\nȥ��һ����ͷ�:%.2f\n",min);
    printf("\n��ѡ�����յ÷�:%.2f\n",(sum-max-min)/8);
}