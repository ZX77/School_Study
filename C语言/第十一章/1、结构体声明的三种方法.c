/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //�ṹ��
    //��һ�ֹ����������ͣ��������������͹�����һ���һ���������ͣ�
    //�ṹ��Ա���������Ϳ��Բ�һ��!
    //�����ں����� �Ľṹ��оֲ��ṹ�壬�����ں������ȫ�ֽṹ�塣���ͺ���һ����
    
    
    //1���������ṹ�壬�������ṹ�����
    //struct �ؼ���  student �ṹ������
    struct student{
    	int num;//ѧ��
    	char stuname[20];//����
    	int age;//����
    	float height;//���
    };
    //�����ṹ�����(�ؼ��� �ṹ������ �ṹ�����)
    //����ṹ������ö��Ÿ���
    struct student stu1,stu2;//stu1/stu2�ǽṹ�����
    
    
    
    //2���������ṹ��ʱֱ�������ṹ�����
    struct car{
    	char pp[20];
    	char xh[20];
    	float pl;
    	int price;
    }car1,car2;
    
    struct car car3; //��Ȼ���Լ��������ṹ�����
    
    //3��ֱ�������ṹ�����(����ʡ�Խṹ������)
    struct {
    	int num;
    	char gname[20];
    	float price;
    }goods1,goods2;
    
}