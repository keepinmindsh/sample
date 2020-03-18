package designpattern.gof_chainofresponsibility.sample03;

public class SpecialForce implements PoliceOfficer {

    private Person resolver;

    @Override
    public void resolveProblem() {

    }

    @Override
    public void setPolice(Person person) {
        this.resolver = person;
    }
}
