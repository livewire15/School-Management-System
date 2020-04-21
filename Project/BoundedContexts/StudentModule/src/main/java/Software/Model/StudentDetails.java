/**
 * Created by sharad on 1/9/19.
 */

package Software.Model;

import Software.Utilities.AbstractCrudStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonPropertyOrder({

        "id",
        "name",
        "classname",
        "section",
        "rollNo",
        "classTeacher",
        "fathersName",
        "mothersName",
        "age",
        "gender",
        "religion",
        "category"

})

@Document(collection="studentDetails")
@JsonIgnoreProperties({"religion","category"})
public class StudentDetails {

    @Id
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("className")
    private String className;

    @JsonProperty("section")
    private String section;

    @JsonProperty("classTeacher")
    private String classTeacher;

    @JsonProperty("rollNo")
    private String rollNo;

    @JsonProperty("fathersName")
    private String fathersName;

    @JsonProperty("mothersName")
    private String mothersName;

    @JsonProperty("age")
    private String age;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("religion")
    private String religion;

    @JsonProperty("category")
    private String category;


    public StudentDetails(String name, String className, String section, String classTeacher, String rollNo, String fathersName, String mothersName, String age, String gender, String religion, String category) {
        this.name = name;
        this.className = className;
        this.section = section;
        this.classTeacher = classTeacher;
        this.rollNo = rollNo;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.age = age;
        this.gender = gender;
        this.religion = religion;
        this.category = category;
    }

//    public StudentDetails(String name) {
//        this.name = name;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}