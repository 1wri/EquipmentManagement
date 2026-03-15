package com.rain.dao;

import static com.rain.util.common.Constants.CAIGOUTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import com.rain.dao.provider.CaigouDynaSqlProvider;
import com.rain.domain.Caigou;
public interface CaigouDao {
	//查询
	@Select("select * from "+CAIGOUTABLE+" ")
	List<Caigou> selectAllCaigou();
	@Select("select * from "+CAIGOUTABLE+" where equipmentname like CONCAT('%',#{content},'%')")
	List<Caigou> selectLikeAllCaigou(String content);
	
	
	@SelectProvider(type=CaigouDynaSqlProvider.class,method="insertCaigou")
	void save(Caigou caigou);
	
	@Select("select * from "+CAIGOUTABLE+" where id = #{id}")
	Caigou get_CaigouInfo(Integer id);

	@SelectProvider(type=CaigouDynaSqlProvider.class,method="updateCaigou")
	void update_CaigouInfo(Caigou Caigou);

	@Delete(" delete from "+CAIGOUTABLE+" where id = #{id} ")
	void delete_CaigouInfo(Integer id);

	
}
