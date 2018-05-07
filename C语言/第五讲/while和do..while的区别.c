/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	
	//在某些问题上，while和do..while的结果是一样的
	//区别：while先判断，再执行，如果表达式不成立，循环一次也 不会执行
			//do..while 先执行，再判断，如果表达式一开始就不成立，程序也至少会执行一次！ 
	
	
    int i=-1;
    //一次也不会执行
    while(i>0){
    	printf("这是while循环");
    	i++;
    }
    
    
    //至少执行一次
    do{
    	printf("这是do .. while循环");
    	i++;	
    }while(i>0);
}