package hu.training360.taskmanager.exception;

public class TaskManagerException extends RuntimeException {

    private ErrorCode errorCode;

    public TaskManagerException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public TaskManagerException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
