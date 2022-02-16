package com.learn.usermicro.repository;

import com.learn.usermicro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByDepartmentId(Long id);
}
