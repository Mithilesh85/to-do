package com.mithilesh.todo.repository;

import com.mithilesh.todo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo,String> {

}
