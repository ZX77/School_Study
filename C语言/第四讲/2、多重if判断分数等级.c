/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //����if ���������ϵ����ʹ�ö���if��
    //�ж��������if�����else if��������ж�����
    //else Ҳ�ǿ�ѡ�ģ�����У�һ��Ҫ���ڶ���if ������棡
    
    //if(){
    	
    //}else if(){
    
    //}else if(){
    
    //}
    //....
    //}else{
    	
    //}
    
    
    //�ж���������ĵȼ� 
    //>=90 ��
    //80-89 ��
    //60-79 ��
    //<60 ��
    
    int score;
    printf("������ѧ��������");
    scanf("%d",&score);
    if(100>=score&&score>=90){
    	printf("���ѧ���ķ������ţ�");
    }else if(80<=score&&score<=89){
    	printf("���ѧ���ķ�������!");
    }else if(60<=score&&score<=79){
    	printf("���ѧ���ķ�������!");
    }else if(0<=score&&score<60){
    	printf("���ѧ���ķ����ǲ");
    }else{
    	printf("��������ȷ�ķ���");
    }
    
}