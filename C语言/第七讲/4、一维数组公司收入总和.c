/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //���빫˾12���µ����룬�������
    float income[12],sum=0;
    int i;
    for(i=0;i<12;i++){
    	printf("�����빫˾��%d���µ�����:",i+1);
    	scanf("%f",&income[i]);
    	sum+=income[i];//���
    }
    
    printf("��˾�����ܺ���%.2f",sum);
    
}