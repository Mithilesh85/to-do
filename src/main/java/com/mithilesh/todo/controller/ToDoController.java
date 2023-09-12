package com.mithilesh.todo.controller;

import com.mithilesh.todo.dto.ApiResponse;
import com.mithilesh.todo.dto.ToDoDto;
import com.mithilesh.todo.service.ToDoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todo")
@Tag(name = "ToDo Controller",description = "This is ToDo Controller")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/")
    @Operation(summary = "Get ToDo List")
    public ResponseEntity<List<ToDoDto>> getToDoList(){
        return ResponseEntity.ok(this.toDoService.getTodoList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get ToDo by id")
    public ResponseEntity<ToDoDto> getToDo(@PathVariable("id") String id){
        return ResponseEntity.ok(this.toDoService.getTodo(id));
    }

    @PostMapping("/")
    @Operation(summary = "Add ToDo")
    public ResponseEntity<ToDoDto> addToDo( @Valid @RequestBody ToDoDto toDoDto){
        return new ResponseEntity<>(this.toDoService.addTodo(toDoDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update ToDo")
    public ResponseEntity<ToDoDto> updateToDo(@Valid @RequestBody ToDoDto toDoDto, @PathVariable("id") String id){
        return new ResponseEntity<>(this.toDoService.updateTodo(toDoDto,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete ToDo List")
    public ResponseEntity<ApiResponse> deleteTodo(@PathVariable("id") String id){
       return new ResponseEntity<>(new ApiResponse("ToDo deleted successfully",true),HttpStatus.OK);
    }

}
