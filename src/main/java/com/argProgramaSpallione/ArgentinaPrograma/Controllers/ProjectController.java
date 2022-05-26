package com.argProgramaSpallione.ArgentinaPrograma.Controllers;

import java.util.List;

import com.argProgramaSpallione.ArgentinaPrograma.Entities.Project;
import com.argProgramaSpallione.ArgentinaPrograma.Responses.IException;
import com.argProgramaSpallione.ArgentinaPrograma.Responses.IResponse;
import com.argProgramaSpallione.ArgentinaPrograma.Services.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @GetMapping("")
  @ResponseBody
  public IResponse getProjects() {
    try {
      List<Project> projectList = projectService.getAll();
      return new IResponse<List<Project>>(projectList);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @GetMapping("/{id}")
  @ResponseBody
  public IResponse getProjectById(@PathVariable String id) {
    try {
      Project project = projectService.getOne(id);
      return new IResponse<Project>(project);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @PostMapping("")
  @ResponseBody
  public IResponse postProject(@RequestBody Project project) {
    try {
      Project newProject = projectService.create(project.getName(), project.getDescription(), project.getUri());
      return new IResponse<Project>(newProject);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @PatchMapping("/{id}")
  @ResponseBody
  public IResponse patchProject(@PathVariable String id, @RequestBody Project project) {
    try {
      Project projectEdited = projectService.edit(id, project.getName(), project.getDescription(), project.getUri());
      return new IResponse<Project>(projectEdited);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  public IResponse deleteProject(@PathVariable String id) {
    try {
      projectService.delete(id);
      return new IResponse<String>("Project deleted");
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

}
