/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //switch - case - break - default  ��·�ж����
    //�жϻ�����������
    //switch(��Ҫ�жϵ�ֵ){
	//	case ֵ :
	//		���;
	//		break;   
			
	//	case ֵ :
	//		���;
	//		break;    
    
    //	case ֵ :
	//		���;
	//		break;   
	 
    //	case�����ж��........
    	
    //	default:
    //		���; 
    
    //}
    
    //�ж�һ����ĸ�Ƿ���Ԫ����ĸ
    char c;
    printf("������һ����ĸ��");
    scanf("%c",&c);
    switch(c){
    	case 'a': //�ַ�����Ҫ�ӵ����� ��������Ҫ
    		printf("�����������Ԫ����ĸa!");
    		break;//û��break;�������������
    	case 'e':
    		printf("�����������Ԫ����ĸe!");
    		break;
    	case 'i':
    		printf("�����������Ԫ����ĸi!");
    		break;
    	case 'o':
    		printf("�����������Ԫ����ĸo!");
    		break;
    	case 'u':
    		printf("�����������Ԫ����ĸu!");
    		break;
    	default:
    		printf("������Ĳ���Ԫ����ĸ��");
    }
    
}