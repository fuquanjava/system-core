package exception;


public class BusinessException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -6971716908203238516L;

    private String code;

    private String description;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
        this.description = this.getMessage();
    }

    public BusinessException(Throwable cause) {
        super(cause);
        this.description = this.getMessage();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.description = this.getMessage();
    }

    public BusinessException(String code, String description) {
        super(description);
        this.code = code;
        this.description = description;
    }


    public BusinessException(String code, String description, Throwable cause) {
        super(description, cause);
        this.code = code;
        this.description = description;
    }


    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "BusinessException [code=" + code + ", description=" + description + "]";
    }

}
