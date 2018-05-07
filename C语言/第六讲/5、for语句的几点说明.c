/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //1、for的第一个表达式（初始化）可以在for之前初始化，在括号中可以省略
    int i=1,sum=0;
    for(;i<=100;i++){
    	sum+=i;
    }
    printf("结果是  %d \n",sum);
    
    //2、for循环的第二个表达式，可以省略，省略后将没有上限，
    sum=0;
    for(i=0;;i++){
    	sum+=i;
    	if(i==100){
    		break;
    	}
    }
     printf("结果是  %d\n",sum);
     
     //3、for循环的第三个表达式，可以省略，省略后表示变量不改变，可能会出现死循环
     sum=0;
     for(i=0;i<=100;){
     	sum+=i;
     	i++;
     }
     printf("结果是  %d\n",sum);
     
     //死循环
     //while(1){
     //	printf("死循环....");
  //   }
}