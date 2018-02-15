package com.example.demo.repository;

import com.example.demo.model.Education;
import org.springframework.data.repository.CrudRepository;

public interface EducationRepo extends CrudRepository<Education,Long> {
}
