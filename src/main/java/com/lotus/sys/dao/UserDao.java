package com.lotus.sys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.lotus.sys.dto.UserDto;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserDao{
	public List<UserDto> getUserList();
	
	@Select("select * from sys_user where id=#{id} ")
	public UserDto getUserInfo(String id);

}
