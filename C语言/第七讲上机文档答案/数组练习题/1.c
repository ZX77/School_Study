 /* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int a[5][3],i,j,sum=0,max=0,xh=0;
    for(i=0;i<5;i++){
    	printf("请输入学号为%d的语文，数学，英语成绩，空格隔开，回车结束：",100+i);
    	for(j=0;j<3;j++){
    		scanf("%d",&a[i][j]);
    	}
    }
    
    printf("学号\t语文\t数学\t英语\t总分\n");
    
    for(i=0;i<5;i++){
    	printf("%d\t",100+i);//学号
    	for(j=0;j<3;j++){
    		printf("%d\t",a[i][j]);//成绩
    		sum+=a[i][j];//每个学生的总分
    	}
    
    	printf("%d",sum);//输出总分
    	//6 3 15 12 15
    	//对比最高分
    	if(sum>max){
    		max=sum;
    		//xh=100+i;//记录最高分的学号(不能得到分数相同的学生)
    	}
    	sum=0;//分数要初始化！
    	printf("\n");//换行
    }
    
   // printf("\n最高分的学号是%d,总分是%d",xh,max);
   
   
   
   //为了判断最高分有相同学生的情况
   for(i=0;i<5;i++){
   		for(j=0;j<3;j++){
   			sum+=a[i][j];
   		}
   		if(max==sum){//如果学生的总分等于上面求出的最高分
   			printf("最高分的学生的学号是%d，总分是%d\n",100+i,max);
   		}
   		sum=0;
   }
}