package com.codegym.minitest_tuan2.service;

import com.codegym.minitest_tuan2.DTO.CountDTO;
import com.codegym.minitest_tuan2.model.Task;

import java.util.List;

public interface ITaskService {
    List<Task> findAll();
    void save(Task task);
    void delete(Long id);

    Iterable<CountDTO> count();
}
