package designpattern.gof_visitor.sample03.element;

import designpattern.gof_visitor.sample03.vistors.Unit;

import java.util.ArrayList;
import java.util.List;

public class HighTemplar implements Magic {

    private List<Magic> magics;

    public HighTemplar(){
        magics = new ArrayList<>();
    }

    public void setMagics(Magic music){
        magics.add(music);
    }

    @Override
    public void Accept(Unit unit) {
        magics.forEach(demageItem -> {
           demageItem.Accept(unit);
        });
    }
}
