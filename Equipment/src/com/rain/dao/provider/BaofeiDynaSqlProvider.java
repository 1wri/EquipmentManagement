package com.rain.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import static com.rain.util.common.Constants.BAOFEITABLE;

import com.rain.domain.Baofei;

public class BaofeiDynaSqlProvider {
	
	// 动态插入
		public String insertBaofei(Baofei baofei){
			
			return new SQL(){
				{
					INSERT_INTO(BAOFEITABLE);
					if(baofei.getEquipmentname() != null && !baofei.getEquipmentname().equals("")){
						VALUES("equipmentname", "#{equipmentname}");
					}
					if(baofei.getYuanyin() != null && !baofei.getYuanyin().equals("")){
						VALUES("yuanyin", "#{yuanyin}");
					}
					if(baofei.getZhuangtai() != null && !baofei.getZhuangtai().equals("")){
						VALUES("zhuangtai", "#{zhuangtai}");
					}
				}
			}.toString();
		}	
		// 动态更新
		public String updateBaofei(Baofei baofei){
			
			return new SQL(){
				{
					UPDATE(BAOFEITABLE);
					if(baofei.getEquipmentname() != null){
						SET(" equipmentname = #{equipmentname} ");
					}
					if(baofei.getYuanyin() != null){
						SET(" yuanyin = #{yuanyin} ");
					}
					if(baofei.getZhuangtai() != null){
						SET("  zhuangtai= #{zhuangtai} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}
