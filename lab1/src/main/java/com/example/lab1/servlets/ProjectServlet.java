package com.example.lab1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.lab1.services.ProjectService;
import com.example.lab1.models.dto.ProjectRequest;
import com.example.lab1.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "projectServlet", value = "/projects")
public class ProjectServlet extends HttpServlet {
    private ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private ProjectService projectService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json");

        try(PrintWriter out = response.getWriter()){
            out.print(objectMapper.writeValueAsString(projectService.getAll()));
        }
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (InputStream is = request.getInputStream()) {
            ProjectRequest projectRequest = objectMapper.readValue(is, ProjectRequest.class);
            projectService.create(projectRequest);
        }
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID projectId = UUID.fromString(request.getPathInfo().substring(1));
        projectService.delete(projectId);
    }
}
