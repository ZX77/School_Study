/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int i,j;
    for(i=0;i<10;i++){
    	for(j=0;j<=10-i;j++){ 
    		printf("*");
    	}
    	printf("\n");
    }
    
    //i=0 j=10   
    //i=1 j=9   
    //i=2   j=8
}