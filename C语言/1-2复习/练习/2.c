/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //2������һ��Сд��ĸ��������Сд��ĸ��ASCII�� �� ��Ӧ�Ĵ�д��ĸ (��ʾ���ַ���%c����ʽ������ַ�  ��%d����ʽ�����ASCIIֵ)
    char c;
    printf("������һ��Сд��ĸ:");
    scanf("%c",&c);
    //���ַ��ͺ����ͼ���ʱ���ַ���ת����ASCIIֵ�����ͼ���
    printf("���������ĸ�� %c ����ASCII��%d  ���Ĵ�д��ĸ�� %c",c,c,c-32);
    
}