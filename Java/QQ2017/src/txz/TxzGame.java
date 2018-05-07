package txz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Stack;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class TxzGame extends JFrame implements ActionListener,ItemListener,WindowListener{

	MainPanel mainPanel;
	JButton btnReset,btnBack,btnFirst,btnNext,btnPiror,btnLast,btnSelect,btnMusic;
	JLabel lblTitle;
	JComboBox cbMusic;
	String sMusicFile[]={"nor.mid","qin.mid","popo.mid","guang.mid","eyes on me.mid"};
	String sMusic[]={
			"默认",
			"琴箫合奏",
			"泡泡堂",
			"灌篮高手",
			"eyes on me"
	};
	int level=1;//选关
	public static final int MAXLEVEL=50;
	Sound sound;

	//下拉菜单
	JMenuBar menuBar; //菜单条
	JMenu subMenu;//子菜单
	JMenuItem itFirst2,itNext2,itPiror2,itLast2;
	//创建弹出菜单
	public void createMenu(){
		//下拉菜单
		itFirst2 = new JMenuItem("第一关");
		itNext2 = new JMenuItem("下一关");
		itPiror2 = new JMenuItem("上一关");
		itLast2 = new JMenuItem("最终关");
		itFirst2.addActionListener(this);
		itNext2.addActionListener(this);
		itPiror2.addActionListener(this);
		itLast2.addActionListener(this);
		subMenu = new JMenu("选项");
		subMenu.add(itFirst2);
		subMenu.add(itNext2);
		subMenu.add(itPiror2);
		subMenu.add(itLast2);
		menuBar = new JMenuBar();
		menuBar.add(subMenu);
		setJMenuBar(menuBar);
	}
	public TxzGame() {
		super("宏图2017推箱子游戏V1.0");
		
//		Container c = getContentPane();
//		c.setLayout(null);
		
		//设置图标
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image image = kit.getImage("pic/3.gif");
		setIconImage(image);
		//显示推箱子游戏的标题
		lblTitle = new JLabel("宏图2017推箱子游戏V1.0",JLabel.CENTER);
		//为标题设置字体
		Font font = new Font("宋体",Font.BOLD,24);
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.RED);
		add(lblTitle,BorderLayout.NORTH);
		//创建游戏主类
		mainPanel = new MainPanel(this);
		add(mainPanel);
		btnReset = new JButton("重来");
		btnBack = new JButton("悔一步");
		btnFirst = new JButton("第一关");
		btnNext = new JButton("下一关");
		btnPiror = new JButton("上一关");
		btnLast = new JButton("最终关");
		btnSelect = new JButton("选关");
		btnMusic = new JButton("音乐关");
		JLabel lblMusic = new JLabel("选择音乐");
		cbMusic = new JComboBox(sMusic);
		//定义容纳按钮的面板
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(12,1,5,15));
		eastPanel.add(btnReset);
		eastPanel.add(btnBack);
		eastPanel.add(btnFirst);
		eastPanel.add(btnNext);
		eastPanel.add(btnPiror);
		eastPanel.add(btnLast);
		eastPanel.add(btnSelect);
		eastPanel.add(btnMusic);
		eastPanel.add(lblMusic);
		eastPanel.add(cbMusic);
		btnReset.addActionListener(this);
		btnBack.addActionListener(this);
		btnFirst.addActionListener(this);
		btnNext.addActionListener(this);
		btnPiror.addActionListener(this);
		btnLast.addActionListener(this);
		btnSelect.addActionListener(this);
		btnMusic.addActionListener(this);
		cbMusic.addItemListener(this);
		addWindowListener(this);
		//创建下拉菜单
		createMenu();
		//播放音乐
		sound = new Sound(); 
		add(eastPanel,BorderLayout.EAST);
		setSize(730,690);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//悔一步的初始状态为无效状态
		setbtnBackState(false);
		mainPanel.requestFocus();
		
	}
	public static void main(String[] args) {
		new TxzGame();
	}
	
	//设置悔一步按钮状态
	public void setbtnBackState(boolean b){
		btnBack.setEnabled(b);
	}
	public void setFirst(){
		level=1;
		mainPanel.init(level);
	}
	public void setNext(){
		if(level<MAXLEVEL){
			level++;
		}else{
			level = MAXLEVEL;
		}
		mainPanel.init(level);
	}
	public void setPiror(){
		if(level>1){
			level--;
		}else{
			level = 1;
		}
		mainPanel.init(level);
	}
	public void setLast(){
		level = MAXLEVEL;
		mainPanel.init(level);
	}
	//界面显示当前第几关
	public void setGameLevel(){
		String str = "宏图2017推箱子游戏V1.0,当前第"+this.level+"关";
		lblTitle.setText(str);
	}
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnFirst){
			setFirst();
		}else if(e.getSource()==btnNext){
			setNext();
		}else if(e.getSource()==btnPiror){
			setPiror();
		}else if(e.getSource()==btnLast){
			setLast();
		}else if(e.getSource()==btnSelect){
			//输入框
			String msg = "请选择关卡(1-"+MAXLEVEL+")之间";
			//初始值为1
			String slevel=JOptionPane.showInputDialog(msg,1);
			try{
				level = Integer.parseInt(slevel);
			}catch(Exception ex){
				JOptionPane.showMessageDialog(this, msg+",必须输入0~9之间的数字字符");
				return;
			}
			if(level<1 || level>MAXLEVEL){
				JOptionPane.showMessageDialog(this, msg);
				return;
			}
			mainPanel.init(level);	
		}else if(e.getSource()==btnReset){//重来
			mainPanel.init(mainPanel.level);
		}else if(e.getSource()==btnMusic){
			//获取按钮标题
			String title = btnMusic.getText();
			if(title.equals("音乐关")){
				sound.mystop();
				btnMusic.setText("音乐开");
			}else{
				int index = cbMusic.getSelectedIndex();
				if(index>=0){
					String file = sMusicFile[index];
					sound.setMusic(file);//播放选择的音乐
				}else{
					sound.loadSound();//播放默认音乐
				}
				btnMusic.setText("音乐关");
			}
		}else if(e.getSource()==btnBack){ //悔一步
			mainPanel.back();
		}else if(e.getSource()==itFirst2){
			setFirst();
		}else if(e.getSource()==itNext2){
			setNext();
		}else if(e.getSource()==itPiror2){
			setPiror();
		}else if(e.getSource()==itLast2){
			setLast();
		}
		//设置焦点
		mainPanel.requestFocus();
	}
	//音乐下拉框事件
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cbMusic){
			//获取按钮标题
			String title = btnMusic.getText();
			if(title.equals("音乐开")){
				return;
			}
			//获取选中的下拉项(索引号)
			int index = cbMusic.getSelectedIndex();
			String file = sMusicFile[index];
			//先关闭当前播放的音乐
			if(sound.isplay()){
				//停止播放音乐
				sound.mystop();
			}
			//播放选择的音乐
			sound.setMusic(file);
		}
		
	}
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowClosing(WindowEvent e) {
		sound.mystop();
		
	}
	public void windowDeactivated(WindowEvent e) {
		
		
	}
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}

