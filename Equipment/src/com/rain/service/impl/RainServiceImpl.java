package com.rain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rain.dao.EquipmentDao;
import com.rain.dao.BaofeiDao;
import com.rain.dao.BaoxiuDao;
import com.rain.dao.CaigouDao;
import com.rain.dao.ChukuDao;
import com.rain.dao.RootDao;
import com.rain.dao.RukuDao;
import com.rain.dao.UserDao;
import com.rain.domain.Equipment;
import com.rain.domain.Baofei;
import com.rain.domain.Baoxiu;
import com.rain.domain.Caigou;
import com.rain.domain.Chuku;
import com.rain.domain.Root;
import com.rain.domain.Ruku;
import com.rain.domain.User;
import com.rain.service.RainService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("RainService")
public class RainServiceImpl implements RainService{
	
	@Autowired
	private RootDao rootdao;
	@Autowired
	private UserDao userdao;
	@Autowired
	private EquipmentDao equipmentDao;
	@Autowired
	private CaigouDao caigouDao;
	@Autowired
	private RukuDao rukuDao;
	@Autowired
	private ChukuDao chukuDao;
	@Autowired
	private BaoxiuDao baoxiuDao;
	@Autowired
	private BaofeiDao baofeiDao;

	/**
	 * 用户信息管理
	 */
	@Override
	public Root login(String loginname, String password) {
		// TODO Auto-generated method stub
		Root root = rootdao.get_login(loginname,password);
		return root;
	}
	@Override
	public User login2(String loginname, String password) {
		// TODO Auto-generated method stub
		return userdao.get_login(loginname,password);
	}
	@Override
	public List<User> get_UserList() {
		// TODO Auto-generated method stub
		return userdao.get_List();
	}
	@Override
	public List<User> get_UserLikeList(String content) {
		// TODO Auto-generated method stub
		return userdao.get_LikeList(content);
	}
	@Override
	public User get_UserInfo(Integer id) {
		// TODO Auto-generated method stub
		return userdao.get_Info(id);
	}
	@Override
	public void insert_UserInfo(User notice) {
		// TODO Auto-generated method stub
		userdao.insert_Info(notice);
	}
	@Override
	public void delete_UserInfo(Integer id) {
		// TODO Auto-generated method stub
		userdao.delete_Info(id);
	}
	@Override
	public void update_UserInfo(User notice) {
		// TODO Auto-generated method stub
		userdao.update_Info(notice);
	}
	
