/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //2、编写程序，统计用户输入的字符数，按回车键结束。
    char c;
    int i=0;
    printf("请随便输入字符：");
    while(c!='\n'){
    	scanf("%c",&c);
    	i++;
    }
    printf("您一共输入了%d个字符!",i);
}