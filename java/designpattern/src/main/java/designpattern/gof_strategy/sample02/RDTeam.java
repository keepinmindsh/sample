package designpattern.gof_strategy.sample02;

import designpattern.gof_strategy.sample02.Business.Coding;
import designpattern.gof_strategy.sample02.Persons.Developer;

public class RDTeam {
    public static void main(String[] args) throws Exception {

        Developer developer1 = Coding.orderByTeamLeader("오의섭호출");

        developer1.doCode();

        Developer developer2 = Coding.orderByTeamLeader("박용선호출");

        developer2.doCode();

        Developer developer3 = Coding.orderByTeamLeader("승화호출");

        developer3.doCode();
    }
}
