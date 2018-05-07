package T15;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;


public class FindUI extends JFrame{

	JLabel lblQQcode,lblNickName,lblAge;
	JTextField txtQQcode,txtNickName,txtAge;
	JComboBox cbSex,cbStatus;
	JTable dataTable;
	JButton btnFind,btnAdd,btnClose;
	AccountInfo myInfo;
	Vector<String> vHead;
	Vector vData;
	public FindUI() {
		init();
	}
	public FindUI(AccountInfo acc) {
		this.myInfo = acc;
		init();
	}
	String sSex[] = {"不选择","男","女"};
	String sStatus[]={"不选择","在线","离线","忙碌","隐身"};
	AccountADO baseDAO = new AccountDaoImpl();
	public void init(){
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblQQcode = new JLabel("QQ号码");
		lblNickName = new JLabel("昵称");
		lblAge = new JLabel("年龄");
		txtQQcode = new JTextField(8);
		txtNickName = new JTextField(8);
		txtAge = new JTextField(5);
		cbSex = new JComboBox(sSex);
		cbStatus = new JComboBox(sStatus);
		btnFind = new JButton("查找");
		topPanel.add(lblQQcode);
		topPanel.add(txtQQcode);
		topPanel.add(lblNickName);
		topPanel.add(txtNickName);
		topPanel.add(lblAge);
		topPanel.add(txtAge);
		topPanel.add(cbSex);
		topPanel.add(cbStatus);
		topPanel.add(btnFind);
		add(topPanel,BorderLayout.NORTH);
		String[] columnNames = {"QQ号码","昵称", "年龄", "性别","血型","星座","民族","爱好","备注"};
		vHead = new Vector<String>();
		for(int i=0;i<columnNames.length;i++){
			vHead.addElement(columnNames[i]);
		}
		vData = baseDAO.find();
		dataTable = new JTable(new MyTableModel(vHead,vData));
		dataTable.setRowHeight(60);
		add(new JScrollPane(dataTable));
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnAdd = new JButton("添加好友");
		btnClose = new JButton("关闭窗口");
		bottomPanel.add(btnAdd);
		bottomPanel.add(btnClose);
		add(bottomPanel,BorderLayout.SOUTH);
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new FindUI();
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
        	Vector rowData = (Vector)vData.get(row);
			if(col==0){//表示头像
				return new ImageIcon(rowData.get(col).toString());
			}else{
				return rowData.get(col);
			}
        }
        //返回指定列的数据类型
        @Override
		public Class<?> getColumnClass(int c) {
			return super.getColumnClass(c);
        }
        //设置单元格是否可修改
        public boolean isCellEditable(int row, int col) {
            return false;
        }

        //设置单元格的值
        public void setValueAt(Object value, int row, int col) {
        	Vector rowData = (Vector)vData.get(row);
        	rowData.set(col, value);
            fireTableCellUpdated(row, col);
        }
    }
}
