package com.springbook.biz.board.reply;

import java.util.Date;

public class ReplyVO {
	private Integer rno; //댓글 번호
	private Integer seq; //게시글 번호
	private String replytext; //댓글 내용
	private String replyer; //댓글 작성자
	private String uname; //댓글 작성자의 이름
	private Date regdate; //댓글 작성일자
	private Date updatedate; //댓글 수정일자
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
