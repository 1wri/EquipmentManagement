package com.rain.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import static com.rain.util.common.Constants.EQUIPMENTTABLE;

import com.rain.domain.Equipment;

public class EquipmentDynaSqlProvider {
	
	// 动态插入
		public String insertEquipment(Equipment equipment){
			
			return new SQL(){
				{
					INSERT_INTO(EQUIPMENTTABLE);
					if(equipment.getName() != null && !equipment.getName().equals("")){
						VALUES("name", "#{name}");
					}
					if(equipment.getChangshang() != null && !equipment.getChangshang().equals("")){
						VALUES("changshang", "#{changshang}");
					}
					if(equipment.getDaxiao() != null && !equipment.getDaxiao().equals("")){
						VALUES("daxiao", "#{daxiao}");
					}
					if(equipment.getGuige() != null && !equipment.getGuige().equals("")){
						VALUES("guige", "#{guige}");
					}
					if(equipment.getKucun() != null && !equipment.getKucun().equals("")){
						VALUES("kucun", "#{kucun}");
					}
					VALUES("del","0");
				}
			}.toString();
		}	
		// 动态更新
		public String updateEquipment(Equipment equipment){
			
			return new SQL(){
				{
					UPDATE(EQUIPMENTTABLE);
					if(equipment.getName() != null){
						SET(" name = #{name} ");
					}
					if(equipment.getChangshang() != null){
						SET(" changshang = #{changshang} ");
					}
					if(equipment.getDaxiao() != null){
						SET("  daxiao= #{daxiao} ");
					}
					if(equipment.getGuige() != null){
						SET(" guige= #{guige} ");
					}
					if(equipment.getKucun() != null){
						SET("kucun = #{kucun} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}
