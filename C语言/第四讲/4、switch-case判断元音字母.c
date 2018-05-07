/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //switch - case - break - default  多路判断语句
    //判断基本数据类型
    //switch(需要判断的值){
	//	case 值 :
	//		语句;
	//		break;   
			
	//	case 值 :
	//		语句;
	//		break;    
    
    //	case 值 :
	//		语句;
	//		break;   
	 
    //	case可以有多个........
    	
    //	default:
    //		语句; 
    
    //}
    
    //判断一个字母是否是元音字母
    char c;
    printf("请输入一个字母：");
    scanf("%c",&c);
    switch(c){
    	case 'a': //字符类型要加单引号 其他不需要
    		printf("您请输入的是元音字母a!");
    		break;//没有break;程序会往下运行
    	case 'e':
    		printf("您请输入的是元音字母e!");
    		break;
    	case 'i':
    		printf("您请输入的是元音字母i!");
    		break;
    	case 'o':
    		printf("您请输入的是元音字母o!");
    		break;
    	case 'u':
    		printf("您请输入的是元音字母u!");
    		break;
    	default:
    		printf("您输入的不是元音字母！");
    }
    
}