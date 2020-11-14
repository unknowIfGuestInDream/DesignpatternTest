package 单例.枚举单例例子2;

public enum Singleton {
    INSTANCE;

    private byte[] dat = new byte[1024];

    Singleton() {
        System.out.println("INSTANCE will be initialized immediately");
    }

    public static void method() {
        //
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton.method();
    }


}
