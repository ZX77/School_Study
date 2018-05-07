/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //结构体的使用
    
    
    //1、结构体的声明
    struct student{
    	int num;//编号
    	char stuname[20];//姓名
    	int age;//年龄
    	char sex;
    	float height;//身高
    };
	
	//2、结构体的静态赋值 (赋值时需要注意 结构体成员的数量、数据类型)
	struct student stu1={1000,"张三",20,'M',180},stu2,stu3;
	
	stu1.num=2000;
	
	//3、结构体静态取值
	//使用结构体变量点（.）结构体成员名称 
	//占位符需要和结构体成员的数据类型一致
	printf("学生的编号是%d 学生的姓名是%s 学生的年龄是%d,学生的性别是%c,学生的身高是%.2f\n",stu1.num,stu1.stuname,stu1.age,stu1.sex,stu1.height);
	
	
	
	//结构体变量的动态赋值
	//用键盘输入给结构体变量赋值
	printf("请输入学生编号：");
	scanf("%d",&stu2.num);
	printf("请输入学生姓名：");
	fflush(stdin);//清除键盘缓存
	scanf("%s",&stu2.stuname);
	printf("请输入学生年龄:");
	scanf("%d",&stu2.age);
	
	printf("学生2的编号是%d,姓名是%s,年龄是 %d\n",stu2.num,stu2.stuname,stu2.age);
	
	
	//结构体变量可以整体赋值（把一个结构体的值全部赋给另外一个结构体）
	stu3=stu2;
	
	stu3.age=30;
	
	printf("学生3的编号是%d,姓名是%s,年龄是 %d",stu3.num,stu3.stuname,stu3.age);
}