package spoonacular;

public class Error {
    private String status;
    private String message;
    private int code;

    public Error() {
    }

    public Error(String status, String message, int code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
