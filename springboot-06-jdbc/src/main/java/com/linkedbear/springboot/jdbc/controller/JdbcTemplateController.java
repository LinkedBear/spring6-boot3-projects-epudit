package com.linkedbear.springboot.jdbc.controller;

import com.linkedbear.springboot.jdbc.entity.User;
import com.linkedbear.springboot.jdbc.entity.UserWithBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JdbcTemplateController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @GetMapping("/test1")
    public String test1() {
        System.out.println(jdbcTemplate);
        return "success";
    }
    
    @GetMapping("/test2")
    public String test2() {
        User user = new User();
        user.setName("heihei");
        user.setTel("200");
        int row = jdbcTemplate.update("insert into tbl_user (name, tel) values (?, ?)", user.getName(), user.getTel());
        return "success - " + row;
    }
    
    @GetMapping("/test3")
    public String test3() {
        User user = new User();
        user.setName("heihei");
        user.setTel("54321");
        int row = jdbcTemplate.update("update tbl_user set tel = ? where name = ?", user.getTel(), user.getName());
        return "success - " + row;
    }
    
    @GetMapping("/test4")
    public String test4() {
        int row = jdbcTemplate.update("delete from tbl_user where name = ?", "heihei");
        return "success - " + row;
    }
    
    @GetMapping("/test5")
    public List<User> test5() {
        List<User> userList = jdbcTemplate.query("select * from tbl_user", new BeanPropertyRowMapper<>(User.class));
        return userList;
    }
    
    @GetMapping("/test6")
    public List<User> test6() {
        List<User> userList = jdbcTemplate.query("select * from tbl_user where id > ?",
                new BeanPropertyRowMapper<>(User.class), 2);
        return userList;
    }
    
    @GetMapping("/test7")
    public User test7(int id) {
        //该代码有可能会抛出EmptyResultDataAccessException
        User user = jdbcTemplate.queryForObject("select * from tbl_user where id = ?",
                new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }
    
    @GetMapping("/test8")
    public User test8() {
        List<User> userList = jdbcTemplate.query("select * from tbl_user where id = ?",
                new BeanPropertyRowMapper<>(User.class), 2);
        User user = userList.size() > 0 ? userList.get(0) : null;
        return user;
    }
    
    @GetMapping("/test9")
    public User test9(int id) {
        // 该代码会抛出IncorrectResultSetColumnCountException
        User user = jdbcTemplate.queryForObject("select * from tbl_user where id = ?", User.class, id);
        return user;
    }
    
    @GetMapping("/test10")
    public Integer test10() {
        Integer count = jdbcTemplate.queryForObject("select count(*) from tbl_user", Integer.class);
        return count;
    }
    
    @GetMapping("/test11")
    public List<Map<String, Object>> test11() {
        List<Map<String, Object>> userList = jdbcTemplate.queryForList("select * from tbl_user where id > 3");
        return userList;
    }
    
    @GetMapping("/test12")
    public Map<String, Object> test12() {
        Map<String, Object> user = jdbcTemplate.queryForMap("select * from tbl_user where id = 3");
        return user;
    }
    
    @Autowired
    private DataSource dataSource;
    
    @GetMapping("/test13")
    public List<Map<String, Object>> test13() {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        Map<String, Object> params = new HashMap<>();
        params.put("id", 2);
        params.put("name", "ha%");
        // 等价于select * from tbl_user where id > ? and name like ?
        return jdbcTemplate.queryForList("select * from tbl_user where id > :id and name like :name", params);
    }
    
    @Autowired
    private LobHandler lobHandler;
    
    @GetMapping("/test14")
    public String test14() throws Exception {
        FileInputStream fis = new FileInputStream("E:/user/user-photo.jpg");
        byte[] imageBytes = FileCopyUtils.copyToByteArray(fis);
        
        jdbcTemplate.execute("update tbl_user_withblob set photo = ? where id = ?",
                new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
                    @Override
                    protected void setValues(PreparedStatement ps, LobCreator lobCreator)
                            throws SQLException, DataAccessException {
                        lobCreator.setBlobAsBytes(ps, 1, imageBytes);
                        ps.setInt(2, 1); // 给张三设置头像
                    }
                });
        return "success";
    }
    
    @GetMapping("/test15")
    public ResponseEntity<byte[]> test15() throws Exception {
        // 从数据库读取图片并保存到本地
        List<UserWithBlob> userWithBlobs = jdbcTemplate
                .query("select * from tbl_user_withblob where id = 1", (rs, rowNum) -> {
                    UserWithBlob user = new UserWithBlob();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setTel(rs.getString("tel"));
                    // 这里读取大字段
                    user.setPhoto(lobHandler.getBlobAsBytes(rs, "photo"));
                    return user;
                });
        if (userWithBlobs.size() > 0) {
            byte[] photo = userWithBlobs.get(0).getPhoto();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "photo.jpg");
            return new ResponseEntity<>(photo, headers, HttpStatus.CREATED);
        }
        return null;
    }
}
