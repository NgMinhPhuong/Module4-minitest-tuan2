package com.codegym.minitest_tuan2.repo;

import com.codegym.minitest_tuan2.DTO.CountDTO;
import com.codegym.minitest_tuan2.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public interface ITaskRepo extends JpaRepository<Task, Long> {
    List<Task> findAll();
    @Query(nativeQuery = true,value = "select c.`name`, sum(t.amount) sum from task t " +
            "right join category c on c.id = t.category_id " +
            "group by c.`name`;")
    Iterable<CountDTO> countByName();
}
