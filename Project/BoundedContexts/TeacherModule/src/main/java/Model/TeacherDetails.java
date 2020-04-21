package Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TeacherDetails {

    @Id
    String id;
    String name,headClass,headSection,experience,age,gender;

    public TeacherDetails(String name, String headClass, String headSection, String experience, String age, String gender) {
        this.name = name;
        this.headClass = headClass;
        this.headSection = headSection;
        this.experience = experience;
        this.age = age;
        this.gender = gender;
    }

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

    public String getHeadClass() {
        return headClass;
    }

    public void setHeadClass(String headClass) {
        this.headClass = headClass;
    }

    public String getHeadSection() {
        return headSection;
    }

    public void setHeadSection(String headSection) {
        this.headSection = headSection;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
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
}
