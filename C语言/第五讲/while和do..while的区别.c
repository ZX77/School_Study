/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	
	//��ĳЩ�����ϣ�while��do..while�Ľ����һ����
	//����while���жϣ���ִ�У�������ʽ��������ѭ��һ��Ҳ ����ִ��
			//do..while ��ִ�У����жϣ�������ʽһ��ʼ�Ͳ�����������Ҳ���ٻ�ִ��һ�Σ� 
	
	
    int i=-1;
    //һ��Ҳ����ִ��
    while(i>0){
    	printf("����whileѭ��");
    	i++;
    }
    
    
    //����ִ��һ��
    do{
    	printf("����do .. whileѭ��");
    	i++;	
    }while(i>0);
}