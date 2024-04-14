package com.linkedbear.springboot.webmvc.i_fileupload;

import com.linkedbear.springboot.webmvc.g_validation.Department;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/user914")
public class UserController914 {
    
    private List<Department> departmentList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    
    @PostConstruct
    public void init() throws Exception {
        Department dept1 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门1", "123321");
        departmentList.add(dept1);
        Department dept2 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门2", "1234567");
        departmentList.add(dept2);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        User user1 = new User(UUID.randomUUID().toString().replaceAll("-", ""),
                "zhangsan", "张三", dateFormat.parse("2023-01-01"), null, dept1);
        userList.add(user1);
        User user2 = new User(UUID.randomUUID().toString().replaceAll("-", ""),
                "lisi", "李四", dateFormat.parse("2023-02-02"), null, dept1);
        userList.add(user2);
        User user3 = new User(UUID.randomUUID().toString().replaceAll("-", ""),
                "wangwu", "王五", dateFormat.parse("2023-03-03"), null, dept2);
        userList.add(user3);
    }
    
    @GetMapping("/list")
    public String list(String username, Model model) {
        Stream<User> stream = this.userList.stream();
        if (StringUtils.hasText(username)) {
            stream = stream.filter(i -> i.getUsername().contains(username));
        }
        model.addAttribute("userList", stream.collect(Collectors.toList()));
        return "user/userList";
    }
    
    @GetMapping("/edit")
    public String edit(String id, Model model) {
        model.addAttribute("user", this.userList.stream().filter(i -> i.getId().equals(id)).findAny().orElse(null));
        model.addAttribute("deptList", this.departmentList);
        return "user/userInfo";
    }
    
    @PostMapping(value = "/save")
    public String save(User user, MultipartFile photoFile) throws IOException {
        Optional<User> op = this.userList.stream().filter(i -> i.getId().equals(user.getId())).findAny();
        if (op.isPresent()) {
            op.get().setPhoto(photoFile.getBytes());
        }
        return "redirect:/user914/list";
    }
    
    @PostMapping("/uploadPhoto")
    @ResponseBody
    public String uploadPhoto(MultipartFile file, String userId) {
        System.out.println(file.getName());
        // 后续的文件保存动作 ......
        return "success";
    }
    
    @GetMapping("/getPhoto")
    public ResponseEntity<byte[]> getPhoto(String id) throws UnsupportedEncodingException {
        User user = this.userList.stream().filter(i -> i.getId().equals(id)).findAny().orElse(null);
        if (user == null) {
            throw new RuntimeException("不存在的用户！");
        }
        byte[] photo = user.getPhoto();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", URLEncoder.encode(user.getUsername() + ".jpg", StandardCharsets.UTF_8));
        return new ResponseEntity<>(photo, headers, HttpStatus.CREATED);
    }
}
