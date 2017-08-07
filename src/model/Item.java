package model;

import java.awt.image.BufferedImage;

public class Item {
	Integer type;
	String imgsrc ;
	String info; 
	Integer imgId;
	Integer userId;
	public Item(Integer type,String imgsrc,String info,Integer imgId,Integer userId) {
		this.type=type;
		this.imgsrc=imgsrc;
		this.info=info;
		this.imgId=imgId;
		this.userId=userId;
	}
	public String getImg() {
		return imgsrc;
	}
	public Integer getImgId() {
		return imgId;
	}
	public String getInfo() {
		return info;
	}
	public Integer getType() {
		return type;
	}
	public Integer getUserId() {
		return userId;
	}
}
