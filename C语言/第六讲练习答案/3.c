/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //3����д�������һ�����Σ�Ҫ����Ƕ��forѭ��ʵ�֣�
    int i,j;
    for(i=0;i<5;i++){
    	for(j=0;j<15;j++){
    		if((i==1||i==2||i==3)&&(j>0&&j<14)){
    			printf(" ");
    		}else{
    			printf("*");	
    		}
    	}
    	printf("\n");
    }
}