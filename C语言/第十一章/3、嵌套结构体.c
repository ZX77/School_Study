/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //生日 嵌套结构体
    struct date{
    	int year;
    	int month;
    	int day;	
    };
    
    //学生结构体
    struct stuent{
    	int num;
    	char stuname[20];
    	struct date birthday;//嵌套结构体
    }stu1;
    
    
    //给嵌套结构体赋值
    stu1.num=1000;
    
    //姓名
    printf("请输入学生姓名：");
    scanf("%s",&stu1.stuname);
    
    //生日
    //bithday对于stu1来说是成员
    //year month day是bithday的成员
    stu1.birthday.year=1991;
    stu1.birthday.month=9;
    stu1.birthday.day=1;
    
    
    
    printf("学生的编号是 %d ,姓名是%s,生日是%d-%d-%d",stu1.num,stu1.stuname,stu1.birthday.year,stu1.birthday.month,stu1.birthday.day);
    
    
    
}