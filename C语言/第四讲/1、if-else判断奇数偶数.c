/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //if else 判断奇偶
    
    //先判断if中的表达式返回真还是假，如果返回真则执行语句块1的内容，否则执行语句块2，
    //表达式一定要返回逻辑值（关系运算符和逻辑运算符）> >= != < <= == && || !
    //else 是可选
    
    //if(表达式){
    //	语句块1
	//}else{
	//	语句块2
	//}
    
    int a;
    printf("请输入一个数：");
    scanf("%d",&a);
    
    
    
    if(a%2==0){
    	
    	//如果括号中的表达式返回真，则进来这里
    	printf("这个数是偶数！");
    }else{
    
    	//如果括号中的表达式返回假，则进来这里
    	printf("这个数是奇数！");
    }
    
    printf("这是if else 后面的内容！");
}