package com.suxton.kunmall.dao;

import com.suxton.kunmall.pojo.UserConsumed;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserConsumedMapper {
    List<UserConsumed> getUsersConsumed();
}
