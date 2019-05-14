package base.model.employee.exception;

public class EmployeeException extends RuntimeException {

    private int errorCode;

    public EmployeeException(String message) {
        super(message);
    }

    public EmployeeException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode.getErrorCode();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return errorCode + " " + super.getMessage();
    }
}
