package cenk.st.rest.exception;

import org.springframework.http.HttpStatus;

public abstract class StError extends Exception{
	private static final long serialVersionUID = -2365281008119447247L;
	abstract public int errorCode();
	public HttpStatus status() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}
}
