package Controller;

import Model.TeacherDetails;
import Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public TeacherDetails addTeacher(@RequestParam String name, @RequestParam String headClass, @RequestParam String headSection, @RequestParam String experience, @RequestParam String age, @RequestParam String gender) {
        return teacherRepository.save(new TeacherDetails(name,headClass,headSection,experience,age,gender));
    }

    @RequestMapping(value = "/addTeacherCsv", method = RequestMethod.POST)
    public String addTeacherDetailsCsv() {
        String csvFile = "C:\\Users\\Rishit\\Desktop\\Book2.csv";
        String line = "";
        String csvSplitBy = ",";
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] TeacherRecord = line.split(csvSplitBy);
                System.out.println("Name " + TeacherRecord[0] + " , class=" + TeacherRecord[1] + " ,section=" + TeacherRecord[2]);
                teacherRepository.save(new TeacherDetails(TeacherRecord[0], TeacherRecord[1], TeacherRecord[2],"","",""));
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "CSV data saved!!";
    }

    @RequestMapping(value = "/getTeacherDetails/{id}", method = RequestMethod.GET)
    public Optional<TeacherDetails> getTeacherDetails(@PathVariable("id") String id)
    {
        return teacherRepository.findById(id);
    }

    @RequestMapping(value = "/getAllTeacherDetails", method = RequestMethod.GET)
    public List<TeacherDetails> getAllTeacherDetails()
    {
        return teacherRepository.findAll();
    }

    @RequestMapping(value = "/modifyTeacher/{id}", method = RequestMethod.PUT)
    public String modifyTeacherById(@PathVariable("id") String id, @Valid @RequestBody TeacherDetails TeacherDetails) {
        TeacherDetails.setId(id);
        teacherRepository.save(TeacherDetails);
        return "SMS.Teacher record modified";
    }

    @RequestMapping(value = "/deleteTeacher/{id}", method = RequestMethod.DELETE)
    public String deleteTeacherById(@PathVariable("id") String id) {
        teacherRepository.deleteById(id);
        return "SMS.Teacher record deleted";
    }

    @RequestMapping(value = "/deleteAllTeacher", method = RequestMethod.DELETE)
    public String deleteTeacherAll() {
        teacherRepository.deleteAll();
        return "All Teachers records deleted";
    }
}
