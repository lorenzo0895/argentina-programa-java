package com.argProgramaSpallione.ArgentinaPrograma.Controllers;

import java.util.List;

import com.argProgramaSpallione.ArgentinaPrograma.Entities.Skill;
import com.argProgramaSpallione.ArgentinaPrograma.Responses.IException;
import com.argProgramaSpallione.ArgentinaPrograma.Responses.IResponse;
import com.argProgramaSpallione.ArgentinaPrograma.Services.SkillService;
import com.argProgramaSpallione.ArgentinaPrograma.Services.SkillService;

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
@RequestMapping(path = "/skills")
@CrossOrigin(origins = "*")
public class SkillController {

  @Autowired
  private SkillService skilService;

  @GetMapping("")
  @ResponseBody
  public IResponse getSkills() {
    try {
      List<Skill> skillList = skilService.getAll();
      return new IResponse<List<Skill>>(skillList);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @GetMapping("/{id}")
  @ResponseBody
  public IResponse getSkillById(@PathVariable String id) {
    try {
      Skill skill = skilService.getOne(id);
      return new IResponse<Skill>(skill);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @PostMapping("")
  @ResponseBody
  public IResponse postSkill(@RequestBody Skill skill) {
    try {
      Skill newSkill = skilService.create(skill.getName(), skill.getDescription(), skill.getStatus());
      return new IResponse<Skill>(newSkill);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @PatchMapping("/{id}")
  @ResponseBody
  public IResponse patchSkill(@PathVariable String id, @RequestBody Skill skill) {
    try {
      Skill skillEdited = skilService.edit(id, skill.getName(), skill.getDescription(), skill.getStatus());
      return new IResponse<Skill>(skillEdited);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  public IResponse deleteSkill(@PathVariable String id) {
    try {
      skilService.delete(id);
      return new IResponse<String>("Skill deleted");
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

}
