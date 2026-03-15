package com.rain.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import static com.rain.util.common.Constants.CHUKUTABLE;

import com.rain.domain.Chuku;

public class ChukuDynaSqlProvider {
	
	// 动态插入
		public String insertChuku(Chuku chuku){
			
			return new SQL(){
				{
					INSERT_INTO(CHUKUTABLE);
					if(chuku.getEquipmentname() != null && !chuku.getEquipmentname().equals("")){
						VALUES("equipmentname", "#{equipmentname}");
					}
					if(chuku.getTime() != null && !chuku.getTime().equals("")){
						VALUES("time", "#{time}");
					}
					if(chuku.getShuliang() != null && !chuku.getShuliang().equals("")){
						VALUES("shuliang", "#{shuliang}");
					}
					if(chuku.getFuzeren() != null && !chuku.getFuzeren().equals("")){
						VALUES("fuzeren", "#{fuzeren}");
					}
					if(chuku.getBeizhu() != null && !chuku.getBeizhu().equals("")){
						VALUES("beizhu", "#{beizhu}");
					}
				}
			}.toString();
		}	
		// 动态更新
		public String updateChuku(Chuku chuku){
			
			return new SQL(){
				{
					UPDATE(CHUKUTABLE);
					if(chuku.getEquipmentname() != null){
						SET(" equipmentname = #{equipmentname} ");
					}
					if(chuku.getTime() != null){
						SET(" time = #{time} ");
					}
					if(chuku.getShuliang() != null){
						SET("  shuliang= #{shuliang} ");
					}
					if(chuku.getFuzeren() != null){
						SET("fuzeren = #{fuzeren} ");
					}
					if(chuku.getBeizhu() != null){
						SET("beizhu = #{beizhu} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}
