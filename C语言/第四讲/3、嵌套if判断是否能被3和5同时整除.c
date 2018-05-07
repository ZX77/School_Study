/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //嵌套if 在一个if结构中嵌套另一个if结构 
    //如果第一个if返回假 则里面的if一个也不会执行
//    if(){
//     	if(){
//    		if(){
    			
//    		}
    		
//    	}	
//    }else{

//	  }


	//判断一个数是否能同时被3和5整除
	int num;
	printf("请输入一个整数：");
	scanf("%d",&num);
	if(num%3==0){//能被3整除
		
		if(num%5==0){//也能被5整除
			printf("这个数可以被3和5整除！");
		}else{
			printf("这个数可以被3整除，但不能被5整除！");
		}
	}else{
		printf("这个数不能被3整除！");
	}
	
	//等效于 (多层if就是&&)
	if(num%3==0&&num%5==0){
		printf("这个数可以被3和5整除！");
	}else{
		printf("这个数不能同时被3和5整除！");
	}
}