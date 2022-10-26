package com.adamo.todoapp.controller;

import com.adamo.todoapp.model.Task;
import com.adamo.todoapp.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository repository;


    TaskController(final TaskRepository repository) {
        this.repository = repository;
    }

    /*
    List<Task> readAllTasks2()  {
        logger.warn("Exposing all the tasks!");
        return repository.findAll();
    }
     */

    //@GetMapping(value = "/tasks")
    //@RequestMapping(method = RequestMethod.GET, path = "/tasks")
    //by skorzystać z poniższego customowego mapingu na taski nie mogą być dopisane te parametry "params = {"!sort", "!page", "!size"}"
    @GetMapping(value = "/tasks", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Task>> readAllTasks() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/tasks")
    ResponseEntity<List<Task>> readAllTasks(Pageable page) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

}
