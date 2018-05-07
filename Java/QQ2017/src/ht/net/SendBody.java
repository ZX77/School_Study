package ht.net;

import ht.bean.AccountVo;

import java.io.Serializable;

import javax.swing.text.StyledDocument;

public class SendBody implements Serializable{

	//命令字
	public int cmd;
	//发送人
	public AccountVo self;
	//接收人
	public AccountVo friend;
	//内容
	public StyledDocument doc;
	//发送文件名称
	public String fileName;
	//文件内容,必须在64k以内
	public byte b[];
}
