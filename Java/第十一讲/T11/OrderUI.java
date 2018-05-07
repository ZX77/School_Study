package T11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OrderUI extends JFrame implements ActionListener{

	JTextField txtOrderId,txtOrderName,txtPrice,txtAddr;
	JButton btnAdd,btnSearch;
	//保存所有订单的集合
	Hashtable<String, Order> orderData = new Hashtable<String, Order>();
	public OrderUI() {
		super("订单管理");
		setLayout(null);
		JLabel lblOrderId,lblOrderName,lblPrice,lblAddr;
		lblOrderId = new JLabel("订 单 号：");
		lblOrderName = new JLabel("订单名称：");
		lblPrice = new JLabel("订单价格：");
		lblAddr = new JLabel("发货地址：");
		txtOrderId = new JTextField();
		txtOrderName = new JTextField();
		txtPrice = new JTextField();
		txtAddr = new JTextField();
		
		lblOrderId.setBounds(20, 50, 70, 20);
		txtOrderId.setBounds(80, 50, 150, 20);
		
		lblOrderName.setBounds(20, 80, 70, 20);
		txtOrderName.setBounds(80, 80, 150, 20);
		
		lblPrice.setBounds(20, 110, 70, 20);
		txtPrice.setBounds(80, 110, 150, 20);
		
		lblAddr.setBounds(20, 140, 70, 20);
		txtAddr.setBounds(80, 140, 150, 20);
		
		
		
		add(lblOrderId);
		add(txtOrderId);
		add(lblOrderName);
		add(txtOrderName);
		add(lblPrice);
		add(txtPrice);
		add(lblAddr);
		add(txtAddr);
		
		btnAdd = new JButton("添加(A)");
		btnAdd.setMnemonic('A');
		btnSearch = new JButton("查询(S)");
		btnSearch.setMnemonic('S');
		
		
		btnAdd.setBounds(40, 200, 80, 30);
		btnSearch.setBounds(130, 200, 80, 30);
		
		btnAdd.addActionListener(this);
		btnSearch.addActionListener(this);
		
		add(btnAdd);
		add(btnSearch);
		setSize(280, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new OrderUI();
	}

	public void actionPerformed(ActionEvent e) {
		String orderid="";
		if(e.getSource() == btnAdd){
			//获取控件中输入的值
			orderid = txtOrderId.getText();
			String name = txtOrderName.getText();
			String price = txtPrice.getText();
			String addr = txtAddr.getText();
			//生成订单
			Order order = new Order(orderid,name,price,addr);
			//把订单资料保存到集合中
			orderData.put(order.getOrderId(), order);
			JOptionPane.showMessageDialog(this, "添加成功");
		}else{
			//获取订单号数据
			orderid = txtOrderId.getText();
			
			//从集合中查找订单号对应的数据
			Order ord = orderData.get(orderid);
			if(ord==null){
				JOptionPane.showMessageDialog(this, "订单号为"+orderid+"的数据不存在.");
				return;
			}
			//从集合中返回的订单信息显示在窗口控件中
			txtOrderName.setText(ord.getOrderName());
			txtPrice.setText(ord.getPrice());
			txtAddr.setText(ord.getAddr());
		}
		
		
	}
}

//订单类
class Order{
	
	private String orderId;
	private String orderName;
	private String price;
	private String addr;
	
	public Order(String orderId,String orderName,String price,String addr){
		this.orderId = orderId;
		this.orderName = orderName;
		this.price = price;
		this.addr = addr;
	}
	public Order(){
		
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "订单号："+this.orderId+",名称："+this.orderName+",单价:"+this.price+",发货地址："+this.addr;
	}
	
}
