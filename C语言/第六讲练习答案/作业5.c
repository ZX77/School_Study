/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //���2000-2500������������ꡣ
    int i;
    for(i=2000;i<=2500;i++){
    	if((i%4==0&&i%100!=0)||i%400==0){
    		printf("%d\t",i);
    	}
    }
}