package com.codegym.minitest_tuan2.service.impl;

import com.codegym.minitest_tuan2.DTO.CountDTO;
import com.codegym.minitest_tuan2.model.Task;
import com.codegym.minitest_tuan2.repo.ITaskRepo;
import com.codegym.minitest_tuan2.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private ITaskRepo iTaskRepo;

    @Override
    public List<Task> findAll() {
        return iTaskRepo.findAll();
    }
    @Override
    public void save(Task task) {
        iTaskRepo.save(task);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        List<Task> tasks = iTaskRepo.findAll();
        for(Task task : tasks){
            if(id == task.getId()) {
                iTaskRepo.delete(task);
            }
        }
    }

    @Override
    public Iterable<CountDTO> count() {
        return iTaskRepo.countByName();
    }

}
