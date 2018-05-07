/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //结构体
    //是一种构造数据类型（将基本数据类型构造在一起的一种数据类型）
    //结构成员的数据类型可以不一致!
    //定义在函数中 的结构体叫局部结构体，定义在函数外叫全局结构体。（和函数一样）
    
    
    //1、先声明结构体，再声明结构体变量
    //struct 关键字  student 结构体名称
    struct student{
    	int num;//学号
    	char stuname[20];//姓名
    	int age;//年龄
    	float height;//身高
    };
    //声明结构体变量(关键字 结构体名称 结构体变量)
    //多个结构体变量用逗号隔开
    struct student stu1,stu2;//stu1/stu2是结构体变量
    
    
    
    //2、在声明结构体时直接声明结构体变量
    struct car{
    	char pp[20];
    	char xh[20];
    	float pl;
    	int price;
    }car1,car2;
    
    struct car car3; //仍然可以继续声明结构体变量
    
    //3、直接声明结构体变量(可以省略结构体名称)
    struct {
    	int num;
    	char gname[20];
    	float price;
    }goods1,goods2;
    
}