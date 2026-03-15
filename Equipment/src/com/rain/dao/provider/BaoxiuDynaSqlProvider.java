package com.rain.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import static com.rain.util.common.Constants.BAOXIUTABLE;

import com.rain.domain.Baoxiu;

public class BaoxiuDynaSqlProvider {
	
	// 动态插入
		public String insertBaoxiu(Baoxiu baoxiu){
			
			return new SQL(){
				{
					INSERT_INTO(BAOXIUTABLE);
					if(baoxiu.getEquipmentname() != null && !baoxiu.getEquipmentname().equals("")){
						VALUES("equipmentname", "#{equipmentname}");
					}
					if(baoxiu.getWeixiushijian() != null && !baoxiu.getWeixiushijian().equals("")){
						VALUES("weixiushijian", "#{weixiushijian}");
					}
					if(baoxiu.getYuanyin() != null && !baoxiu.getYuanyin().equals("")){
						VALUES("yuanyin", "#{yuanyin}");
					}
					if(baoxiu.getJieguo() != null && !baoxiu.getJieguo().equals("")){
						VALUES("jieguo", "#{jieguo}");
					}
					if(baoxiu.getWeixiuren() != null && !baoxiu.getWeixiuren().equals("")){
						VALUES("weixiuren", "#{weixiuren}");
					}
				}
			}.toString();
		}	
		// 动态更新
		public String updateBaoxiu(Baoxiu baoxiu){
			
			return new SQL(){
				{
					UPDATE(BAOXIUTABLE);
					if(baoxiu.getEquipmentname() != null){
						SET(" equipmentname = #{equipmentname} ");
					}
					if(baoxiu.getWeixiushijian() != null){
						SET(" weixiushijian = #{weixiushijian} ");
					}
					if(baoxiu.getYuanyin() != null){
						SET("  yuanyin= #{yuanyin} ");
					}
					if(baoxiu.getJieguo() != null){
						SET(" jieguo= #{jieguo} ");
					}
					if(baoxiu.getWeixiuren() != null){
						SET("weixiuren = #{weixiuren} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}
