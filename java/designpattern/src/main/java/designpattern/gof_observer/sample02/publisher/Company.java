package designpattern.gof_observer.sample02.publisher;

import java.util.Observable;

public class Company extends Observable {
    private String photoUrl;
    private String content;

    public Company() {
    }

    public void messageChanged() { // 새로운 소식이 들어왔다고 알려줌 (상태가 변했다고 알려주는 메소드)

        setChanged();
        notifyObservers();
    }

    public void setMessage(String photoUrl, String content) { // 새로운 소식이 들어오는 메소드

        this.photoUrl = photoUrl;
        this.content = content;
        messageChanged();

    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getContent() {
        return content;
    }
}
