/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //1����д�������1~100�з�6�ı��������֣�Ҫ����whileѭ��ʵ�֣�ÿ�����8����
    int i=0,count=0;
    while(i<100){
    	i++;
    	if(i%6==0){
    		continue;
    	}
    	printf("%d ",i);
    	count++;
    	if(count%8==0){
    		printf("\n");
    	}
    }
}