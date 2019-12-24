package com.robert.validation.controller;

import com.robert.validation.entity.UserDto;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changyuwei
 * @date 2019-12-24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/save")
    public Object save(@RequestBody @Valid UserDto userDto) {
        return userDto;
    }

    @GetMapping("/login")
    public Object login(@Valid UserDto userDto) {
        return userDto;
    }
}
