package com.springbook.biz.board.reply;

import java.util.Date;

public class ReplyVO {
	private Integer rno; //��� ��ȣ
	private Integer seq; //�Խñ� ��ȣ
	private String replytext; //��� ����
	private String replyer; //��� �ۼ���
	private String uname; //��� �ۼ����� �̸�
	private Date regdate; //��� �ۼ�����
	private Date updatedate; //��� ��������
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}

	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", seq=" + seq + ", replytext=" + replytext + ", replyer=" + replyer + ", uname="
				+ uname + ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}

}
