/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //do--while循环输出5行星号
    //先执行do中的语句，然后再判断表达式是否成立
    //do{
    	//循环语句块;
    //}while(表达式);
    
    int i=5;
    do{
    	printf("*******************\n");
    	i--;
    }while(i>0);
}