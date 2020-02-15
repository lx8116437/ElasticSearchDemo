package com.es.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class EmployeeVo {
    private Long id;
    private String name;
    private Integer age;
    private String about;
}
