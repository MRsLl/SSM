package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface UserMapper {

    /**
     * 查询跟user的lastName有关的用户,或跟user性别相同的用户<br/>
     *  拿 user 的lastName属性做模糊查询,做user的sex查询用户
     */
    List<User> queryUserBySample(User user);

    /**
     *  如果lastName值有效,则只用lastName模糊查询 <br>
     *  如果lastName值无效,而sex值有效,则只使用sex查询 <br/>
     *  如果都无效,则可以使用自定义查询条件
     */
    List<User> queryUserBySampleChoose(User user);

    /**
     * 更新
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     *
     select * from 表名 where id in( xx ,xx ,xx );
     */
    List<User> queryUserByIds(@Param("ids") List<Integer> ids);

    /**
     * insert into 表名(列名,列名) values(值1,值2),(值1,值2),(值1,值2)
     */
    void insertUsers(List<User> users);

    User queryUserById(Integer id);

    int insertUser(User user);
}
