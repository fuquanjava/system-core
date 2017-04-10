package exception;


public class Service {

    public boolean lt0(int i) {
        if (i < 0) {
            throw new BusinessException("小于0");
        }
        return i < 0;
    }

    public static void main(String[] args) {
        Service service = new Service();

        try {
            service.lt0(-1);
        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();

        }
    }
}
