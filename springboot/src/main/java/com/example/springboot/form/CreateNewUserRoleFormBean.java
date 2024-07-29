package com.example.springboot.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateNewUserRoleFormBean {

    private Integer id;

    private String createDate;

    @NotEmpty(message = "Role Name is required.")
    private String roleName;

    private Integer userId;
}
