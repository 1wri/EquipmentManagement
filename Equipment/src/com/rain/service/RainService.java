package com.rain.service;

import java.util.List;

import com.rain.domain.User;
import com.rain.domain.Equipment;
import com.rain.domain.Baofei;
import com.rain.domain.Baoxiu;
import com.rain.domain.Caigou;
import com.rain.domain.Chuku;
import com.rain.domain.Root;
import com.rain.domain.Ruku;

public interface RainService {
	
	Root login(String loginname, String password);
	User login2(String loginname, String password);
	List<User> get_UserList();
	List<User> get_UserLikeList(String content);
	User get_UserInfo(Integer id);
	
	void update_UserInfo(User notice);
	void insert_UserInfo(User notice);
	void delete_UserInfo(Integer id);
	/**
	 * 设备信息的service
	 * @param content
	 * @return
	 */
	List<Equipment> findAllEquipment();
	List<Equipment> findAllEquipment(String content);
	Equipment get_Info(Integer id);
	void addEquipment(Equipment equipment);
	void delete_Info(Integer id);
	void baofei_Info(String equipmentname);
	void update_Info(Equipment equipment);
	/**
	 * 采购信息的service
	 * @return
	 */
	List<Caigou> findAllCaigou();
	List<Caigou> findAllCaigou(String content);
	Caigou get_CaigouInfo(Integer id);
	void addCaigou(Caigou caigou);
	void delete_CaigouInfo(Integer id);
	void update_CaigouInfo(Caigou caigou);
	/**
	 * 入库信息的service
	 * @return
	 */
	List<Ruku> findAllRuku();
	List<Ruku> findAllRuku(String content);
	Ruku get_RukuInfo(Integer id);
	void addRuku(Ruku ruku);
	void delete_RukuInfo(Integer id);
	void update_RukuInfo(Ruku ruku);
	/**
	 * 出库信息的service
	 * @return
	 */
	List<Chuku> findAllChuku();
	List<Chuku> findAllChuku(String content);
	Chuku get_ChukuInfo(Integer id);
	void addChuku(Chuku chuku);
	void delete_ChukuInfo(Integer id);
	void update_ChukuInfo(Chuku chuku);
	/**
	 * 报修息的service
	 * @return
	 */
	List<Baoxiu> findAllBaoxiu();
	Baoxiu get_BaoxiuInfo(Integer id);
	void addBaoxiu(Baoxiu baoxiu);
	void delete_BaoxiuInfo(Integer id);
	void update_BaoxiuInfo(Baoxiu baoxiu);
	/**
	 * 废报修息的service
	 * @return
	 */
	List<Baofei> findAllBaofei();
	Baofei get_BaofeiInfo(Integer id);
	void addBaofei(Baofei baofei);
	void yes_BaofeiInfo(Integer id);
	void no_BaofeiInfo(Integer id);
	void update_BaofeiInfo(Baofei baofei);
}
