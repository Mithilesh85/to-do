package com.mithilesh.todo.service.impl;

import com.mithilesh.todo.dto.ToDoDto;
import com.mithilesh.todo.entity.ToDo;
import com.mithilesh.todo.exception.ResourceNotFoundException;
import com.mithilesh.todo.repository.ToDoRepository;
import com.mithilesh.todo.service.ToDoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ToDoDto> getTodoList() {
        List<ToDo> toDoList = this.toDoRepository.findAll();
        return toDoList.stream().map((toDo) -> this.modelMapper.map(toDo, ToDoDto.class)).toList();
    }

    @Override
    public ToDoDto getTodo(String id) {
        ToDo toDo = this.toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo", "Id", id));
        return this.modelMapper.map(toDo,ToDoDto.class);
    }

    @Override
    public ToDoDto addTodo(ToDoDto toDoDto) {
        ToDo todo = this.modelMapper.map(toDoDto, ToDo.class);
        ToDo savedToDo = this.toDoRepository.save(todo);
        return this.modelMapper.map(savedToDo,ToDoDto.class);
    }

    @Override
    public ToDoDto updateTodo(ToDoDto toDoDto, String id) {
        ToDo toDo = this.toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo", "Id", id));
        toDo.setTitle(toDoDto.getTitle());
        toDo.setDescription((toDoDto.getDescription()));
        ToDo updatedToDo = this.toDoRepository.save(toDo);
        return this.modelMapper.map(updatedToDo,ToDoDto.class);
    }

    @Override
    public void deleteTodo(String id) {
        ToDo toDo = this.toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo", "Id", id));
        this.toDoRepository.delete(toDo);
    }
}
