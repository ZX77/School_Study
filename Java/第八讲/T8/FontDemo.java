package T8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FontDemo extends JFrame implements ItemListener{

	JLabel lblTip;
	//多选框
	JCheckBox cbBold,cbItalic;
	//下拉列表框
	JComboBox cbSize,cbFont;
	//设置字号
	String nsize[]={"8","10","12","14","18","20","24","36","72"};
	
	//粗体
	int nBold = Font.PLAIN;//默认值
	//斜体
	int nItalic = Font.PLAIN;
	//字号
	int size = 24;
	//字体名称
	String fontName="宋体";
	public FontDemo() {
		
		//获取工具类
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		//创建图片
		Image image = toolkit.getImage("images/tubiao.png");
		//为窗口设置图标
		setIconImage(image);
		//获取系统字体列表
		String[] fontlist = toolkit.getFontList();
		cbFont = new JComboBox(fontlist);
		
		//创建一个jpanel面板
		JPanel northPanel = new JPanel(new FlowLayout());
		
		cbBold = new JCheckBox("粗体");
		cbItalic = new JCheckBox("斜体");
		cbSize = new JComboBox(nsize);
		cbSize.addItemListener(this);
		cbBold.addItemListener(this);
		cbItalic.addItemListener(this);
		cbFont.addItemListener(this);
		//把控件放到面板中
		northPanel.add(cbFont);
		northPanel.add(cbBold);
		northPanel.add(cbItalic);
		northPanel.add(cbSize);
		//把面板放在窗口的北部
		add(northPanel,BorderLayout.NORTH);
		lblTip = new JLabel("通过改变控件的值来改变字体的大小和风格");
		/*创建字体
		 * name:字体名称
		 * style:风格，粗体Bold，斜体Italic，粗斜体，普通PLAIN
		 * 
		 * */
		Font font = new Font(fontName,nBold+nItalic,size);
		//设置标签的字体
		lblTip.setFont(font);
		//设置字体颜色
		lblTip.setForeground(Color.red);
		add(lblTip);
		
		
		//获取屏幕分辨率
		int x = toolkit.getScreenSize().width;//分辨率的水平像素
		int y = toolkit.getScreenSize().height;//分辨率的垂直像素
//		setSize(x, y);
		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new FontDemo();
	}
	//ItemListener下拉列表框的item事件,当下拉框中的选项发生改变时，会触发该事件
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource()==cbSize){
			//获取选中的值
			String s = cbSize.getSelectedItem().toString();
			//把字符串转换为整形
			size = Integer.parseInt(s);
//			System.out.println("s="+s);
			
		}else if(e.getSource()==cbBold){
			
			if(cbBold.isSelected()){
				nBold = Font.BOLD;//粗体
			}else{
				nBold = Font.PLAIN;
			}
		}else if(e.getSource()==cbItalic){
			if(cbItalic.isSelected()){
				nItalic = Font.ITALIC;//斜体
			}else{
				nItalic = Font.PLAIN;
			}
		}else if(e.getSource()==cbFont){
			fontName = cbFont.getSelectedItem().toString();
		}
		System.out.println("fontName="+fontName);
		Font font = new Font(fontName,nBold+nItalic,size);
		//设置标签的字体
		lblTip.setFont(font);
	}
}
