/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //3、编写程序，计算某班级C语言的平均成绩和及格率（假设班上有30个学生）
    int a[10],i,sum=0,jg=0;//sum总和  jg 及格人数
    printf("请输入10个学生的C语言成绩，空格隔开，回车结束：");
    for(i=0;i<10;i++){
    	scanf("%d",&a[i]);
    	
    	sum+=a[i];//总和
    	
    	if(a[i]>=60){
    		jg++;//及格人数加1
    	}
    }
    
    printf("平均成绩是%.2f 及格率是%.2f%%",sum/10.0,jg/10.0*100);
}