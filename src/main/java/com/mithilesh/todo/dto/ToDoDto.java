package com.mithilesh.todo.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDto {


    private String id;

    @NotEmpty
    @Size(min = 5,message = "Title must be minimum length of 5")
    private String title;

    @Size(min = 10,message = "Description must be minimum length of 10")
    private String description;

}
