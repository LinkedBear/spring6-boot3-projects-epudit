package com.linkedbear.springboot.mybatis.mapper;

import com.github.pagehelper.PageInfo;
import com.linkedbear.springboot.mybatis.entity.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
@CacheNamespace
public interface UserMapper {
    
    void save(User user);
    
    List<User> findAll();
    
    @Select("select * from tbl_user where name like concat('%', #{name}, '%')")
    List<User> findAllByNameLike(@Param("name") String name);
    
    @Delete("delete from tbl_user where id = #{id}")
    int deleteById(String id);
    
    @Update("CREATE TABLE tbl_role (\n"
                    + "  id int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  code varchar(20) NULL,\n"
                    + "  name varchar(32) NULL,\n"
                    + "  PRIMARY KEY (id)\n"
                    + ");")
    int excuteDDL();
    
    @Select("select * from tbl_user")
    PageInfo<User> pageAll(Integer pageNum, Integer pageSize);
}
