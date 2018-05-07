package T10;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;

public class JTreeEventApp extends JFrame implements TreeSelectionListener {

	//比较复杂的文本区域框(富文本框)
    JEditorPane editorPane;    //编辑面板

    public JTreeEventApp() {
        super("简单的记事本程序框架");
        Container contentPane = this.getContentPane();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("2007年3月");
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("2007-03-09.txt");
        root.add(node);
        node = new DefaultMutableTreeNode("2007-03-10.txt");
        root.add(node);
        node = new DefaultMutableTreeNode("2007-03-11.txt");
        root.add(node);
        node = new DefaultMutableTreeNode("2007-03-12.txt");
        root.add(node);
        JTree tree = new JTree(root);
        //设置只能在树中单选
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.
                                                  SINGLE_TREE_SELECTION);
        //增加选项监听
        tree.addTreeSelectionListener(this);
        //将树放到滚动面板中去
        JScrollPane scrollPanel = new JScrollPane(tree);
        editorPane = new JEditorPane();
        //将编辑面板放到滚动面板中去
        JScrollPane scrollPane2 = new JScrollPane(editorPane);
        //实例化一个以左右分割的面板，分别放两个滚动面板
        //JSplitPane.HORIZONTAL_SPLIT:水平分隔
        //JSplitPane.VERTICAL_SPLIT:垂直分隔
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
                                              scrollPanel, scrollPane2);
        contentPane.add(splitPane);
//        add(splitPane);
        this.pack();
        this.setVisible(true);
        this.show();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //System.exit(0);关闭应用程序
        //dispose();关闭当前窗口
    }

    //实现对应的监听方法
    public void valueChanged(TreeSelectionEvent e) {
    	//把发送事件的控件强制转换为JTree控件
        JTree tree = (JTree) e.getSource();
        //获取最后被选中的节点
        DefaultMutableTreeNode selectionNode = (DefaultMutableTreeNode) tree.
                                               getLastSelectedPathComponent();
        //获取节点的值（也就是文件名称）
        String nodeName = selectionNode.toString();
        //isLeaf叶子节点
        //System.getProperty("user.dir")获取用户的当前路径
        //System.getProperty("file.separator")分隔条
        if (selectionNode.isLeaf()) {
            String filepath = "file:" + System.getProperty("user.dir") +
                              System.getProperty("file.separator") + nodeName;
            System.out.println("filepath-->" + filepath);
            try {
            	//setPage方法：加载文件
                editorPane.setPage(filepath);
            } catch (IOException ie) {
                System.out.println("找不到此文件！");
            }
        }
    }

    public static void main(String[] args) {
        new JTreeEventApp();
    }
}
