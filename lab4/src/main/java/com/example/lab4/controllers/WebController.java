package com.example.lab4.controllers;

import com.example.lab4.services.ProjectService;
import com.example.lab4.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class WebController {


    private final ProjectService projectService;

    private final TaskService taskService;

    @GetMapping(value = "/projects_xml")
    public String getProjects(Model model) throws Exception {
        return projectService.getProjects(model);
    }

    @GetMapping(value = "/tasks_xml")
    public String getTasks(Model model) throws Exception {
        return taskService.getTasks(model);
    }
}

