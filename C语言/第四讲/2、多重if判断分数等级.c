/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //多重if （两种以上的情况使用多重if）
    //有多种情况在if后面加else if继续添加判断条件
    //else 也是可选的，如果有，一定要放在多重if 的最后面！
    
    //if(){
    	
    //}else if(){
    
    //}else if(){
    
    //}
    //....
    //}else{
    	
    //}
    
    
    //判断输入分数的等级 
    //>=90 优
    //80-89 良
    //60-79 中
    //<60 差
    
    int score;
    printf("请输入学生分数：");
    scanf("%d",&score);
    if(100>=score&&score>=90){
    	printf("这个学生的分数是优！");
    }else if(80<=score&&score<=89){
    	printf("这个学生的分数是良!");
    }else if(60<=score&&score<=79){
    	printf("这个学生的分数是中!");
    }else if(0<=score&&score<60){
    	printf("这个学生的分数是差！");
    }else{
    	printf("请输入正确的分数");
    }
    
}