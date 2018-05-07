/* Note:Your choice is C IDE */
#include "stdio.h"
#include "math.h"//如果要使用数学函数，需要导入math.h
void main()
{
    //内置函数（系统函数）
    //系统定义好的，直接拿来使用的函数
    //printf scanf strlen strcmp strcat ...
    
    //1、sqrt(x) x的平方根函数
    
    //2的平方根
    //int a=2;
    //printf("%.3f",sqrt(a));
    
    
    //2、pow(x,y) x的y次幂
    //double f;
   // f = pow(2,3); //可以定义对应返回值类型的变量来接收结果
    //printf("%f",f);
    
    
    //3、ceil(x) 求不小于x的最小整数
    
   // printf("%.0f",ceil(1.24345));
    
    //4、floor (x) 不大于x的最大整数
    //printf("%.0f",floor(1.24345));
    
    //5、toupper tolower 转大小写函数
    //printf("%c\n",toupper('a'));
   // printf("%c",tolower(65));
   
   //6、rand()随机数(伪随机)
   printf("产生一个随机数：%d\n",rand());
   printf("产生一个随机数：%d\n",rand());
   
   //7、exit(1) 终止程序
   
   exit(1);
   
   printf("产生一个随机数：%d\n",rand());
   printf("产生一个随机数：%d\n",rand());
}

