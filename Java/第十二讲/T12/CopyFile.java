package T12;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class CopyFile extends JFrame implements ActionListener{

	JLabel lblSrc,lblDest;
	JTextField txtSrc,txtDest;
	JButton btnOpenFile,btnSaveFile,btnCopy;
	String srcFileName;
	//进度条
	JProgressBar progressBar;
	int progress=0;
	public CopyFile() {
		super("拷贝文件");
		setLayout(null);
		lblSrc = new JLabel("源文件：");
		lblDest = new JLabel("目标文件：");
		lblDest = new JLabel();
		txtSrc = new JTextField();
		//只读
		txtSrc.setEditable(false);
		txtDest = new JTextField();
		btnOpenFile = new JButton("选择文件");
		btnSaveFile = new JButton("拷贝文件");
		btnOpenFile.addActionListener(this);
		btnSaveFile.addActionListener(this);
		
//		btnCopy = new JButton("拷贝");
		
		lblSrc.setBounds(50, 30, 80, 20);
		add(lblSrc);
		txtSrc.setBounds(130, 30, 300, 20);
		add(txtSrc);
		btnOpenFile.setBounds(430, 30, 100, 20);
		add(btnOpenFile);

		lblDest.setBounds(50, 70, 80, 20);
		add(lblDest);
		txtDest.setBounds(130, 70, 300, 20);
		add(txtDest);
		btnSaveFile.setBounds(430, 70, 100, 20);
		add(btnSaveFile);
//		btnCopy.setBounds(430, 110, 100, 20);
//		add(btnCopy);
		//进度条
		progressBar = new JProgressBar();
		progressBar.setBounds(20, 130, 580, 20);
		add(progressBar);
		//最小值
		progressBar.setMinimum(0);
		//最大值
		progressBar.setMaximum(100);
		//当前值
		progressBar.setValue(0);
		progressBar.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		setSize(620, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
		new CopyFile();
	}
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileDlg = new JFileChooser();
		int result = 0;
		if(e.getSource()==btnSaveFile){
			fileDlg.setDialogType(JFileChooser.SAVE_DIALOG);
			fileDlg.setDialogTitle("拷贝文件");
			result = fileDlg.showSaveDialog(this);
			if(result==0){
				//获取选中的保存文件的路径及文件名称
				String destFile = fileDlg.getSelectedFile().getPath();
				txtDest.setText(destFile);
				try{
					//读源文件
					FileInputStream fis = new FileInputStream(srcFileName);
					BufferedInputStream bis = new BufferedInputStream(fis);
					//输出流保存文件
					FileOutputStream fos = new FileOutputStream(destFile);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					
					//获取文件大小
					int maxSize = fis.available();
					int size = 4096;
					byte b[] = new byte[size]; //4K
					int times=0;
					int len=0;
					CopyProgress cp = new CopyProgress(progressBar);
					cp.start();
					//返回-1表示已经读到文件的末尾
					while((len=bis.read(b))!=-1){
						//循环保存文件内容，每次4K
						bos.write(b, 0, len);
						times++;
						progress = (int)(size*times*1.0/maxSize*100);
						System.out.println(progress);
						Thread.sleep(10);
					}
					bos.flush();
					bos.close();
					bis.close();
					JOptionPane.showMessageDialog(this, "拷贝成功");
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}else if(e.getSource()==btnOpenFile){//打开文件
			fileDlg.setDialogType(JFileChooser.OPEN_DIALOG);
			String fileName = "";
			//弹出选择文件的对话框
			if(fileDlg.showDialog(this, "打开文件")==JFileChooser.APPROVE_OPTION){
				//获取选中的文件
				File file =fileDlg.getSelectedFile();
				fileName = file.getPath();//绝对路径
				srcFileName = file.getPath();//选择的文件名称
				txtSrc.setText(fileName);//把绝对路径显示在界面文本框
			}
			System.out.println("result="+result);
		}
	}
	class CopyProgress extends Thread{

		JProgressBar bar ;
		public CopyProgress(JProgressBar bar) {
			this.bar = bar;
		}
		public void run() {
			while(progress<100){
				bar.setValue(progress);
				bar.updateUI();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

