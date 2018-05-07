/* Note:Your choice is C IDE */
#include "stdio.h"

void pp();

void mm();

void main()
{
    //嵌套函数
    //一个函数嵌套调用另一个函数
    pp();
    
}

void pp(){
	mm();
}

void mm(){
	printf("************************");	
}