package com.example.springboot.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserRoleFormBean {

    private Integer id;

    private Integer userId;

    @NotEmpty(message = "Role Name is required.")
    private String roleName;

    private String createDate;
}
