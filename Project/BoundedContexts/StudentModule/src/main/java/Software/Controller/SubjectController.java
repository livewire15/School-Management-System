/**
 * Created by sharad on 1/9/19.
 */

package Software.Controller;

import Software.Model.SubjectDetails;
import Software.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController

public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @RequestMapping(value = "/addSubjectDetails", method = RequestMethod.POST)
    public SubjectDetails addSubjectDetails() {
        ArrayList<String> subjects=new ArrayList<>();
        subjects.add("English");
        subjects.add("Hindi");
        subjects.add("Maths");
        subjects.add("Physics");
        subjects.add("Chemistry");
        subjects.add("Biology");
        subjects.add("Computers");
        subjects.add("Sanskrit");
        return subjectRepository.save(new SubjectDetails("8",subjects));
    }

//    @RequestMapping(value = "/getSubjectDetails/{className}", method = RequestMethod.GET)
//    public ArrayList<String> getSubjectDetails(@PathVariable("className") String className) {
//        return subjectRepository.getSubjectDetails(className).getSubjects();
//    }
}
