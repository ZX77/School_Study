package T10;

import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeDemo extends JFrame{

	JTree dep;
	String depname[] ={"行政部","教研部","学工科","后勤部","财务部"};
	public JTreeDemo() {
		super("JTree树形控件使用");
		//在java.util.Hashtable包中
//		Hashtable map = new Hashtable();
//		map.put("宏图软件学院", depname);
//		dep = new JTree(map);
		
		//DefaultMutableTreeNode节点类
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("赣州技师学院");
		
		DefaultMutableTreeNode level11 = new DefaultMutableTreeNode("电子自动化系");
		DefaultMutableTreeNode level12 = new DefaultMutableTreeNode("汽车系");
		DefaultMutableTreeNode level13 = new DefaultMutableTreeNode("机械学");
		
		DefaultMutableTreeNode level21 = new DefaultMutableTreeNode("软件工程专业");
		DefaultMutableTreeNode level22 = new DefaultMutableTreeNode("电子商务专业");
		DefaultMutableTreeNode level23 = new DefaultMutableTreeNode("平面广告设计");
		DefaultMutableTreeNode level24 = new DefaultMutableTreeNode("计算机网络");

		DefaultMutableTreeNode level31 = new DefaultMutableTreeNode("2017秋宏图01班");
		DefaultMutableTreeNode level32 = new DefaultMutableTreeNode("2017秋宏图02班");
		DefaultMutableTreeNode level33 = new DefaultMutableTreeNode("2017秋宏图03班");
		DefaultMutableTreeNode level34 = new DefaultMutableTreeNode("2017秋宏图04班");
		DefaultMutableTreeNode level35 = new DefaultMutableTreeNode("2017秋宏图05班");
		
		level21.add(level31);
		level21.add(level32);
		level21.add(level33);
		level21.add(level34);
		level21.add(level35);
		
		level11.add(level21);
		level11.add(level22);
		level11.add(level23);
		level11.add(level24);
		
		root.add(level11);
		root.add(level12);
		root.add(level13);
		dep = new JTree(root);
		add(dep);
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new JTreeDemo();
	}
}
