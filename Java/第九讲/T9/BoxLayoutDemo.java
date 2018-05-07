package T9;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo {

    public static void main(String[] args) {

        JFrame jf = new JFrame("BoxLayout Demo");

        JButton b1 = new JButton("button1");
        JButton b2 = new JButton("button2");
        JButton b3 = new JButton("button3");
        JButton b4 = new JButton("button4");
        JButton b5 = new JButton("button5");
        JButton b6 = new JButton("button6");

        //获取主窗口的容器
        Container c = jf.getContentPane();

        ContainerWithBoxLayout yc = new ContainerWithBoxLayout(BoxLayout.Y_AXIS);//垂直布局
        ContainerWithBoxLayout xc = new ContainerWithBoxLayout(BoxLayout.X_AXIS);//水平布局

        //主窗口流布局
        c.setLayout(new FlowLayout());

        xc.add(b1);
        xc.add(b2);
        xc.add(b3);
        yc.add(b4);
        yc.add(b5);
        yc.add(b6);

        c.add(xc);
        c.add(yc);

        jf.setSize(300, 400);
        jf.setVisible(true);

    }
}

//自定义JPanel类
class ContainerWithBoxLayout extends JPanel {
    public ContainerWithBoxLayout(int orientation) {
    	//设置BoxLayout的布局方式：水平布局，垂直布局
        setLayout(new BoxLayout(this, orientation));
    }
}
