package com.rain.dao;

import static com.rain.util.common.Constants.BAOXIUTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import com.rain.dao.provider.BaoxiuDynaSqlProvider;
import com.rain.domain.Baoxiu;
public interface BaoxiuDao {
	//查询
	@Select("select * from "+BAOXIUTABLE+" ")
	List<Baoxiu> selectAllBaoxiu();

	@SelectProvider(type=BaoxiuDynaSqlProvider.class,method="insertBaoxiu")
	void save(Baoxiu baoxiu);
	
	@Select("select * from "+BAOXIUTABLE+" where id = #{id}")
	Baoxiu get_BaoxiuInfo(Integer id);

	@SelectProvider(type=BaoxiuDynaSqlProvider.class,method="updateBaoxiu")
	void update_BaoxiuInfo(Baoxiu Baoxiu);

	@Delete(" delete from "+BAOXIUTABLE+" where id = #{id} ")
	void delete_BaoxiuInfo(Integer id);

	
}
