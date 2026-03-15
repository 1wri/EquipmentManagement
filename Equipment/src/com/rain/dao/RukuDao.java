package com.rain.dao;

import static com.rain.util.common.Constants.RUKUTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import com.rain.dao.provider.RukuDynaSqlProvider;
import com.rain.domain.Ruku;
public interface RukuDao {
	//查询
	@Select("select * from "+RUKUTABLE+" ")
	List<Ruku> selectAllRuku();
	@Select("select * from "+RUKUTABLE+" where equipmentname like CONCAT('%',#{content},'%')")
	List<Ruku> selectLikeAllRuku(String content);
	
	
	@SelectProvider(type=RukuDynaSqlProvider.class,method="insertRuku")
	void save(Ruku ruku);
	
	@Select("select * from "+RUKUTABLE+" where id = #{id}")
	Ruku get_RukuInfo(Integer id);

	@SelectProvider(type=RukuDynaSqlProvider.class,method="updateRuku")
	void update_RukuInfo(Ruku Ruku);

	@Delete(" delete from "+RUKUTABLE+" where id = #{id} ")
	void delete_RukuInfo(Integer id);

	
}
