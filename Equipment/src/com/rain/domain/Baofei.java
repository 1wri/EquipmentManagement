package com.rain.domain;

import java.io.Serializable;

public class Baofei implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String equipmentname;
	private String yuanyin;
	private String zhuangtai;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEquipmentname() {
		return equipmentname;
	}
	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}
	public String getYuanyin() {
		return yuanyin;
	}
	public void setYuanyin(String yuanyin) {
		this.yuanyin = yuanyin;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
}
