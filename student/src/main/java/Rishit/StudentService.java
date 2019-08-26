package Rishit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentrepo;

    public StudentDetails create(String name, String className, String section)
    {
        return studentrepo.save(new StudentDetails(name, className, section));
    }
}
