package txz;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/*
 *推箱子游戏的主类 
 * */
public class MainPanel extends JPanel implements KeyListener,MouseListener,ActionListener{

	//选关
	int level=1;
	//原始地图的值永远不变
	int map[][]= new int[20][20];
	//临时地图的值在推箱子过程会不断改变，每改变一次就刷新一次界面
	int tempMap[][] = new int[20][20];
	//人的坐标
	int manx,many;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image[] img={
			kit.getImage("pic/0.gif"),
			kit.getImage("pic/1.gif"),
			kit.getImage("pic/2.gif"),
			kit.getImage("pic/3.gif"),
			kit.getImage("pic/4.gif"),
			kit.getImage("pic/5.gif"),
			kit.getImage("pic/6.gif"),
			kit.getImage("pic/7.gif"),
			kit.getImage("pic/8.gif"),
			kit.getImage("pic/9.gif")
	};
	//定义Stack堆栈，保存每一步操作
	Stack<Integer> pushStep = new Stack<Integer>();
	public static final int LEFT_PUSHED=1;//推了箱子
	public static final int LEFT_NOPUSHED=11;//没有推箱子
	public static final int UP_PUSHED=2;//推了箱子
	public static final int UP_NOPUSHED=22;//没有推箱子
	public static final int RIGHT_PUSHED=3;//推了箱子
	public static final int RIGHT_NOPUSHED=33;//没有推箱子
	public static final int DOWN_PUSHED=4;//推了箱子
	public static final int DOWN_NOPUSHED=44;//没有推箱子
	//定义TxzGame的变量
	TxzGame game;
	
	//弹出菜单
	JPopupMenu popupMenu;
	JMenuItem itFirst,itNext,itPiror,itLast;
	
	
	//创建弹出菜单
	public void createMenu(){
		itFirst = new JMenuItem("第一关");
		itNext = new JMenuItem("下一关");
		itPiror = new JMenuItem("上一关");
		itLast = new JMenuItem("最终关");
		popupMenu = new JPopupMenu();
		popupMenu.add(itFirst);
		popupMenu.add(itNext);
		popupMenu.add(itPiror);
		popupMenu.add(itLast);
		itFirst.addActionListener(this);
		itNext.addActionListener(this);
		itPiror.addActionListener(this);
		itLast.addActionListener(this);
	}
	public MainPanel(TxzGame game) {
		this.game = game;
		init(1);
		//创建弹出菜单
		createMenu();
		addKeyListener(this);
		addMouseListener(this);
		setSize(600, 600);
		requestFocus();
	}
	//设置悔一步按钮状态
	public boolean setbtnBackState(){
		return pushStep.isEmpty();
	}
	
