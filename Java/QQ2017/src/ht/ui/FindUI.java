package ht.ui;

import ht.bean.AccountVo;
import ht.db.BaseDAO;
import ht.net.Cmd;
import ht.net.SendBody;
import ht.net.SendMsg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/*
 * 查找好友
 * 
 * */
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;

public class FindUI extends JFrame implements ActionListener,MouseListener{

	JLabel lblFind,lblAge,lblNickName;
	JTextField txtQqcode,txtAge,txtNickName;
	JComboBox cbSex,cbStatus;
	JButton btnFind,btnAdd,btnClose;
	JTable dataTable;
	Vector head,data;
	AccountVo self;
	String sSex[] = {"不选择","男","女"};
	BaseDAO base = new BaseDAO();
	public FindUI(AccountVo self) {
		super("查找好友");
		this.self =self;
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblFind = new JLabel("QQ号码");
		lblAge = new JLabel("年龄");
		lblNickName = new JLabel("昵称");
		txtQqcode = new JTextField(10);
		txtNickName = new JTextField(10);
		txtAge = new JTextField(10);
		cbSex = new JComboBox(sSex);
		cbStatus = new JComboBox(Cmd.STATUS);
		//添加一个元素
		cbStatus.insertItemAt("不选择", 0);
		//默认选中第一个选项
		cbStatus.setSelectedIndex(0);
		
		btnFind = new JButton("查找(F)");
		btnFind.setMnemonic('F');
		topPanel.add(lblFind);
		topPanel.add(txtQqcode);
		topPanel.add(lblNickName);
		topPanel.add(txtNickName);
		topPanel.add(lblAge);
		topPanel.add(txtAge);
		topPanel.add(cbSex);
		topPanel.add(cbStatus);
		topPanel.add(btnFind);
		add(topPanel,BorderLayout.NORTH);
		createHead();
		dataTable = new JTable(data,head);
		dataTable.setRowHeight(60);
		dataTable.addMouseListener(this);
		add(new JScrollPane(dataTable));
		
		btnAdd = new JButton("添加好友(A)");
		btnAdd.setMnemonic('A');
		btnClose = new JButton("关闭(X)");
		btnClose.setMnemonic('X');
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		southPanel.add(btnAdd);
		southPanel.add(btnClose);
		add(southPanel,BorderLayout.SOUTH);
		
		btnFind.addActionListener(this);
		btnAdd.addActionListener(this);
		btnClose.addActionListener(this);
		
		
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	//创建表头
	public void createHead(){
		head = new Vector();
		head.addElement("号码");
		head.addElement("昵称");
		head.addElement("头像");
		head.addElement("年龄");
		head.addElement("性别");
		head.addElement("星座");
		head.addElement("血型");
		head.addElement("民族");
		head.addElement("兴趣爱好");
		head.addElement("在线状态");
		data = new Vector();
		
	}

	public static void main(String[] args) {
		new FindUI(null);
	}
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnFind){
		
			String qqcode = txtQqcode.getText().trim();
			String nickname = txtNickName.getText().trim();
			String age = txtAge.getText().trim();
			String sex = cbSex.getSelectedItem().toString();
			String state = cbStatus.getSelectedItem().toString();
			
			String sql="select * from account where 1=1 ";
			
			if(!qqcode.equals("")){
				sql += " and qqcode="+qqcode;
			}
			//昵称模糊查询
			if(!nickname.equals("")){
				sql += " and nickname like '%"+nickname+"%'";
			}
			if(!age.equals("")){
				sql += " and age="+age;
			}
			if(!sex.equals("不选择")){
				sql += " and sex='"+sex+"'";
			}
			if(!state.equals("不选择")){
				sql += " and onlinestatus='"+state+"'";
			}
			System.out.println(sql);
			//获取符合条件的数据
			data = base.findFriend(sql);
			dataTable.setModel(new MyTableModel(head,data));
		}else if(e.getSource()==btnAdd){
			addFriend();
			//刷新界面
		}else if(e.getSource()==btnClose){
			dispose();
		}
	}
    //内部类实现抽象的TableModel，并改写必要的方法
    class MyTableModel extends AbstractTableModel {
    	Vector<String> vHead;
    	Vector data;
        public MyTableModel(Vector<String> vHead,Vector data) {
        	this.vHead = vHead;
        	this.data = data;
        }
        //得到表格列长度
        public int getColumnCount() {
            return vHead.size();
        }
        //得到表格行数
        public int getRowCount() {
            return data.size();
        }
        //得到表格列名
        public String getColumnName(int col) {
//            System.out.println(" 该列的列名为：" + vHead.get(col));
            return vHead.get(col);
        }
        //得到指定单元的值
        public Object getValueAt(int row, int col) {
        	Vector rowData = (Vector)data.get(row);
			if(col==2){//表示头像
				return new ImageIcon(rowData.get(col).toString());
			}else{
				return rowData.get(col);
			}
        }
        //返回指定列的数据类型
        @Override
		public Class<?> getColumnClass(int c) {
        	if(c==2){//表示头像
				return ImageIcon.class;
			}else{
				return super.getColumnClass(c);
			}
        }
        //设置单元格是否可修改
        public boolean isCellEditable(int row, int col) {
            return false;
        }

        //设置单元格的值
        public void setValueAt(Object value, int row, int col) {
        	Vector rowData = (Vector)data.get(row);
        	rowData.set(col, value);
            fireTableCellUpdated(row, col);
        }
    }
    public void addFriend(){
    	//获取选中的行
		int rowindex=dataTable.getSelectedRow();
		Vector rowdata = (Vector)data.get(rowindex);
		
		int qqcode = Integer.parseInt(rowdata.get(0).toString());
		if(qqcode==self.getQqCode()){
			JOptionPane.showMessageDialog(this, "不能添加自己为好友");
			return;
		}
		String state = rowdata.get(9).toString();
		if(state.equals(Cmd.STATUS[1])){
			JOptionPane.showMessageDialog(this, "对方不在线");
			return;
		}
		//返回false就可以添加好友
		if(base.isExist(self.getQqCode(),qqcode)){
			JOptionPane.showMessageDialog(this, "对方已经是您的好友，不需要再添加");
			return;
		}
		//发送网络消息通知对方
		//获取好友完整消息
		AccountVo friend = base.findByQQcode(qqcode);
		
		SendBody body = new SendBody();
		body.cmd = Cmd.CMD_ADDFRI;
		body.self = self;
		body.friend = friend;
		SendMsg.send(body);
    }
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==dataTable){
			addFriend();
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
