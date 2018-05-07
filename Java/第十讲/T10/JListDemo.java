package T10;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class JListDemo extends JFrame implements MouseListener{

	JList list1,list2;
	String hover[]={
			"小狗","小猫","小熊","小白","小老鼠","小可爱","小鸡"
	};
	String mobile[]={
			"小米","Nokia","华为","魅族","OPPO","VIVO","三星","iPhone","锤子","天音"
	};
	public JListDemo() {
		super("JList列表框控件的使用");
		setLayout(new GridLayout(1,2,5,5));
		list1 = new JList(hover);
		//设置边框BorderFactory
		list1.setBorder(BorderFactory.createTitledBorder("你喜欢那种动物?"));
		//设置选择模式
		//多选模式ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
		//连续选择多个，不能有间隔ListSelectionModel.SINGLE_INTERVAL_SELECTION
		//单选ListSelectionModel.SINGLE_SELECTION
		
//		list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		list1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list2 = new JList(mobile);
		list2.setBorder(BorderFactory.createTitledBorder("你喜欢那种手机?"));
		//默认显示5项，超出部分通过滚动条显示
		list2.setVisibleRowCount(5);
		add(list1);
		//设置滚动条JScrollPane
		add(new JScrollPane(list2));
		
		list1.addMouseListener(this);
		list2.addMouseListener(this);
//		pack();
		setSize(400, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new JListDemo();
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==list1){
			//获取选中的下标索引
			int idx = list1.getSelectedIndex();
			String v = (String)list1.getSelectedValue();
			
			String str = idx+"======="+hover[idx];
			JOptionPane.showMessageDialog(this, str);
		}
		else if(e.getSource()==list2){
			//获取所有选中的下标索引
			int idxs[] = list2.getSelectedIndices();
			//获取所有选中的值
			Object vs[]= list2.getSelectedValues();
			for(int i=0;i<idxs.length;i++){
				String str = idxs[i]+"====="+vs[i].toString();
				JOptionPane.showMessageDialog(this, str);
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
