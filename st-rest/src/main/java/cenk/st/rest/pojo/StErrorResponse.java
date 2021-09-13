package cenk.st.rest.pojo;

import cenk.st.rest.exception.StError;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StErrorResponse {
	@JsonProperty("ERROR CODE")
	private int errorCode;
	@JsonProperty("ERROR MESSAGE")
	private String msg;
	
	public StErrorResponse() {}
	
	public StErrorResponse(int code, String msg) {
		errorCode = code;
		this.msg = msg;
	}

	public StErrorResponse(StError e) {
		errorCode = e.errorCode();
		msg = e.getMessage();
	}

}
