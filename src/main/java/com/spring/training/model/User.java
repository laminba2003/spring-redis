package com.spring.training.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "users")
@Data
public class User implements Serializable {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Field(value = "username")
    private String userName;
    private String password;

}
