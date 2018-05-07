/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //结构体数组
    struct student{
    	int num;
    	char name[20];
    	float score;
    }stu[3];
    
    int i;
    for(i=0;i<3;i++){
    	printf("请输入第%d个学生的学号:",i+1);
    	scanf("%d",&stu[i].num);
    	printf("请输入第%d个学生的姓名:",i+1);
    	fflush(stdin);
    	scanf("%s",&stu[i].name);
    	printf("请输入第%d个学生的成绩:",i+1);
    	scanf("%f",&stu[i].score);
    }
    
    //三个学生的信息
    printf("三个学生的信息如下：\n");
    printf("学号\t姓名\t成绩\n");
    for(i=0;i<3;i++){
    	 printf("%d\t%s\t%.2f\n",stu[i].num,stu[i].name,stu[i].score);
    }
    
}