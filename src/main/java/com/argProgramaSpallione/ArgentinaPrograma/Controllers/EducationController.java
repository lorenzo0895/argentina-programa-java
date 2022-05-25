package com.argProgramaSpallione.ArgentinaPrograma.Controllers;

import java.util.List;

import com.argProgramaSpallione.ArgentinaPrograma.Entities.Education;
import com.argProgramaSpallione.ArgentinaPrograma.Responses.IException;
import com.argProgramaSpallione.ArgentinaPrograma.Responses.IResponse;
import com.argProgramaSpallione.ArgentinaPrograma.Services.EducationService;

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
@RequestMapping(path = "/educations")
@CrossOrigin(origins = "*")
public class EducationController {

  @Autowired
  private EducationService educationService;

  @GetMapping("")
  @ResponseBody
  public IResponse getEducations() {
    try {
      List<Education> educationList = educationService.getAll();
      return new IResponse<List<Education>>(educationList);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @GetMapping("/{id}")
  @ResponseBody
  public IResponse getEducationById(@PathVariable String id) {
    try {
      Education eduction = educationService.getOne(id);
      return new IResponse<Education>(eduction);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @PostMapping("")
  @ResponseBody
  public IResponse postEducation(@RequestBody Education education) {
    try {
      Education newEducation = educationService.create(education.getTitle(), education.getStart(),
          education.getEnd());
      return new IResponse<Education>(newEducation);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @PatchMapping("/{id}")
  @ResponseBody
  public IResponse patchEducation(@PathVariable String id, @RequestBody Education education) {
    try {
      Education educationEdited = educationService.edit(id, education.getTitle(), education.getStart(),
          education.getEnd());
      return new IResponse<Education>(educationEdited);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  public IResponse deleteEducation(@PathVariable String id) {
    try {
      educationService.delete(id);
      return new IResponse<String>("Education deleted");
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

}
