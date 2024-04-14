package com.linkedbear.springboot.webmvc.i_fileupload;

import com.linkedbear.springboot.webmvc.g_validation.Department;
import com.linkedbear.springboot.webmvc.g_validation.UserInfoGroup;
import com.linkedbear.springboot.webmvc.g_validation.UserNameGroup;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class User {
    
    private String id;
    
    @NotBlank(message = "用户名不能为空", groups = UserInfoGroup.class)
    @Length(min = 6, max = 20, message = "用户名的长度必须为6-20位", groups = UserInfoGroup.class)
    private String username;
    
    @NotBlank(message = "{user.name.notblank}", groups = {UserInfoGroup.class, UserNameGroup.class})
    private String name;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    
    private byte[] photo;
    
    private Department department;
    
    public User() {
    }
    
    public User(String id, String username, String name, Date birthday, byte[] photo, Department department) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.birthday = birthday;
        this.photo = photo;
        this.department = department;
    }
    
    @Override
    public String toString() {
        return "User{"
                + "id='"
                + id
                + '\''
                + ", username='"
                + username
                + '\''
                + ", name='"
                + name
                + '\''
                + ", birthday="
                + (birthday != null ? ZonedDateTime.ofInstant(birthday.toInstant(), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : "null")
                + ", department="
                + department
                + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public byte[] getPhoto() {
        return photo;
    }
    
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
}
