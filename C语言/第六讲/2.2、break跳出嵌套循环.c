/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //break����Ƕ��ѭ��
    //break��Ƕ��ѭ����ֻ������һ��ѭ��
    int i,j;
    for(i=0;i<5;i++){
    	for(j=0;j<10;j++){
    		if(j==2){
    			break;
    		}
    		printf("*");
    	}
    	printf("\n");
    }
}