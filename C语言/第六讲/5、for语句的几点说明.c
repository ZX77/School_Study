/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //1��for�ĵ�һ�����ʽ����ʼ����������for֮ǰ��ʼ�����������п���ʡ��
    int i=1,sum=0;
    for(;i<=100;i++){
    	sum+=i;
    }
    printf("�����  %d \n",sum);
    
    //2��forѭ���ĵڶ������ʽ������ʡ�ԣ�ʡ�Ժ�û�����ޣ�
    sum=0;
    for(i=0;;i++){
    	sum+=i;
    	if(i==100){
    		break;
    	}
    }
     printf("�����  %d\n",sum);
     
     //3��forѭ���ĵ��������ʽ������ʡ�ԣ�ʡ�Ժ��ʾ�������ı䣬���ܻ������ѭ��
     sum=0;
     for(i=0;i<=100;){
     	sum+=i;
     	i++;
     }
     printf("�����  %d\n",sum);
     
     //��ѭ��
     //while(1){
     //	printf("��ѭ��....");
  //   }
}