/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //����1+3+5+7+...+99 ������
    int i = 0,sum=0;
    do{
    	if(i%2==1){//������Ҫ���
    		sum+=i;
    	}
    	i++;
    }while(i<100);
    
    printf("�����%d",sum);
}