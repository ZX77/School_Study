/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //ͳ��20��ѧ����C���Գɼ�����ͳ��С��60�ֵģ�����80�ֵ�����
    int score[20],i=0,x=0,y=0;
    printf("������20��ѧ����C���Գɼ����ÿո�������س�������");
    for(i=0;i<20;i++){
    	scanf("%d",&score[i]);
    }
    
    printf("����ѧ���ɼ����£�\n");
    for(i=0;i<20;i++){
    	printf("%d\t",score[i]);
    	if(score[i]<60){
    		x++;//ͳ��С��60�ֵ�����
    	}
    	if(score[i]>80){
    		y++;//ͳ�ƴ���80�ֵ�����
    	}
    }
    
    printf("\n �ɼ�С��60�ֵ���%d�ˣ�����80�ֵ�%d��",x,y);
}