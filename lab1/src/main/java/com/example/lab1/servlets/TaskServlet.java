package com.example.lab1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.lab1.services.TaskService;
import com.example.lab1.models.dto.TaskRequest;
import com.example.lab1.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "taskServlet", value = "/tasks")
public class TaskServlet extends HttpServlet {
    private  ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private TaskService taskService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(taskService.getAll()));
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (InputStream is = request.getInputStream()) {
            TaskRequest taskRequest = objectMapper.readValue(is, TaskRequest.class);
            taskService.create(taskRequest);
        }
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID taskId = UUID.fromString(request.getPathInfo().substring(1));
        taskService.delete(taskId);
    }
}
