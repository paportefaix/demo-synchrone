package com.example.demo.synchrone.controller;

import com.example.demo.synchrone.dto.AgentDto;
import com.example.demo.synchrone.dto.AgentMockWebService;
import com.example.demo.synchrone.dto.ClientDto;
import com.example.demo.synchrone.dto.ClientMockWebService;
import com.example.demo.synchrone.dto.ProjectDto;
import com.example.demo.synchrone.entity.ProjectDatabaseMockService;
import com.example.demo.synchrone.entity.ProjectEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProjectController {

    private final ProjectDatabaseMockService database;
    private final ClientMockWebService clientMockWebService;
    private final AgentMockWebService  userMockWebService;

    public ProjectController(ProjectDatabaseMockService database, ClientMockWebService clientMockWebService, AgentMockWebService userMockWebService) {
        this.database             = database;
        this.clientMockWebService = clientMockWebService;
        this.userMockWebService   = userMockWebService;
    }

    @GetMapping(value = "/projects-sync")
    public List<ProjectDto> getProjets() {
        final List<ProjectEntity> projets = database.getAll();
        final List<ClientDto> clients = clientMockWebService.findAllIn(projets.stream().map(ProjectEntity::getClientId).collect(Collectors.toList()));
        final List<AgentDto>  agents  = userMockWebService.findAllIn(projets.stream().map(ProjectEntity::getAgents).flatMap(Collection::stream).collect(Collectors.toList()));

        return projets.stream()
                .map(projectEntity -> createProjectDto(projectEntity, clients, agents))
                .collect(Collectors.toList());


    }

    private ProjectDto createProjectDto(ProjectEntity projectEntity, List<ClientDto> clientDtos, List<AgentDto> agentDtos) {
        final ClientDto clientDto = clientDtos
                .stream()
                .filter(client -> client.getId().equals(projectEntity.getClientId()))
                .findFirst()
                .orElse(new ClientDto());

        final List<AgentDto> agents = agentDtos
                .stream()
                .filter(agentDto -> projectEntity.getAgents().contains(agentDto.getId()))
                .collect(Collectors.toList());

        return new ProjectDto(projectEntity.getId(), projectEntity.getName(), clientDto.getAdresse(), clientDto.getAdresse(), agents);
    }
}
