/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //continue ��������ѭ����������һ��ѭ��
    //continue ǰ���������Ȼ��ִ�У�ֻ������continue��������ݲ�ִ��
    
    int i=0;
    while(i<5){
    	printf("********************************************\n");
    	i++;
    	if(i%2==0){
    		continue;
    	}
    	printf("i = %d \n",i);
    }
}