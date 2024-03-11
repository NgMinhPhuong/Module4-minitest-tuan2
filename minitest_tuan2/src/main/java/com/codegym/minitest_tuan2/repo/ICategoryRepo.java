package com.codegym.minitest_tuan2.repo;

import com.codegym.minitest_tuan2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepo extends JpaRepository<Category, Long> {
    List<Category> findAll();
}
