package com.practice.project.service;

import java.io.IOException;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.practice.project.models.Employee;
import com.practice.project.repos.EmployeeRepo;

@Service
public class ImageService {
@Autowired
EmployeeRepo repo;

public String addImage(String title, MultipartFile file,String id) throws IOException {
	Optional<Employee> emp = repo.findById(id);
    Employee employee = emp.get();
	employee.setTitle(title); 
	employee.setImage(
        new Binary(BsonBinarySubType.BINARY, file.getBytes()));
      repo.save(employee);
      return(employee.getTitle());
}

public Employee getImage(String id) {
    return repo.findById(id).get();
}
}
