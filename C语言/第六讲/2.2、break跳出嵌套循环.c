/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //break跳出嵌套循环
    //break在嵌套循环中只会跳出一层循环
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