	/**
	 * 用户信息管理
	 */
	@Transactional(readOnly=true)
	@Override
	public List<Equipment> findAllEquipment() {
		return equipmentDao.selectAllEquipment();
	}
	@Override
	public List<Equipment> findAllEquipment(String content) {
		// TODO Auto-generated method stub
		return equipmentDao.selectLikeAllEquipment(content);
	}
	@Override
	public Equipment get_Info(Integer id) {
		// TODO Auto-generated method stub
		Equipment equipment = equipmentDao.get_Info(id);
		return equipment;
	}
	@Override
	public void addEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		equipmentDao.save(equipment);
	}
	@Override
	public void delete_Info(Integer id) {
		// TODO Auto-generated method stub
		equipmentDao.delete_Info(id);
	}
	@Override
	public void baofei_Info(String equipmentname) {
		// TODO Auto-generated method stub
		equipmentDao.baofei_Info(equipmentname);
	}
	@Override
	public void update_Info(Equipment equipment) {
		// TODO Auto-generated method stub
		equipmentDao.update_Info(equipment);
	}
	/**
	 * 采购信息管理
	 */
	@Override
	public List<Caigou> findAllCaigou() {
		return caigouDao.selectAllCaigou();
	}
	@Override
	public List<Caigou> findAllCaigou(String content) {
		// TODO Auto-generated method stub
		return caigouDao.selectLikeAllCaigou(content);
	}
	@Override
	public Caigou get_CaigouInfo(Integer id) {
		// TODO Auto-generated method stub
		Caigou caigou = caigouDao.get_CaigouInfo(id);
		return caigou;
	}
	@Override
	public void addCaigou(Caigou caigou) {
		// TODO Auto-generated method stub
		caigouDao.save(caigou);
	}
	@Override
	public void delete_CaigouInfo(Integer id) {
		// TODO Auto-generated method stub
		caigouDao.delete_CaigouInfo(id);
	}
	@Override
	public void update_CaigouInfo(Caigou caigou) {
		// TODO Auto-generated method stub
		caigouDao.update_CaigouInfo(caigou);
	}
	/**
	 * 入库信息管理
	 */
	@Override
	public List<Ruku> findAllRuku() {
		return rukuDao.selectAllRuku();
	}
	@Override
	public List<Ruku> findAllRuku(String content) {
		// TODO Auto-generated method stub
		return rukuDao.selectLikeAllRuku(content);
	}
	@Override
	public Ruku get_RukuInfo(Integer id) {
		// TODO Auto-generated method stub
		Ruku ruku = rukuDao.get_RukuInfo(id);
		return ruku;
	}
	@Override
	public void addRuku(Ruku ruku) {
		// TODO Auto-generated method stub
		Integer kucun1=0,kucun2=0;
		Equipment equipment=equipmentDao.selectLikeAllEquipment(ruku.getEquipmentname()).get(0);
		kucun1=equipment.getKucun();
		kucun2=ruku.getShuliang();	
		equipment.setKucun(kucun1+kucun2);
		equipmentDao.update_Info(equipment);
		rukuDao.save(ruku);
	}
	@Override
	public void delete_RukuInfo(Integer id) {
		// TODO Auto-generated method stub
		rukuDao.delete_RukuInfo(id);
	}
	@Override
	public void update_RukuInfo(Ruku ruku) {
		// TODO Auto-generated method stub
		
		Integer kucun1=0,kucun2=0,kucun3=0;
		Equipment equipment=equipmentDao.selectLikeAllEquipment(ruku.getEquipmentname()).get(0);
		kucun1=equipment.getKucun();
		kucun2=ruku.getShuliang();
		kucun3=rukuDao.get_RukuInfo(ruku.getId()).getShuliang();	
		equipment.setKucun(kucun1+kucun2-kucun3);
		equipmentDao.update_Info(equipment);
		rukuDao.update_RukuInfo(ruku);
		
		
	}
	/**
	 * 出库信息管理
	 */
	@Override
	public List<Chuku> findAllChuku() {
		return chukuDao.selectAllChuku();
	}
	@Override
	public List<Chuku> findAllChuku(String content) {
		// TODO Auto-generated method stub
		return chukuDao.selectLikeAllChuku(content);
	}
	@Override
	public Chuku get_ChukuInfo(Integer id) {
		// TODO Auto-generated method stub
		Chuku chuku = chukuDao.get_ChukuInfo(id);
		return chuku;
	}
	@Override
	public void addChuku(Chuku chuku) {
		// TODO Auto-generated method stub
		Integer kucun1=0,kucun2=0;
		Equipment equipment=equipmentDao.selectLikeAllEquipment(chuku.getEquipmentname()).get(0);
		kucun1=equipment.getKucun();
		kucun2=chuku.getShuliang();	
		equipment.setKucun(kucun1-kucun2);
		equipmentDao.update_Info(equipment);
		chukuDao.save(chuku);
	}
	@Override
	public void delete_ChukuInfo(Integer id) {
		// TODO Auto-generated method stub
		chukuDao.delete_ChukuInfo(id);
	}
	@Override
	public void update_ChukuInfo(Chuku chuku) {
		// TODO Auto-generated method stub
		Integer kucun1=0,kucun2=0,kucun3=0;
		Equipment equipment=equipmentDao.selectLikeAllEquipment(chuku.getEquipmentname()).get(0);
		kucun1=equipment.getKucun();
		kucun2=chuku.getShuliang();	
		kucun3=chukuDao.get_ChukuInfo(chuku.getId()).getShuliang();
		equipment.setKucun(kucun1-(kucun2-kucun3));
		equipmentDao.update_Info(equipment);
		chukuDao.update_ChukuInfo(chuku);
	}
	/**
	 * 报修信息管理
	 */
	@Override
	public List<Baoxiu> findAllBaoxiu() {
		return baoxiuDao.selectAllBaoxiu();
	}
	@Override
	public Baoxiu get_BaoxiuInfo(Integer id) {
		// TODO Auto-generated method stub
		Baoxiu baoxiu = baoxiuDao.get_BaoxiuInfo(id);
		return baoxiu;
	}
	@Override
	public void addBaoxiu(Baoxiu baoxiu) {
		// TODO Auto-generated method stub
		baoxiuDao.save(baoxiu);
	}
	@Override
	public void delete_BaoxiuInfo(Integer id) {
		// TODO Auto-generated method stub
		baoxiuDao.delete_BaoxiuInfo(id);
	}
	@Override
	public void update_BaoxiuInfo(Baoxiu baoxiu) {
		// TODO Auto-generated method stub
		baoxiuDao.update_BaoxiuInfo(baoxiu);
	}
	/**
	 * 报废信息管理
	 */
	@Override
	public List<Baofei> findAllBaofei() {
		return baofeiDao.selectAllBaofei();
	}
	@Override
	public Baofei get_BaofeiInfo(Integer id) {
		// TODO Auto-generated method stub
		Baofei baofei = baofeiDao.get_BaofeiInfo(id);
		return baofei;
	}
	@Override
	public void addBaofei(Baofei baofei) {
		// TODO Auto-generated method stub
		baofeiDao.save(baofei);
	}
	@Override
	public void yes_BaofeiInfo(Integer id) {
		// TODO Auto-generated method stub
		baofeiDao.yes_BaofeiInfo(id);
	}
	public void no_BaofeiInfo(Integer id) {
		// TODO Auto-generated method stub
		baofeiDao.no_BaofeiInfo(id);
	}
	@Override
	public void update_BaofeiInfo(Baofei baofei) {
		// TODO Auto-generated method stub
		baofeiDao.update_BaofeiInfo(baofei);
	}
	/**
	 * 员工信息的管理
	 */
