package com.zkq.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 14:37 2020/7/13
 */

@Data
public class UserDto {
    private Integer id;
    private String userName;
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "GMT+8")
    private Date createTime;
}
