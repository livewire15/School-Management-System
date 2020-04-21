/**
 * Created by sharad on 1/9/19.
 */

package Software.Repository;

import Software.Model.SubjectDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<SubjectDetails,String> {

}
