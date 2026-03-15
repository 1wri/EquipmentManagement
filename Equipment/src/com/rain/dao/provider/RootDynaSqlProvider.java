package com.rain.dao.provider;

import static com.rain.util.common.Constants.ROOTTABLE;

import org.apache.ibatis.jdbc.SQL;

import com.rain.domain.Root;

public class RootDynaSqlProvider {
			// 动态更新
			public String update_Root(Root root){
				
				return new SQL(){
					{
						UPDATE(ROOTTABLE);
						if(root.getPassword()!=null){
							SET("password = #{password}");
						}
						if(root.getUsername()!=null){
							SET("username = #{username}");
						}
						WHERE("loginname = #{loginname}");
					}
				}.toString();
			}
}
