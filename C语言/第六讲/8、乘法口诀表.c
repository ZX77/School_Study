/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //³Ë·¨¿Ú¾÷±í
    int i,j;
    for(i=1;i<=9;i++){
    	for(j=1;j<=i;j++){
    		printf("%d¡Á%d = %d  ",j,i,i*j);
    	}
    	printf("\n");
    }
}