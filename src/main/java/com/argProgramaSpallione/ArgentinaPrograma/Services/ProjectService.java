package com.argProgramaSpallione.ArgentinaPrograma.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.argProgramaSpallione.ArgentinaPrograma.Entities.Project;
import com.argProgramaSpallione.ArgentinaPrograma.Repositories.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  public List<Project> getAll() throws Exception {
    try {
      return projectRepository.findAll();
    } catch (Exception exception) {
      throw exception;
    }
  }

  public Project getOne(String id) throws Exception {
    try {
      Optional<Project> optional = projectRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("Project not found");
      }
      return optional.get();
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public Project create(String name, String description, String uri) throws Exception {
    try {
      if (name == null || name.equals("")) {
        throw new Exception("Name cannot be null");
      }
      if (description == null || description.equals("")) {
        throw new Exception("Description cannot be null");
      }
      Project project = new Project();
      project.setName(name);
      project.setDescription(description);
      project.setUri(uri);
      projectRepository.save(project);
      return project;
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public Project edit(String id, String name, String description, String uri) throws Exception {
    try {
      Optional<Project> optional = projectRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("Project not found");
      }
      Project project = optional.get();
      if (name != null && !name.equals("")) {
        project.setName(name);
      }
      if (description != null && !description.equals("")) {
        project.setDescription(description);
      }
      if (uri != null && !uri.equals("")) {
        project.setUri(uri);
      }
      projectRepository.save(project);
      return project;
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public void delete(String id) throws Exception {
    try {
      Optional<Project> optional = projectRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("Project not found");
      }
      projectRepository.deleteById(id);
    } catch (Exception exception) {
      throw exception;
    }
  }

}
