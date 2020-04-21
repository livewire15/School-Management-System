/**
 * Created by sharad on 3/9/19.
 */

package Software.Utilities;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


//commented will be used in future
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
//        "studentName",
//        "studentClass",
//        "studentSection",
        "msg"
})

public class StudentModuleCrudStatus extends AbstractCrudStatus {


//    @JsonProperty("studentName")
//    private String studentName;
//
//    @JsonProperty("studentClass")
//    private String studentClass;
//
//    @JsonProperty("studentSection")
//    private String studentSection;

    @JsonProperty("msg")
    private String messsage;

//    public String getStudentName() {
//        return studentName;
//    }
//
//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
//    }
//
//    public String getStudentClass() {
//        return studentClass;
//    }
//
//    public void setStudentClass(String studentClass) {
//        this.studentClass = studentClass;
//    }
//
//    public String getStudentSection() {
//        return studentSection;
//    }
//
//    public void setStudentSection(String studentSection) {
//        this.studentSection = studentSection;
//    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }



}
