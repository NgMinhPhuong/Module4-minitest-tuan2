package com.codegym.minitest_tuan2.service;

import com.codegym.minitest_tuan2.model.Category;
import com.codegym.minitest_tuan2.model.Task;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    List<Category> findById(Long id);

}
