package com.rain.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import static com.rain.util.common.Constants.RUKUTABLE;

import com.rain.domain.Ruku;

public class RukuDynaSqlProvider {
	
	// 动态插入
		public String insertRuku(Ruku ruku){
			
			return new SQL(){
				{
					INSERT_INTO(RUKUTABLE);
					if(ruku.getEquipmentname() != null && !ruku.getEquipmentname().equals("")){
						VALUES("equipmentname", "#{equipmentname}");
					}
					if(ruku.getTime() != null && !ruku.getTime().equals("")){
						VALUES("time", "#{time}");
					}
					if(ruku.getShuliang() != null && !ruku.getShuliang().equals("")){
						VALUES("shuliang", "#{shuliang}");
					}
					if(ruku.getFuzeren() != null && !ruku.getFuzeren().equals("")){
						VALUES("fuzeren", "#{fuzeren}");
					}
					if(ruku.getBeizhu() != null && !ruku.getBeizhu().equals("")){
						VALUES("beizhu", "#{beizhu}");
					}
				}
			}.toString();
		}	
		// 动态更新
		public String updateRuku(Ruku ruku){
			
			return new SQL(){
				{
					UPDATE(RUKUTABLE);
					if(ruku.getEquipmentname() != null){
						SET(" equipmentname = #{equipmentname} ");
					}
					if(ruku.getTime() != null){
						SET(" time = #{time} ");
					}
					if(ruku.getShuliang() != null){
						SET("  shuliang= #{shuliang} ");
					}
					if(ruku.getFuzeren() != null){
						SET("fuzeren = #{fuzeren} ");
					}
					if(ruku.getBeizhu() != null){
						SET("beizhu = #{beizhu} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}
