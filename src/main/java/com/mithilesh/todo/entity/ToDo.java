package com.mithilesh.todo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {

    @Id
    @Column(name = "ID")
    @UuidGenerator
    private String id;

    @Column(name="Title")
    private String title;

    @Column(name="Description")
    private String description;

}
