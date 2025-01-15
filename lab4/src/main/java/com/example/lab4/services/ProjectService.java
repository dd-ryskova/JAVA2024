package com.example.lab4.services;

import com.example.lab4.models.AuditEvent;
import com.example.lab4.models.ProjectEntity;
import com.example.lab4.models.dto.ProjectRequest;
import com.example.lab4.repositories.ProjectRepository;
import com.example.lab4.utils.EventLogger;
import com.example.lab4.utils.ObjectToDomTransformer;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;
import java.util.UUID;
import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ObjectMapper objectMapper;
    private final ProjectRepository projectRepository;

    private final EventLogger eventLogger;


    @SneakyThrows
    public ResponseEntity<String> getAllProjects() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(projectRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> createProject(ProjectRequest projectRequest) {
        ProjectEntity project = new ProjectEntity(
                randomUUID(),
                projectRequest.getName(),
                projectRequest.getDescription(),
                projectRequest.getStartDate(),
                projectRequest.getEndDate()
        );
        eventLogger.log(project, AuditEvent.CREATE);
        projectRepository.save(project);
        return new ResponseEntity<>("Project created successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteProject(UUID projectId) {
        ProjectEntity projectEntity = new ProjectEntity(projectId, projectRepository.getReferenceById(projectId).getName(),
                projectRepository.getReferenceById(projectId).getDescription(),
                projectRepository.getReferenceById(projectId).getStartDate(),
                projectRepository.getReferenceById(projectId).getEndDate());

        eventLogger.log(projectEntity, AuditEvent.DELETE);
        projectRepository.deleteById(projectId);
        return new ResponseEntity<>("Project deleted successfully", HttpStatus.OK);
    }

    public String getProjects(Model model) throws Exception {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("projects");
        ObjectToDomTransformer transformer = new ObjectToDomTransformer(document);

        List<ProjectEntity> projects = projectRepository.findAll();
        for (ProjectEntity project : projects) {

            transformer.transform(element, project, "project");
        }

        model.addAttribute("projects", element);
        return "projects";
    }
}
