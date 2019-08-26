package Rishit;

import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {

    //private StudentService studentService;
    @Autowired
    private StudentRepository studentrepo;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public StudentDetails addStudent(@RequestParam String name,@RequestParam String className,@RequestParam String section) {
        return studentrepo.save(new StudentDetails(name, className, section));
         /*StudentDetails obj=studentService.create(name,className,section);
        return obj;*/
    }
}
