package com.zkq.service;


import com.zkq.dao.UserDao;
import com.zkq.dto.UserDto;
import com.zkq.entity.User;
import com.zkq.param.UserAddParam;
import com.zkq.param.UserQueryParam;
import com.zkq.utils.BeanConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 14:25 2020/7/13
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 添加用户
     * @param param
     * @return
     */
    public User addUser(UserAddParam param) {
        User user = BeanConvert.convertBean(param, User.class);
        User save = userDao.save(user);
        return save;
    }

    /**
     * 根据主键id查询用户
     * @param id
     * @return
     */
    public User queryUserById(Integer id) {
        Optional<User> optionalUser = userDao.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        return null;
    }

    /**
     * 根据主键删除用户
     * @param id
     * @return
     */
    public String deleteUserById(Integer id) {
        Optional<User> optionalUser = userDao.findById(id);
        if(optionalUser.isPresent()){
            userDao.deleteById(id);
            return "删除成功";
        }
        return "用户不存在";
    }

    /**
     * 根据主键更新用户
     * @param user
     */
    public void updateUser(User user) {
        userDao.findById(user.getId()).ifPresent(new Consumer<User>() {
            @Override
            public void accept(User user1) {
                BeanUtils.copyProperties(user,user1);
                userDao.save(user1);
            }
        });
    }

    /**
     * 分页查询
     * @param param
     * @return
     */
    public Page<UserDto> queryByPage(UserQueryParam param) {
        Pageable pageable = PageRequest.of(param.getPageNum()-1,param.getPageSize());
        Page<User> users = userDao.findAll((root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(!StringUtils.isEmpty(param.getUserName())){
                predicates.add(cb.like(root.get("userName"),"%"+param.getUserName()+"%"));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        }, pageable);
        return users.map(user -> BeanConvert.convertBean(user, UserDto.class));
    }

    public List<UserDto> queryAll() {
        List<User> all = userDao.findAll();
        return BeanConvert.convertList(all,UserDto.class);
    }
}
