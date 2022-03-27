package org.apache.ibatis.demo;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Author xusheng
 * @Date 2022/3/27 10:38 AM
 * @Desc
 */
public interface UserDao {
    //@Select("select * from users")
    List<User> selectUsers();
}
