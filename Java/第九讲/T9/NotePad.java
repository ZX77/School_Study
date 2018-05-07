package T9;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;


public class NotePad extends JFrame implements ActionListener,MouseListener{

	//下拉菜单
	
	//菜单条
	JMenuBar menuBar;
	//子菜单
	JMenu mnuFile,mnuEdit,mnuHelp,mnuColor;
	//菜单项
	JMenuItem mnuFileNew,mnuFileOpen,mnuFileSave,mnuFileClose,mnuFilePrint;
	JMenuItem mnuEditCut,mnuEditCopy,mnuEditPaste,mnuEditFont;
//	JMenuItem mnuRed,mnuGreen,mnuBlue;
	//单选框菜单项
	JRadioButtonMenuItem mnuRed,mnuGreen,mnuBlue;
	//多选框菜单项
//	JCheckBoxMenuItem
	JMenuItem mnuAboutUs;
	
	JTextArea txtContent;
	
	//右键菜单（弹出菜单）
	JPopupMenu popup;
	//弹出菜单项
	JMenuItem miRed,miGreen,miBlue;
	public NotePad() {
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
		super("宏图记事本2018");
		//创建菜单项
//		mnuFileNew = new JMenuItem("新建",new ImageIcon("images/tubiao.png"));
		mnuFileNew = new JMenuItem("新建");
		mnuFileOpen = new JMenuItem("打开");
		mnuFileSave = new JMenuItem("保存");
		mnuFilePrint = new JMenuItem("打印");
		mnuFileClose = new JMenuItem("退出");
		mnuFileOpen.addActionListener(this);
		mnuFileClose.addActionListener(this);
		//创建子菜单
		mnuFile = new JMenu("文件(F)");
		mnuFile.setMnemonic('F');
		//在子菜单中加入菜单项
		mnuFile.add(mnuFileNew);
		mnuFile.add(mnuFileOpen);
		mnuFile.add(mnuFileSave);
		//加入分割线
		mnuFile.addSeparator();
		mnuFile.add(mnuFilePrint);
		mnuFile.addSeparator();
		mnuFile.add(mnuFileClose);
		
		
		mnuEditCut = new JMenuItem("剪切");
		mnuEditCopy = new JMenuItem("拷贝");
		mnuEditPaste = new JMenuItem("粘贴");
		mnuEditFont = new JMenuItem("字体");
		mnuColor = new JMenu("颜色");
		mnuRed = new JRadioButtonMenuItem("红色");
		mnuGreen = new JRadioButtonMenuItem("绿色");
		mnuBlue = new JRadioButtonMenuItem("蓝色");
		mnuRed.addActionListener(this);
		mnuGreen.addActionListener(this);
		mnuBlue.addActionListener(this);
		mnuEditFont.addActionListener(this);
		ButtonGroup bg = new ButtonGroup();
		bg.add(mnuRed);
		bg.add(mnuGreen);
		bg.add(mnuBlue);
		
		//子菜单
		mnuEdit = new JMenu("编辑(E)");
		mnuEdit.setMnemonic('E');
		mnuEdit.add(mnuEditCut);
		mnuEdit.add(mnuEditCopy);
		mnuEdit.add(mnuEditPaste);
		mnuEdit.addSeparator();
		mnuEdit.add(mnuEditFont);
		mnuEdit.addSeparator();
		mnuEdit.add(mnuColor);
		mnuColor.add(mnuRed);
		mnuColor.add(mnuGreen);
		mnuColor.add(mnuBlue);
		
		mnuHelp = new JMenu("帮助(H)");
		mnuHelp.setMnemonic('H');
		mnuAboutUs = new JMenuItem("关于...");
		mnuHelp.add(mnuAboutUs);
		mnuAboutUs.addActionListener(this);
		
		//创建菜单条
		menuBar = new JMenuBar();
		
		//把子菜单加入菜单条
		menuBar.add(mnuFile);
		menuBar.add(mnuEdit);
		menuBar.add(mnuHelp);
		//把菜单条设置到主窗口
		setJMenuBar(menuBar);
		
		//创建弹出菜单
		popup = new JPopupMenu();
		miRed = new JMenuItem("红色");
		miGreen = new JMenuItem("绿色");
		miBlue = new JMenuItem("蓝色");
		popup.add(miRed);
		popup.add(miGreen);
		popup.add(miBlue);
		miRed.addActionListener(this);
		miGreen.addActionListener(this);
		miBlue.addActionListener(this);
		
		
		txtContent = new JTextArea();
		//给文本框添加鼠标事件
		txtContent.addMouseListener(this);
		add(txtContent);
		setSize(800, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new NotePad();
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==mnuFileClose){
			System.exit(0);
		}else if(e.getSource()==mnuAboutUs){
			
			JOptionPane.showMessageDialog(this,"宏图记事本，版权所有","宏图记事本",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("images/tubiao.png"));
		}else if(e.getSource()==mnuEditFont){
			txtContent.setFont(new Font("宋体",Font.BOLD,18));
		}else if(e.getSource()==mnuRed){
			JColorChooser colorDlg = new JColorChooser();
			Color color = colorDlg.showDialog(this, "颜色对话框", Color.RED);
			txtContent.setForeground(color);
		}else if(e.getSource()==mnuFileOpen){
			//文件对话框
			JFileChooser fileDlg = new JFileChooser();
			//设置对话框的模式(打开文件对话框,保存文件对话框)
			fileDlg.setDialogType(JFileChooser.OPEN_DIALOG);
			//打开文件对话框
			//打开对话框
			if(fileDlg.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
				//获取文件的(getAbsolutePath)绝对路径及名称
				//getSelectedFile获取选中的文件
//				fileDlg.getSelectedFiles()
				String path = fileDlg.getSelectedFile().getAbsolutePath();
				//获取选中的文件
				String s = fileDlg.getSelectedFile().getName();
				JOptionPane.showMessageDialog(this, path);
			}
			
		}else if(e.getSource()==miRed){
			txtContent.setForeground(Color.RED);
		}else if(e.getSource()==miGreen){
			txtContent.setForeground(Color.GREEN);
		}else if(e.getSource()==miBlue){
			txtContent.setForeground(Color.BLUE);
		}else if(e.getSource()==mnuGreen){
			//确认对话框
			/*
			 * JOptionPane.WARNING_MESSAGE:出现警告图标
			 * JOptionPane.QUESTION_MESSAGE:出现问号图标
			 * JOptionPane.INFORMATION_MESSAGE:提示信息图标
			 * JOptionPane.ERROR_MESSAGE:出现错误图标
			 * JOptionPane.PLAIN_MESSAGE:不显示图标
			 * JOptionPane.OK_CANCEL_OPTION:显示2个按钮，确定与取消
			 * JOptionPane.YES_NO_CANCEL_OPTION:显示3个按钮
			 * */
			int nRet = JOptionPane.showConfirmDialog(this, "删除确认", "删除提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
//			int nRet = JOptionPane.showConfirmDialog(this, "删除确认", "删除提示", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,new ImageIcon("images/tubiao.png"));
			if(nRet==JOptionPane.OK_OPTION){
				JOptionPane.showMessageDialog(this, "你点击了确认按钮");
			}else if(nRet==JOptionPane.CANCEL_OPTION){
				JOptionPane.showMessageDialog(this, "你点击了取消按钮");
			}
		}else if(e.getSource()==mnuBlue){
			//输入对话框
			
			String age = JOptionPane.showInputDialog("请输入你的年龄", "18");
			
			JOptionPane.showMessageDialog(this, "你输入的年龄是："+age);
			
		}
	}
	public void mouseClicked(MouseEvent e) {
		//点击了右键
		if(e.getButton()==3){
			if(e.getSource() == txtContent){
				//弹出菜单,在鼠标点击的地方弹出菜单
				popup.show(this, e.getX(), e.getY());
			}
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
}
