/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //计算两个数的和，显示结果后，输n退出，其他键继续
    int a,b;
    char c;
    do{
	    printf("请输入两个整数，用空格隔开：");
	    scanf("%d %d",&a,&b);
	    printf("结果是%d\n",a+b);
	    
	    printf("输入e退出，其他键继续：");
	    fflush(stdin);//清除键盘缓存（先有一个输入，然后又输入字符的情况，需要清除键盘缓存）
	    scanf("%c",&c);
    }while(c!='e');
}