package co.kr.vo;

import java.util.Date;

public class Insta_replyVO {

	private int bno;
	private int rno;
	private String content;
	private String writer;
	private String reply_img;
	
	public String getReply_img() {
		return reply_img;
	}
	public void setReply_img(String reply_img) {
		this.reply_img = reply_img;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	private Date regdate;
}
