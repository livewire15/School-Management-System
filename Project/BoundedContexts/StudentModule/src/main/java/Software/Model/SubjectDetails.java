/**
 * Created by sharad on 1/9/19.
 */

package Software.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@JsonPropertyOrder({

        "id",
        "className",
        "subjects"
})

@Document(collection="subjectDetails")
@JsonIgnoreProperties({})
public class SubjectDetails {

    @Id
    private String id;

    @JsonProperty("className")
    private String className;

    @JsonProperty("subjects")
    private ArrayList<String> subjects;

    public SubjectDetails(String className, ArrayList<String> subjects) {
        this.className = className;
        this.subjects = subjects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }
}
