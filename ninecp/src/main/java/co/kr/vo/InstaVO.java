package co.kr.vo;

import org.springframework.web.multipart.MultipartFile;

public class InstaVO {

	private Integer insta_bno;
	private String insta_int;
	private String insta_image;
	private MultipartFile image_rul;
	private int insta_love;
	private String insta_name;
	private String insta_profile;
	
	public String getInsta_profile() {
		return insta_profile;
	}
	public void setInsta_profile(String insta_profile) {
		this.insta_profile = insta_profile;
	}
	public String getInsta_name() {
		return insta_name;
	}
	public void setInsta_name(String insta_name) {
		this.insta_name = insta_name;
	}
	public Integer getInsta_bno() {
		return insta_bno;
	}
	public void setInsta_bno(Integer insta_bno) {
		this.insta_bno = insta_bno;
	}
	public String getInsta_int() {
		return insta_int;
	}
	public void setInsta_int(String insta_int) {
		this.insta_int = insta_int;
	}
	public String getInsta_image() {
		return insta_image;
	}
	public void setInsta_image(String insta_image) {
		this.insta_image = insta_image;
	}
	public MultipartFile getImage_rul() {
		return image_rul;
	}
	public void setImage_rul(MultipartFile image_rul) {
		this.image_rul = image_rul;
	}
	public int getInsta_love() {
		return insta_love;
	}
	public void setInsta_love(int insta_love) {
		this.insta_love = insta_love;
	}
	
	
}
