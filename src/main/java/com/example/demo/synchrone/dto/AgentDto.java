package com.example.demo.synchrone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class AgentDto {

    private Integer id;
    private String name;
    private String surname;

}
