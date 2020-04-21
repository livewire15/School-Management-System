/**
 * Created by sharad on 1/9/19.
 */

package Software.Service;

import Software.Model.StudentDetails;
import Software.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    @Autowired
    MongoTemplate mongoTemplate;


    public StudentDetails saveStudent(StudentDetails studentDetails) {
        StudentDetails obj= studentRepo.save(studentDetails);
    /*    if(obj!=null)
        {
            obj.setSuccess(true);
        }
        else
        {
            obj.setSuccess(false);
        }*/
        return obj;
    }

    public String addStudentCSV() {

        String csvFile = "C:\\Users\\Rishit\\Desktop\\Book1.csv";
        String line = "";
        String csvSplitBy = ",";
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] studentRecord = line.split(csvSplitBy);
                System.out.println("Name " + studentRecord[0] + " , class=" + studentRecord[1] + " ,section=" + studentRecord[2]);
                studentRepo.save(new StudentDetails(studentRecord[0], studentRecord[1], studentRecord[2], "", "", "", "", "", "", "", ""));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

    public StudentDetails FindStudent(String id) {

        Query query = new Query();
        query.addCriteria(Criteria.where("rollNo").is(id));

        StudentDetails studentDetails = mongoTemplate.findOne(query, StudentDetails.class);
        /*if(studentDetails!=null)
        {
            studentDetails.setSuccess(true);
        }
        else
        {
            studentDetails.setSuccess(false);
        }*/
        return studentDetails;
    }

    public List<StudentDetails>findStudentsByClassSection(String className, String section) {

        Query query = new Query();
        query.addCriteria(
                new Criteria().andOperator(
                        Criteria.where("className").is(className),
                        Criteria.where("section").is(section)
                ));

        ArrayList<StudentDetails> studentList= (ArrayList<StudentDetails>)mongoTemplate.find(query,StudentDetails.class);
        if(studentList!=null)
        {

        }
        return studentList;
    }

    public List<StudentDetails> findAllStudents() {

        ArrayList<StudentDetails> list= (ArrayList<StudentDetails>)studentRepo.findAll();
        return list;
    }

    public StudentDetails findAndRemove(String rollNo)
    {
        Query query=new Query();
        query.addCriteria(Criteria.where("rollNo").is(rollNo));
        return mongoTemplate.findAndRemove(query,StudentDetails.class);
    }
}

//