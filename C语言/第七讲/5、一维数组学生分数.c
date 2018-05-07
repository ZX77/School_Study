/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //统计20个学生的C语言成绩，并统计小于60分的，大于80分的人数
    int score[20],i=0,x=0,y=0;
    printf("请输入20个学生的C语言成绩，用空格隔开，回车结束：");
    for(i=0;i<20;i++){
    	scanf("%d",&score[i]);
    }
    
    printf("所有学生成绩如下：\n");
    for(i=0;i<20;i++){
    	printf("%d\t",score[i]);
    	if(score[i]<60){
    		x++;//统计小于60分的人数
    	}
    	if(score[i]>80){
    		y++;//统计大于80分的人数
    	}
    }
    
    printf("\n 成绩小于60分的有%d人，大于80分的%d人",x,y);
}