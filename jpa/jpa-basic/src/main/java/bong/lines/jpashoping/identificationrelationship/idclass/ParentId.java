package bong.lines.jpashoping.identificationrelationship.idclass;

import java.io.Serializable;

public class ParentId implements Serializable {

    private String id1; // Parent.id1 매핑
    private String id2; // Parent.id2 매핑

    public ParentId(){

    }

    public ParentId(String id1, String id2){
        this.id1 = id1;
        this.id2 = id2;
    }
}
