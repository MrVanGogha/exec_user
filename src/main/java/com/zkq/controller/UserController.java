package com.zkq.controller;

import com.zkq.dto.UserDto;
import com.zkq.entity.User;
import com.zkq.param.UserAddParam;
import com.zkq.param.UserQueryParam;
import com.zkq.service.UserService;
import com.zkq.utils.PageableRestResult;
import com.zkq.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 14:26 2020/7/13
 */
@CrossOrigin
@RestController
@RequestMapping("/login/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param param
     * @return
     */
    @PostMapping("/add")
    public User addUser(@RequestBody UserAddParam param){
        User result = userService.addUser(param);
        return result;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public String delUser(@PathVariable("id") Integer id){
        String result = userService.deleteUserById(id);
        return result;
    }


    @PutMapping("/edit")
    public void updateUser(User user){
        userService.updateUser(user);
    }
    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("query/{id}")
    public User queryUserById(@PathVariable("id")Integer id){
        User user = userService.queryUserById(id);
        return user;
    }


    /**
     * 分页查询用户(姓名模糊查询)
     */

    @GetMapping("list")

    public PageableRestResult<List<UserDto>> queryByPage(UserQueryParam param){
        Page<UserDto> page = userService.queryByPage(param);
        return PageableRestResult.success(page.getContent(),page.getTotalPages(),page.getTotalElements());
    }



    @PostMapping("upload")
    public RestResult upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String name = file.getName();
        String filePath = "D:/upload/";
        File dest = new File(filePath,originalFilename);
        file.transferTo(dest);
        return RestResult.success();
    }

    //查询所有用户
    @GetMapping("all")
    public RestResult all(){
        List<UserDto> all = userService.queryAll();
        return RestResult.success(all);
    }

}
