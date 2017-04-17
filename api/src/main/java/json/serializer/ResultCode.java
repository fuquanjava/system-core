package json.serializer;

public enum  ResultCode {
    LOGIN_FAILURE(8,"登录失败"),
    INVALID_ARGUMENT(0,"非法等级"),
    SIGN_ERROR(17,"签名错误");

    public final int value;

    public final String desc;

    ResultCode(int value,String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
            "value=" + value +
            ", desc='" + desc + '\'' +
            '}';
    }
}
