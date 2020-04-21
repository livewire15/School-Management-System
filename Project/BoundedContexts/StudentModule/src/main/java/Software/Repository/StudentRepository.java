/**
 * Created by sharad on 1/9/19.
 */

package Software.Repository;

import Software.Model.StudentDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<StudentDetails,String> {

}
