/**
 * Created by sharad on 3/9/19.
 */

package Software.Utilities;


import Software.SpringMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SMLogger {

    private SMLogger(){ };

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringMain.class);

    public static Logger getLogger(){return LOGGER;}

}
