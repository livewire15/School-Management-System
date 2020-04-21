/**
 * Created by sharad on 3/9/19.
 */

package Software.Payload;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class StudentModulePayload {

    public enum RESPONSE_STATUS {SUCCESS, FAILURE};

    private RESPONSE_STATUS responseStatus;
    private String responseMessage;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Object> responseDetails = new ArrayList<>();

    public StudentModulePayload(RESPONSE_STATUS responseStatus, String responseMessage) {
        this.responseStatus = responseStatus;
        this.responseMessage = responseMessage;
    }

    public RESPONSE_STATUS getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(RESPONSE_STATUS responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public List<Object> getResponseDetails() {
        return responseDetails;
    }

    public void setResponseDetails(List<Object> responseDetails) {
        this.responseDetails = responseDetails;
    }

    public void addResponseDetails(Object responseDetail)
    {
        if(responseDetail!=null)
        {
            responseDetails.add(responseDetail);
        }
    }



}
