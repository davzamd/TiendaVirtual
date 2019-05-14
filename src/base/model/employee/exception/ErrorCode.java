package base.model.employee.exception;

public enum ErrorCode {

    ERROR_INVALID_CODE(111),
    ERROR_INVALID_PASSWORD(222);

    private int code;

    private ErrorCode(int code) {
        this.code = code;
    }

    public int getErrorCode(){
        return code;
    }
}
