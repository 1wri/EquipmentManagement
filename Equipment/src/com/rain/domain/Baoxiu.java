package com.rain.domain;

import java.io.Serializable;

public class Baoxiu implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String equipmentname;
	private String weixiushijian;
	private String yuanyin;
	private String jieguo;
	private String weixiuren;
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
	public String getWeixiushijian() {
		return weixiushijian;
	}
	public void setWeixiushijian(String weixiushijian) {
		this.weixiushijian = weixiushijian;
	}
	public String getYuanyin() {
		return yuanyin;
	}
	public void setYuanyin(String yuanyin) {
		this.yuanyin = yuanyin;
	}
	public String getJieguo() {
		return jieguo;
	}
	public void setJieguo(String jieguo) {
		this.jieguo = jieguo;
	}
	public String getWeixiuren() {
		return weixiuren;
	}
	public void setWeixiuren(String weixiuren) {
		this.weixiuren = weixiuren;
	}

}
