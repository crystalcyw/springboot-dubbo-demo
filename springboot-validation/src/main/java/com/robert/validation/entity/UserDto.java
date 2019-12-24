package com.robert.validation.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author changyuwei
 * @date 2019-12-24
 */
@Data
public class UserDto {

    private Long id;

    @NotNull(message = "用户名不能为空！")
    @Length(max = 20, message = "用户名长度不超过20！")
    private String name;

    @NotNull(message = "密码不能为空！")
    @Length(min = 6, max = 12, message = "密码长度在6到12")
    private String password;

    private String mobile;

    @Email
    private String email;

    private String address;
}
