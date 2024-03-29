package com.argProgramaSpallione.ArgentinaPrograma.Repositories;

import com.argProgramaSpallione.ArgentinaPrograma.Entities.Skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, String>{
  
}
