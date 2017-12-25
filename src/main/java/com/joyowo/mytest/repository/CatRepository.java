package com.joyowo.mytest.repository;//


import com.joyowo.mytest.pojo.Cat;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ireliac on 2017/11/5.
 */
public interface CatRepository extends JpaRepository<Cat, Integer> {
}
