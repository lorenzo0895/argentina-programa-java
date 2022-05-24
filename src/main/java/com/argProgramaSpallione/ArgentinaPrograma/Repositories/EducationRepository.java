package com.argProgramaSpallione.ArgentinaPrograma.Repositories;

import com.argProgramaSpallione.ArgentinaPrograma.Entities.Education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, String>{
  
}