	@Override
	public void paint(Graphics g) {
//		super.paint(g);
		int i,j;
		for(i=0;i<20;i++){
			for(j=0;j<20;j++){
				g.drawImage(img[tempMap[j][i]], i*30, j*30, 30, 30, this);
			}
		}
	}
	//读取地图(文本文件)的函数
	public void readMap(){
		
		//生成文件名称
		String sfileName = "maps/"+this.level+".map";
		FileReader fr;
		try {
			fr = new FileReader(sfileName);
			//读取文本文件的类
			BufferedReader br = new BufferedReader(fr);
			
			String line="";
			int row=0;
			//循环一行一行读取内容
			while((line=br.readLine())!=null){
				for(int i=0;i<20;i++){
					int c = line.charAt(i);//字符对应的ASCII值，要减去48
					map[row][i]=c-48;
					//获取原始地图中人的位置
					if(map[row][i]==5){
						manx=row;//行
						many=i;//列
					}
				}
				row++;
			}
			//给临时地图赋值
			for(int i=0;i<20;i++){
				for(int j=0;j<20;j++){
					tempMap[i][j]=map[i][j];
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//界面重画
		repaint();
	}
	public static void main(String[] args) {
		String sfileName = "maps/1.map";
		FileReader fr;
		int map[][] = new int[20][20];
		try {
			File file = new File(sfileName);
			fr = new FileReader(file);
			//读取文本文件的类
			BufferedReader br = new BufferedReader(fr);
			
//			BufferedReader br1 = new BufferedReader(new FileReader(new File(sfileName)));
			
			
			String line="";
			//循环一行一行读取内容
			int row=0;
			while((line=br.readLine())!=null){
				for(int i=0;i<line.length();i++){
					int c = line.charAt(i);//字符对应的ASCII值，要减去48
					map[row][i]=c-48;
					
				}
				row++;
			}
			//看读取的数据是否准确
			for(int i=0;i<20;i++){
				for(int j=0;j<20;j++){
					System.out.print(map[i][j]+"\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//初始化游戏界面
	public void init(int level){
		this.level = level;
		//清空堆栈
		pushStep.clear();
		//读地图文件,并初始化界面
		readMap();
		game.setGameLevel();
	}
	//按向左方向键函数
	public void goLeft(){
		//人的左边有箱子
		if(tempMap[manx][many-1]==3 || tempMap[manx][many-1]==9){
			if(tempMap[manx][many-2]==2){//可以推箱子
				tempMap[manx][many-2]=3;
				tempMap[manx][many-1]=6;
				//与原始地图进行比较
				if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5){
					tempMap[manx][many]=2;
				}else if(map[manx][many]==4 || map[manx][many]==9){
					tempMap[manx][many]=4;
				}
				many=many-1;//人向左移
				pushStep.add(LEFT_PUSHED);//保存推箱子的操作
			}else if(tempMap[manx][many-2]==4){//可以推箱子
				tempMap[manx][many-2]=9;
				tempMap[manx][many-1]=6;
				if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5){
					tempMap[manx][many]=2;
				}else if(map[manx][many]==4 || map[manx][many]==9){
					tempMap[manx][many]=4;
				}
				many=many-1;//人向左移
				pushStep.add(LEFT_PUSHED);
			}
		}else if(tempMap[manx][many-1]==2 || tempMap[manx][many-1]==4){ //人的左边没箱子
			if(tempMap[manx][many-1]==2){
				tempMap[manx][many-1]=6;
			}else if(tempMap[manx][many-1]==4){
				tempMap[manx][many-1]=6;
			}
			if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5){
				tempMap[manx][many]=2;
			}else if(map[manx][many]==4 || map[manx][many]==9){
				tempMap[manx][many]=4;
			}
			many=many-1;
			pushStep.add(LEFT_NOPUSHED);
		}
		repaint();
	}
	//按向上方向键函数
	public void goUp(){
		//人的左边有箱子
		if(tempMap[manx-1][many]==3 || tempMap[manx-1][many]==9){
			if(tempMap[manx-2][many]==2){//可以推箱子
				tempMap[manx-2][many]=3;
				tempMap[manx-1][many]=8;
				//与原始地图进行比较
				if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5){
					tempMap[manx][many]=2;
				}else if(map[manx][many]==4 || map[manx][many]==9){
					tempMap[manx][many]=4;
				}
				manx=manx-1;//人向左移
				pushStep.add(UP_PUSHED);
			}else if(tempMap[manx-2][many]==4){//可以推箱子
				tempMap[manx-2][many]=9;
				tempMap[manx-1][many]=8;
				if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5){
					tempMap[manx][many]=2;
				}else if(map[manx][many]==4 || map[manx][many]==9){
					tempMap[manx][many]=4;
				}
				manx=manx-1;//人向左移
				pushStep.add(UP_PUSHED);
			}
		}else if(tempMap[manx-1][many]==2 || tempMap[manx-1][many]==4){ //人的左边没箱子
			if(tempMap[manx-1][many]==2){
				tempMap[manx-1][many]=8;
			}else if(tempMap[manx-1][many]==4){
				tempMap[manx-1][many]=8;
			}
			if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5){
				tempMap[manx][many]=2;
			}else if(map[manx][many]==4 || map[manx][many]==9){
				tempMap[manx][many]=4;
			}
			manx=manx-1;
			pushStep.add(UP_NOPUSHED);
		}
		repaint();
	}
	//按向右方向键函数
	public void goRight(){
		//人的左边有箱子
		if(tempMap[manx][many+1]==3 || tempMap[manx][many+1]==9){
			if(tempMap[manx][many+2]==2){//可以推箱子
				tempMap[manx][many+2]=3;
				tempMap[manx][many+1]=7;
				//与原始地图进行比较
				if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5){
					tempMap[manx][many]=2;
				}else if(map[manx][many]==4 || map[manx][many]==9){
					tempMap[manx][many]=4;
				}
				many=many+1;//人向左移
				pushStep.add(RIGHT_PUSHED);
			}else if(tempMap[manx][many+2]==4){//可以推箱子
				tempMap[manx][many+2]=9;
				tempMap[manx][many+1]=7;
				if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5){
					tempMap[manx][many]=2;
				}else if(map[manx][many]==4 || map[manx][many]==9){
					tempMap[manx][many]=4;
				}
				many=many+1;//人向左移
				pushStep.add(RIGHT_PUSHED);
			}
		}else if(tempMap[manx][many+1]==2 || tempMap[manx][many+1]==4){ //人的左边没箱子
			if(tempMap[manx][many+1]==2){
				tempMap[manx][many+1]=7;
			}else if(tempMap[manx][many+1]==4){
				tempMap[manx][many+1]=7;
			}
			if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5){
				tempMap[manx][many]=2;
			}else if(map[manx][many]==4 || map[manx][many]==9){
				tempMap[manx][many]=4;
			}
			many=many+1;
			pushStep.add(RIGHT_NOPUSHED);
		}
		repaint();
	}
	//按向下方向键函数
	public void goDown(){
		//人的左边有箱子
		if(tempMap[manx+1][many]==3 || tempMap[manx+1][many]==9){
			if(tempMap[manx+2][many]==2){//可以推箱子
				tempMap[manx+2][many]=3;
				tempMap[manx+1][many]=5;
				//与原始地图进行比较
				if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5){
					tempMap[manx][many]=2;
				}else if(map[manx][many]==4 || map[manx][many]==9){
					tempMap[manx][many]=4;
				}
				manx=manx+1;//人向左移
				pushStep.add(DOWN_PUSHED);
			}else if(tempMap[manx+2][many]==4){//可以推箱子
				tempMap[manx+2][many]=9;
				tempMap[manx+1][many]=5;
				if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5){
					tempMap[manx][many]=2;
				}else if(map[manx][many]==4 || map[manx][many]==9){
					tempMap[manx][many]=4;
				}
				manx=manx+1;//人向左移
				pushStep.add(DOWN_PUSHED);
			}
		}else if(tempMap[manx+1][many]==2 || tempMap[manx+1][many]==4){ //人的左边没箱子
			if(tempMap[manx+1][many]==2){
				tempMap[manx+1][many]=5;
			}else if(tempMap[manx+1][many]==4){
				tempMap[manx+1][many]=5;
			}
			if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5){
				tempMap[manx][many]=2;
			}else if(map[manx][many]==4 || map[manx][many]==9){
				tempMap[manx][many]=4;
			}
			manx=manx+1;
			pushStep.add(DOWN_NOPUSHED);
		}
		repaint();
	}
	
	//判断箱子是否全部推到位
	public boolean isWin(){
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				if(tempMap[i][j]==3){
					return false;
				}
			}
		}
		return true;
		
	} 
	
	//悔一步函数
	public void back(){
		//判断能不能悔一步
		if(pushStep.isEmpty()){
			init(level);
			return;
		}
		//获取操作的步骤值
		int stepValue = pushStep.pop();
		switch(stepValue){
		case LEFT_PUSHED:
		case LEFT_NOPUSHED:
			backLeft(stepValue);
			break;
		case UP_PUSHED:
		case UP_NOPUSHED:
			backUp(stepValue);
			break;
		case RIGHT_PUSHED:
		case RIGHT_NOPUSHED:
			backRight(stepValue);
			break;
		case DOWN_PUSHED:
		case DOWN_NOPUSHED:
			backDown(stepValue);
			break;
		}
		repaint();
		//设置悔一步按钮状态
		game.setbtnBackState(!pushStep.isEmpty());
	}
	//实现往左走的悔一步
	public void backLeft(int stepValue){
		//推了箱子的悔一步
		if(stepValue==LEFT_PUSHED){
			tempMap[manx][many+1]=6;
			//人的位置
			if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5)
				tempMap[manx][many]=3;
			else if(map[manx][many]==4 || map[manx][many]==9)
				tempMap[manx][many]=9;
			//箱子的位置
			if(map[manx][many-1]==2 || map[manx][many-1]==3 || map[manx][many-1]==5)
				tempMap[manx][many-1]=2;
			else if(map[manx][many-1]==4 || map[manx][many-1]==9)
				tempMap[manx][many-1]=4;
			many=many+1;
		}else{
			tempMap[manx][many+1]=6;
			//人的位置
			if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5)
				tempMap[manx][many]=2;
			else if(map[manx][many]==4 || map[manx][many]==9)
				tempMap[manx][many]=4;
			many=many+1;
		}
	}
	//实现往上走的悔一步
	public void backUp(int stepValue){
		//推了箱子的悔一步
		if(stepValue==UP_PUSHED){
			tempMap[manx+1][many]=8;
			//人的位置
			if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5)
				tempMap[manx][many]=3;
			else if(map[manx][many]==4 || map[manx][many]==9)
				tempMap[manx][many]=9;
			//箱子的位置
			if(map[manx-1][many]==2 || map[manx-1][many]==3 || map[manx-1][many]==5)
				tempMap[manx-1][many]=2;
			else if(map[manx-1][many]==4 || map[manx-1][many]==9)
				tempMap[manx-1][many]=4;
			manx=manx+1;
		}else{
			tempMap[manx+1][many]=8;
			//人的位置
			if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5)
				tempMap[manx][many]=2;
			else if(map[manx][many]==4 || map[manx][many]==9)
				tempMap[manx][many]=4;
			manx=manx+1;
		}
	}
	//实现往右走的悔一步
	public void backRight(int stepValue){
		//推了箱子的悔一步
		if(stepValue==RIGHT_PUSHED){
			tempMap[manx][many-1]=7;
			//人的位置
			if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5)
				tempMap[manx][many]=3;
			else if(map[manx][many]==4 || map[manx][many]==9)
				tempMap[manx][many]=9;
			//箱子的位置
			if(map[manx][many+1]==2 || map[manx][many+1]==3 || map[manx][many+1]==5)
				tempMap[manx][many+1]=2;
			else if(map[manx][many+1]==4 || map[manx][many+1]==9)
				tempMap[manx][many+1]=4;
			many=many-1;
		}else{
			tempMap[manx][many-1]=7;
			//人的位置
			if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5)
				tempMap[manx][many]=2;
			else if(map[manx][many]==4 || map[manx][many]==9)
				tempMap[manx][many]=4;
			many=many-1;
		}
	}
	//实现往下走的悔一步
	public void backDown(int stepValue){
		//推了箱子的悔一步
		if(stepValue==DOWN_PUSHED){
			tempMap[manx-1][many]=5;
			//人的位置
			if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5)
				tempMap[manx][many]=3;
			else if(map[manx][many]==4 || map[manx][many]==9)
				tempMap[manx][many]=9;
			//箱子的位置
			if(map[manx+1][many]==2 || map[manx+1][many]==3 || map[manx+1][many]==5)
				tempMap[manx+1][many]=2;
			else if(map[manx+1][many]==4 || map[manx+1][many]==9)
				tempMap[manx+1][many]=4;
			manx=manx-1;
		}else{
			tempMap[manx-1][many]=5;
			//人的位置
			if(map[manx][many]==2 || map[manx][many]==3 || map[manx][many]==5)
				tempMap[manx][many]=2;
			else if(map[manx][many]==4 || map[manx][many]==9)
				tempMap[manx][many]=4;
			manx=manx-1;
		}
	}
	//按下键
	public void keyPressed(KeyEvent e) {
		//测试按键的值
		System.out.println("键值："+e.getKeyCode());
		switch(e.getKeyCode()){
		case 37://按向左方向键
			goLeft();
			break;
		case 38://按向上方向键
			goUp();
			break;
		case 39://按向右方向键
			goRight();
			break;
		case 40://按向下方向键
			goDown();
			break;
		}
		if(isWin()){
			JOptionPane.showMessageDialog(this, "恭喜你成功通关,进入下一关");
			if(this.level>=TxzGame.MAXLEVEL){
				this.level=1;
			}else{
				this.level++;
			}
			init(this.level);
		}
		//设置悔一步按钮状态
		game.setbtnBackState(!pushStep.isEmpty());
	}
	//释放键
	public void keyReleased(KeyEvent e) {
		
	}
	//按了组合键
	public void keyTyped(KeyEvent e) {
		
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==3){
			popupMenu.show(this, e.getX(), e.getY());
		}
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==itFirst){
			game.setFirst();
		}else if(e.getSource()==itNext){
			game.setNext();
		}else if(e.getSource()==itPiror){
			game.setPiror();
		}else if(e.getSource()==itLast){
			game.setLast();
		}
	}
}
