/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //����1+2+3+4+...100�ĺ�
    int i=1,sum=0;
    while(i<=100){
    	
    	sum+=i;//�ۼ�i�ĺ͸���sum   sum=sum+i;
    	i++;
    }
    
    printf("1+2+3+...+100�ĺ��� %d \n",sum);
}