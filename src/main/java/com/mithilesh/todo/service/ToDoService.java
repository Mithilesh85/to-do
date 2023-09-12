package com.mithilesh.todo.service;

import com.mithilesh.todo.dto.ToDoDto;

import java.util.List;

public interface ToDoService {

    public List<ToDoDto> getTodoList();

    public ToDoDto getTodo(String id);

    public ToDoDto addTodo(ToDoDto toDoDto);

    public ToDoDto updateTodo(ToDoDto toDoDto, String id);

    public  void deleteTodo(String id);

}
