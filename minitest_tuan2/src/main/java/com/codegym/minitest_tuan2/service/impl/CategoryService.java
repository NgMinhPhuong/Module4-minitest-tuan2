package com.codegym.minitest_tuan2.service.impl;

import com.codegym.minitest_tuan2.model.Category;
import com.codegym.minitest_tuan2.model.Task;
import com.codegym.minitest_tuan2.repo.ICategoryRepo;
import com.codegym.minitest_tuan2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepo iCategoryRepo;
    @Override
    public List<Category> findAll() {
        return iCategoryRepo.findAll();
    }

    @Override
    public List<Category> findById(Long id) {
        List<Category> list = new ArrayList<>();
        if(iCategoryRepo.findById(id).isPresent()) {
            list.add(iCategoryRepo.findById(id).get());
        }
        return list;
    }


}