//	@Override
//	public List<Employee> get_EmployeeList() {
//		// TODO Auto-generated method stub
//		/**
//		 * 将部门，职位id中的信息提取出来
//		 */
//		List<Employee> list = employeedao.get_List();
//		int size = list.size();
//		List<Employee> list2 = new ArrayList<>();
//		for(int i = 0;i<size;i++){
//			Employee data = list.get(i);
//			Equipment dept = deptDao.get_Info(data.getDept_id());
//			data.setDept(dept);
//			Job job = jobDao.get_Info(data.getJob_id());
//			data.setJob(job);
//			list2.add(i,data);
//		}
//		return list2;
//	}
//	@Override
//	public List<Employee> get_EmployeeLikeList(String content) {
//		// TODO Auto-generated method stub
//		/**
//		 * 将部门，职位id中的信息提取出来
//		 */
//		List<Employee> list = employeedao.get_LikeList(content);
//		int size = list.size();
//		List<Employee> list2 = new ArrayList<>();
//		for(int i = 0;i<size;i++){
//			Employee data = list.get(i);
//			Equipment dept = deptDao.get_Info(data.getDept_id());
//			data.setDept(dept);
//			Job job = jobDao.get_Info(data.getJob_id());
//			data.setJob(job);
//			list2.add(i,data);
//		}
//		return list2;
//	}
//	@Override
//	public Employee get_EmployeeInfo(Integer id) {
//		// TODO Auto-generated method stub
//		Employee data = employeedao.get_Info(id);
//		Equipment dept = deptDao.get_Info(data.getDept_id());
//		data.setDept(dept);
//		Job job = jobDao.get_Info(data.getJob_id());
//		data.setJob(job);
//		return data;
//	}
}
