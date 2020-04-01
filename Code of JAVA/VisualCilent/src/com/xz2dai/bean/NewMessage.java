package com.xz2dai.bean;

/**
 * ������
 * @author ����
 * @date 2020/2/12
 */
public class NewMessage {
	//���ű��
	private int messageId;
	//���ű���
	private String messageTitle;
	//��������
	private String messagecontent;
	//����ͼƬ
	private String messageImage;
	//����ʱ��
	private String messageTime;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessagecontent() {
		return messagecontent;
	}
	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}
	public String getMessageImage() {
		return messageImage;
	}
	public void setMessageImage(String messageImage) {
		this.messageImage = messageImage;
	}
	public String getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}
	
}