//播放背景音乐
class Sound {
	
	String path = new String("musics\\");

	
	//默认背景音乐
	String file = new String("nor.mid");

	//载入音乐文件
	Sequence seq;

	//播放器
	Sequencer midi;

	//判断是否在播放音乐
	boolean sign;

	public Sound() {
		loadSound();
	}
	//播放背景音乐的函数
	void loadSound() {
		try {
			//读取音频文件
			seq = MidiSystem.getSequence(new File(path+ file));
			//获取一个音频设备
			midi = MidiSystem.getSequencer();
			//打开音频设备
			midi.open();
			//把音频文件载入到播放设备中
			midi.setSequence(seq);
			//开始播放音乐
			midi.start();
			//循环播放
			midi.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		}
		catch ( Exception ex ) {
			ex.printStackTrace();
		}
		//代表正在播放背景音乐
		sign = true;
	}
	//停止播放背景音乐
	void mystop() {
		//关闭播放器
		midi.stop();
		//释放内存
		midi.close();
		//播放状态设置为没有播放
		sign = false;
	}

	//判断是否在播放背景音乐
	boolean isplay() {
		return sign;
	}
	//设置在下拉框中选择的背景音乐文件名称
	void setMusic(String e) {
		file = e;
		//播放音乐
		loadSound();
	}
}