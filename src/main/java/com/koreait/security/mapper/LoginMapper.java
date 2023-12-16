package com.koreait.security.mapper;

import com.koreait.security.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    UserDTO get_user_by_id(String userID);
    void post_user(UserDTO dto);

}
