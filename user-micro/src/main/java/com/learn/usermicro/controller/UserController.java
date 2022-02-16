package com.learn.usermicro.controller;

import com.learn.usermicro.VO.ResponseTemplateVO;
import com.learn.usermicro.entity.User;
import com.learn.usermicro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> saveDepartment(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.save(user));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplateVO> getByIdWithDepartment(@PathVariable("id") Long id) {
        ResponseTemplateVO templateVO = new ResponseTemplateVO();
        templateVO = userService.findById(id);
        return ResponseEntity.ok().body(templateVO);
    }

}
