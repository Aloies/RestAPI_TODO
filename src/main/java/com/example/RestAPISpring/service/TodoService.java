package com.example.RestAPISpring.service;

import com.example.RestAPISpring.entity.TodoEntity;
import com.example.RestAPISpring.entity.UserEntity;
import com.example.RestAPISpring.model.Todo;
import com.example.RestAPISpring.perository.TodoRepository;
import com.example.RestAPISpring.perository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepository.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepository.save(todo));
    }

    //    Метод возвращает todoEntity
    /**public TodoEntity completedTodo(Long userId){
        TodoEntity todo = todoRepository.findById(userId).get();
        todo.setCompleted(!todo.getCompleted());
        return todoRepository.save(todo);
    }*/
//    метод возвращает модель todoEntity
    public Todo completedTodo(Long userId) {
        TodoEntity todo = todoRepository.findById(userId).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepository.save(todo));
    }
}
