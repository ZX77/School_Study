/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //作业1：用户不断输入字符，输入‘A’（区分大小写）时，退出程序。
    char c;
    printf("请随意输入字符，输入‘A’结束程序:");
    while(c!='A'){
    	scanf("%c",&c);	
    }
    printf("您已退出程序！");
}