package com.argProgramaSpallione.ArgentinaPrograma.Controllers;

import java.util.List;

import com.argProgramaSpallione.ArgentinaPrograma.Entities.Experience;
import com.argProgramaSpallione.ArgentinaPrograma.Responses.IException;
import com.argProgramaSpallione.ArgentinaPrograma.Responses.IResponse;
import com.argProgramaSpallione.ArgentinaPrograma.Services.ExperienceService;

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
@RequestMapping(path = "/experiences")
@CrossOrigin(origins = "*")
public class ExperienceController {

  @Autowired
  private ExperienceService experienceService;

  @GetMapping("")
  @ResponseBody
  public IResponse getExperiences() {
    try {
      List<Experience> ExperienceList = experienceService.getAll();
      return new IResponse<List<Experience>>(ExperienceList);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @GetMapping("/{id}")
  @ResponseBody
  public IResponse getExperienceById(@PathVariable String id) {
    try {
      Experience eduction = experienceService.getOne(id);
      return new IResponse<Experience>(eduction);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @PostMapping("")
  @ResponseBody
  public IResponse postExperience(@RequestBody Experience experience) {
    try {
      Experience newExperience = experienceService.create(experience.getRole(), experience.getCompany(),
          experience.getDescription(), experience.getStart(),
          experience.getEnd());
      return new IResponse<Experience>(newExperience);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @PatchMapping("/{id}")
  @ResponseBody
  public IResponse patchExperience(@PathVariable String id, @RequestBody Experience experience) {
    try {
      Experience experienceEdited = experienceService.edit(id, experience.getRole(), experience.getCompany(),
          experience.getDescription(), experience.getStart(), experience.getEnd());
      return new IResponse<Experience>(experienceEdited);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  public IResponse deleteExperience(@PathVariable String id) {
    try {
      experienceService.delete(id);
      return new IResponse<String>("Experience deleted");
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

}
