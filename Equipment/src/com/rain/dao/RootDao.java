package com.rain.dao;

import static com.rain.util.common.Constants.ROOTTABLE;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.rain.dao.provider.RootDynaSqlProvider;
import com.rain.domain.Root;

public interface RootDao {

	@Select("select * from "+ROOTTABLE+"  where loginname = #{loginname} AND password = #{password}")
	Root get_login(@Param("loginname") String loginname,
			@Param("password") String password);

	@SelectProvider(type=RootDynaSqlProvider.class,method="update_Root")
	void update_RootInfo(Root root);

}
