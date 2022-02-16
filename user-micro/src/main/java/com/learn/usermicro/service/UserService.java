package com.learn.usermicro.service;

import com.learn.usermicro.VO.Department;
import com.learn.usermicro.VO.ResponseTemplateVO;
import com.learn.usermicro.entity.User;
import com.learn.usermicro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User save(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO findById(Long id) {
        ResponseTemplateVO templateVO = new ResponseTemplateVO();
        User user = userRepository.getById(id);

        Department department = restTemplate.getForObject("http://localhost:8080/departments/" + user.getDepartmentId(),
                Department.class);
        templateVO.setUser(user);
        templateVO.setDepartment(department);
        return templateVO;
    }
}