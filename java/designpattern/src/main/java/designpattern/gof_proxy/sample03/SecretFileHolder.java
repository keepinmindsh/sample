package designpattern.gof_proxy.sample03;

class SecretFileHolder {
    public static String decodeByFileName(String name) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name;
    }
}
