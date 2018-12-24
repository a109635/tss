package com.baizhi.dao;

import com.baizhi.entity.Poetry;

import java.util.List;

public interface PoetryDao {
    List<Poetry> findAll();
}
