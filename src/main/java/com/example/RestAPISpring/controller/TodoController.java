package com.example.RestAPISpring.controller;

import com.example.RestAPISpring.entity.TodoEntity;
import com.example.RestAPISpring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId){
        try{
            return ResponseEntity.ok(todoService.createTodo(todo,userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }

    }

    @PutMapping
    public ResponseEntity complitedTodo(@RequestParam Long id){
        try{
            return ResponseEntity.ok(todoService.completedTodo(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
