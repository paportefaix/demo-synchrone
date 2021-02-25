package com.example.demo.synchrone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ProjectDto {

    private Integer        id;
    private String         name;
    private String         clientName;
    private String         clientAdresse;
    private List<AgentDto> agents;

}
