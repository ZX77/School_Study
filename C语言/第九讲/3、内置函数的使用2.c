/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    char c;
    printf("������һ��Сд��ĸ:");
    c=getchar();//ר����������һ���ַ������� scanf("%c",&c);
    printf("ת���ɴ�д��ĸ��%c\n",toupper(c));
    
    printf("������һ����д��ĸ��");
    fflush(stdin);//������̻���
    c=getchar();
    printf("ת����Сд��ĸ��%c",tolower(c));
}