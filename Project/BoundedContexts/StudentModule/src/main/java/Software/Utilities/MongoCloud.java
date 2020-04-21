/**
 * Created by sharad on 1/9/19.
 */

package Software.Utilities;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoCloud {

        public void connectToMongoCloud(){

            MongoClientURI uri = new MongoClientURI(
                    "mongodb://sharad:mongodbcloud@cluster0-shard-00-00-y8bbz.mongodb.net:27017,cluster0-shard-00-01-y8bbz.mongodb.net:27017,cluster0-shard-00-02-y8bbz.mongodb.net:27017/student?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority");

            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("student");
        }

}
