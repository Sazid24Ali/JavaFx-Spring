package org.test.db_check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImppl implements StudentService{

    @Autowired
    StudentRepo studentRepo;


    @Override
    public String AddData(Student dataStudent) {
        studentRepo.save(dataStudent);
        return "Data Added Sucessfully";
    }
    
}
