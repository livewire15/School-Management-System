package Rishit;

import Rishit.StudentDetails;
import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<StudentDetails,String> {
    StudentDetails findById(ObjectId _id);
}
