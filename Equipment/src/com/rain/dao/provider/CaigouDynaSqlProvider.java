package com.rain.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import static com.rain.util.common.Constants.CAIGOUTABLE;

import com.rain.domain.Caigou;

public class CaigouDynaSqlProvider {
	
	// 动态插入
		public String insertCaigou(Caigou caigou){
			
			return new SQL(){
				{
					INSERT_INTO(CAIGOUTABLE);
					if(caigou.getEquipmentname() != null && !caigou.getEquipmentname().equals("")){
						VALUES("equipmentname", "#{equipmentname}");
					}
					if(caigou.getTime() != null && !caigou.getTime().equals("")){
						VALUES("time", "#{time}");
					}
					if(caigou.getShuliang() != null && !caigou.getShuliang().equals("")){
						VALUES("shuliang", "#{shuliang}");
					}
					if(caigou.getPrice() != null && !caigou.getPrice().equals("")){
						VALUES("price", "#{price}");
					}
					if(caigou.getFuzeren() != null && !caigou.getFuzeren().equals("")){
						VALUES("fuzeren", "#{fuzeren}");
					}
					if(caigou.getBeizhu() != null && !caigou.getBeizhu().equals("")){
						VALUES("beizhu", "#{beizhu}");
					}
				}
			}.toString();
		}	
		// 动态更新
		public String updateCaigou(Caigou caigou){
			
			return new SQL(){
				{
					UPDATE(CAIGOUTABLE);
					if(caigou.getEquipmentname() != null){
						SET(" equipmentname = #{equipmentname} ");
					}
					if(caigou.getTime() != null){
						SET(" time = #{time} ");
					}
					if(caigou.getShuliang() != null){
						SET("  shuliang= #{shuliang} ");
					}
					if(caigou.getPrice() != null){
						SET(" price= #{price} ");
					}
					if(caigou.getFuzeren() != null){
						SET("fuzeren = #{fuzeren} ");
					}
					if(caigou.getBeizhu() != null){
						SET("beizhu = #{beizhu} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}
