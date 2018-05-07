/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //scanf 输入函数
    //输入占位符 
    //%d 整型
    //%f 浮点型
    //%c 字符型
    int a;
    float f;
    char c;
    printf("请输入第一个数字：");
    scanf("%d",&a);//表示把接收到用户的输入数据存放在a变量中
    
    printf("请输入第二个数字");
    scanf("%f",&f);
    
    //printf("请输入一个字符：");
   // scanf("%c",&c);
    
    printf("您输入的第一个数字是 %d  第二个数字是%.2f ",a,f);
 
    
}