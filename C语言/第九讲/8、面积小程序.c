/* Note:Your choice is C IDE */
#include "stdio.h"

void cfx();
void sjx();
void yx();

void main()
{
    int select;
    
    
    while(1){
    	printf("0���˳� 1�������� 2�������� 3��Բ�Σ�\n");
   		printf("��ѡ����Ҫ�����ͼ�Σ�");
    	scanf("%d",&select);
    	if(select==0){//�����0���˳�����
    		break;
    	}
    	switch(select){
    		case 1:cfx();break;
    		case 2:sjx();break;
    		case 3:yx();break;
    		default:printf("����0-3��ѡ��");
    	}
    }
}

void cfx(){
	int x,y;
	printf("�����볤���εĳ��Ϳ�:");
	scanf("%d %d",&x,&y);
	printf("�����ε������%d\n",x*y);	
}

void sjx(){
	int a,h;
	printf("�����������εĵױߺ͸ߣ�");
	scanf("%d %d",&a,&h);
	printf("�����ε������%.2f\n",a*h/2.0);
}

void yx(){
	int r;
	printf("������Բ�εİ뾶��");
	scanf("%d",&r);
	printf("Բ�ε������%.2f\n",3.14*r*r);
}