package com.example.RestAPISpring.perository;

import com.example.RestAPISpring.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoEntity,Long> {
}
