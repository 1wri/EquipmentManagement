package com.rain.dao.provider;

import static com.rain.util.common.Constants.USERTABLE;

import org.apache.ibatis.jdbc.SQL;

import com.rain.domain.User;

public class UserDynaSqlProvider {
			// 动态插入
			public String insert_Notice(User job){
				
				return new SQL(){
					{
						INSERT_INTO(USERTABLE);
						if(job.getLoginname() != null ){
							VALUES("loginname", "#{loginname}");
						}
						if(job.getPassword()!=null){
							VALUES("password","#{password}");
						}
						if(job.getUsername()!=null){
							VALUES("username","#{username}");
						}
						if(job.getSex()!=null){
							VALUES("sex","#{sex}");
						}
						if(job.getAge()!=null){
							VALUES("age","#{age}");
						}
						if(job.getTel()!=null){
							VALUES("tel","#{tel}");
						}
							VALUES("del","0");
					}
				}.toString();
			}	
			// 动态更新
			public String update_Notice(User job){
				
				return new SQL(){
					{
						UPDATE(USERTABLE);
						if(job.getLoginname() != null ){
							SET("loginname = #{loginname}");
						}
						if(job.getPassword()!=null){
							SET("password = #{password}");
						}
						if(job.getUsername()!=null){
							SET("username = #{username}");
						}
						if(job.getSex()!=null){
							SET("sex=#{sex}");
						}
						if(job.getAge()!=null){
							SET("age=#{age}");
						}
						if(job.getTel()!=null){
							SET("tel=#{tel}");
						}
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
