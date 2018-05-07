/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    char c;
    printf("请输入一个小写字母:");
    c=getchar();//专用用来接收一个字符的输入 scanf("%c",&c);
    printf("转换成大写字母是%c\n",toupper(c));
    
    printf("请输入一个大写字母：");
    fflush(stdin);//清除键盘缓存
    c=getchar();
    printf("转换成小写字母是%c",tolower(c));
}