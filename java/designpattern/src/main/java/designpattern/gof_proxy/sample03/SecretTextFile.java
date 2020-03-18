package designpattern.gof_proxy.sample03;

public class SecretTextFile implements TextFile {
    private String plainText;

    public SecretTextFile(String fileName) {
        this.plainText = SecretFileHolder.decodeByFileName(fileName);
    }

    @Override
    public String fetch() {
        return plainText;
    }
}
