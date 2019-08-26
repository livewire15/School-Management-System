package Rishit;

import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class StudentDetails{

    @Id
    private String id;
    private String name, className, section;

    public StudentDetails(String name, String className, String section) {
        this.name = name;
        this.className = className;
        this.section = section;
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
}