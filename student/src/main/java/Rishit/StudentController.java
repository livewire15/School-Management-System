package Rishit;

import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public StudentDetails addStudent(@RequestParam String name,@RequestParam String className,@RequestParam String section) {
        StudentDetails obj=studentService.create(name,className,section);
        return obj;
    }

}
