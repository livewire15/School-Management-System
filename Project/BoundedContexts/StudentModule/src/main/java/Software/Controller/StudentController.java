/**
 * Created by sharad on 1/9/19.
 */

package Software.Controller;

import Software.Model.StudentDetails;
import Software.Payload.StudentModulePayload;
import Software.Service.StudentService;
import Software.Utilities.SMLogger;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.apache.catalina.security.SecurityUtil.remove;

@RestController
@RequestMapping(value="/StudentModule")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentModulePayload> addStudent(@RequestBody StudentDetails studentDetails) {
        StudentModulePayload studentModulePayload = null;
        ResponseEntity<StudentModulePayload> responseEntity = null;

        SMLogger.getLogger().debug(messageSource.getMessage("ENTER_SAVE_STUDENT", null, null));

        StudentDetails obj = studentService.saveStudent(studentDetails);
        if (!obj.equals(null)) {
            studentModulePayload = new StudentModulePayload(StudentModulePayload.RESPONSE_STATUS.SUCCESS,
                    "StudentDetails saved");
            studentModulePayload.addResponseDetails(obj);
            responseEntity = new ResponseEntity<StudentModulePayload>(studentModulePayload, HttpStatus.CREATED);
        } else {
            studentModulePayload = new StudentModulePayload(StudentModulePayload.RESPONSE_STATUS.FAILURE,
                    "StudentDetails not saved");
            studentModulePayload.addResponseDetails(obj);
            responseEntity = new ResponseEntity<StudentModulePayload>(studentModulePayload, HttpStatus.EXPECTATION_FAILED);
        }

        SMLogger.getLogger().debug(messageSource.getMessage("EXIT_SAVE_STUDENT", null, null));
        return responseEntity;

    }


    @RequestMapping(value = "/getStudentDetails/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentModulePayload> getStudentDetails(@PathVariable("id") String id) {

        StudentModulePayload studentModulePayload = null;
        ResponseEntity<StudentModulePayload> responseEntity = null;

        SMLogger.getLogger().debug(messageSource.getMessage("ENTER_GET_STUDENT", null, null));

        StudentDetails obj = studentService.FindStudent(id);
        if (!obj.equals(null)) {
            studentModulePayload = new StudentModulePayload(StudentModulePayload.RESPONSE_STATUS.SUCCESS,
                    "Successfully fetched student details");
            studentModulePayload.addResponseDetails(obj);
            responseEntity = new ResponseEntity<StudentModulePayload>(studentModulePayload, HttpStatus.FOUND);
        } else {
            studentModulePayload = new StudentModulePayload(StudentModulePayload.RESPONSE_STATUS.FAILURE,
                    "Student not present");
            studentModulePayload.addResponseDetails(obj);
            responseEntity = new ResponseEntity<StudentModulePayload>(studentModulePayload, HttpStatus.NOT_FOUND);
        }

        SMLogger.getLogger().debug(messageSource.getMessage("EXIT_GET_STUDENT", null, null));
        return responseEntity;
    }


    //
    @RequestMapping(value = "/getStudentDetails/{className}/{section}", method = RequestMethod.GET)
    public ResponseEntity<StudentModulePayload> getStudentDetails(@PathVariable("className") String className, @PathVariable("section") String section) {

        StudentModulePayload studentModulePayload = null;
        ResponseEntity<StudentModulePayload> responseEntity = null;

        SMLogger.getLogger().debug(messageSource.getMessage("ENTER_GET_STUDENTS_BY_CLASS_&_SECTION", null, null));

        ArrayList<StudentDetails> list = (ArrayList<StudentDetails>) studentService.findStudentsByClassSection(className, section);
        if (!list.isEmpty()) {
            studentModulePayload = new StudentModulePayload(StudentModulePayload.RESPONSE_STATUS.SUCCESS,
                    "Successfully fetched students by classname and section");
            studentModulePayload.addResponseDetails(list);
            responseEntity = new ResponseEntity<StudentModulePayload>(studentModulePayload, HttpStatus.FOUND);
        } else {
            studentModulePayload = new StudentModulePayload(StudentModulePayload.RESPONSE_STATUS.FAILURE,
                    "Students not found for classname and section");
            studentModulePayload.addResponseDetails(list);
            responseEntity = new ResponseEntity<StudentModulePayload>(studentModulePayload, HttpStatus.NOT_FOUND);
        }

        SMLogger.getLogger().debug(messageSource.getMessage("EXIT_GET_STUDENTS_BY_CLASS_&_SECTION", null, null));
        return responseEntity;
    }

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public ResponseEntity<StudentModulePayload> getAllStudentDetails() {
        StudentModulePayload studentModulePayload = null;
        ResponseEntity<StudentModulePayload> responseEntity = null;

        SMLogger.getLogger().debug(messageSource.getMessage("ENTER_GET_ALL_STUDENTS", null, null));

        ArrayList<StudentDetails> list = (ArrayList<StudentDetails>) studentService.findAllStudents();

        if (!list.isEmpty()) {
            studentModulePayload = new StudentModulePayload(StudentModulePayload.RESPONSE_STATUS.SUCCESS,
                    "Successfully fetched all students");
            studentModulePayload.addResponseDetails(list);
            responseEntity = new ResponseEntity<StudentModulePayload>(studentModulePayload, HttpStatus.FOUND);
        } else {
            studentModulePayload = new StudentModulePayload(StudentModulePayload.RESPONSE_STATUS.FAILURE,
                    "Not able to fetch Students");
            studentModulePayload.addResponseDetails(list);
            responseEntity = new ResponseEntity<StudentModulePayload>(studentModulePayload, HttpStatus.NOT_FOUND);
        }

        SMLogger.getLogger().debug(messageSource.getMessage("EXIT_GET_ALL_STUDENTS", null, null));
        return responseEntity;
    }

    @RequestMapping(value = "/addStudentCsv", method = RequestMethod.POST)
    public ResponseEntity<String> addStudentDetailsCsv() {

        String result=studentService.addStudentCSV();
        return new ResponseEntity<String>(result,HttpStatus.OK);

    }

    @RequestMapping(value = "/modifyStudent/{rollNo}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<StudentModulePayload> modifyStudentById(@PathVariable("rollNo") String rollNo,@RequestBody StudentDetails studentDetails)
    {
        StudentModulePayload studentModulePayload = null;
        ResponseEntity<StudentModulePayload> responseEntity = null;
        SMLogger.getLogger().debug(messageSource.getMessage("ENTER_SAVE_STUDENT", null, null));

        StudentDetails obj = studentService.FindStudent(rollNo);
        String objectId=obj.getId();
        studentDetails.setId(objectId);
        StudentDetails studentDetails1=studentService.saveStudent(studentDetails);
        if (!studentDetails1.equals(null)) {
            studentModulePayload = new StudentModulePayload(StudentModulePayload.RESPONSE_STATUS.SUCCESS,
                    "StudentDetails updated");
            studentModulePayload.addResponseDetails(studentDetails1);
            responseEntity = new ResponseEntity<StudentModulePayload>(studentModulePayload, HttpStatus.CREATED);
        } else {
            studentModulePayload = new StudentModulePayload(StudentModulePayload.RESPONSE_STATUS.FAILURE,
                    "StudentDetails not updated");
            studentModulePayload.addResponseDetails(studentDetails1);
            responseEntity = new ResponseEntity<StudentModulePayload>(studentModulePayload, HttpStatus.EXPECTATION_FAILED);
        }

        SMLogger.getLogger().debug(messageSource.getMessage("EXIT_SAVE_STUDENT", null, null));
        return responseEntity;
    }
//
   @RequestMapping(value = "/deleteStudent/{rollNo}", method = RequestMethod.DELETE,
           produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentModulePayload> deleteStudentById(@PathVariable("rollNo") String rollNo) {
        StudentDetails studentDetails=studentService.findAndRemove(rollNo);
       StudentModulePayload studentModulePayload = null;
       ResponseEntity<StudentModulePayload> responseEntity = null;
       if (!studentDetails.equals(null)) {
           studentModulePayload = new StudentModulePayload(StudentModulePayload.RESPONSE_STATUS.SUCCESS,
                   "StudentDetails deleted");
           studentModulePayload.addResponseDetails(studentDetails);
           responseEntity = new ResponseEntity<StudentModulePayload>(studentModulePayload, HttpStatus.CREATED);
       } else {
           studentModulePayload = new StudentModulePayload(StudentModulePayload.RESPONSE_STATUS.FAILURE,
                   "StudentDetails not deleted");
           studentModulePayload.addResponseDetails(studentDetails);
           responseEntity = new ResponseEntity<StudentModulePayload>(studentModulePayload, HttpStatus.EXPECTATION_FAILED);
       }

       SMLogger.getLogger().debug(messageSource.getMessage("EXIT_SAVE_STUDENT", null, null));
       return responseEntity;
    }
//
//    @RequestMapping(value = "/deleteAllStudent", method = RequestMethod.DELETE)
//    public String deleteStudentAll() {
//        studentrepo.deleteAll();
//        return "All Students records deleted";
//    }

    }
