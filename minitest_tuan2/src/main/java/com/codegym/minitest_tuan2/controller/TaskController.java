package com.codegym.minitest_tuan2.controller;

import com.codegym.minitest_tuan2.DTO.CountDTO;
import com.codegym.minitest_tuan2.model.Category;
import com.codegym.minitest_tuan2.model.Task;
import com.codegym.minitest_tuan2.service.ICategoryService;
import com.codegym.minitest_tuan2.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private ITaskService iTaskService;
    @Autowired
    private ICategoryService iCategoryService;

    //Em đã cài tomcat run app sẽ vào url showtask  này trước
    @GetMapping("showtask")
    public String showTask(Model model){
        model.addAttribute("tasks", iTaskService.findAll());
        Iterable<CountDTO> count = iTaskService.count();
        model.addAttribute("count", count);
        return "/showTask";
    }

    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("task", new Task());
        model.addAttribute("categories", iCategoryService.findAll());
        return "/createTask";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("task") Task task, @RequestParam(value = "categoryId", required = false) Long categoryId){
        Category category = iCategoryService.findById(categoryId).get(0);
        task.setCategory(category);
        iTaskService.save(task);
        return "redirect:/showtask";
    }

    @GetMapping("delete/{id}")
    public String delete(Model model, @PathVariable Long id){
        iTaskService.delete(id);
        return "redirect:/showtask";
    }


    //bài làm web service trong giờ học
//    @GetMapping("getTask")
//    @ResponseBody
//    public ResponseEntity<List<Task>> get(){
//        return new ResponseEntity<>(iTaskService.findAll(), HttpStatus.OK);
//    }

}
