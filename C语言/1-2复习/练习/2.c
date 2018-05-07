/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //2、输入一个小写字母，输出这个小写字母的ASCII码 和 对应的大写字母 (提示：字符以%c的形式输出是字符  以%d的形式输出是ASCII值)
    char c;
    printf("请输入一个小写字母:");
    scanf("%c",&c);
    //当字符型和整型计算时，字符会转换成ASCII值和整型计算
    printf("您输入的字母是 %c 它的ASCII是%d  它的大写字母是 %c",c,c,c-32);
    
}