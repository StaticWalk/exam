package com.iot.repository;

import com.iot.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiongxiaoyu on 2017/9/17.
 */
@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    List<Users> findAll();
    Users findByName(String name);

}
