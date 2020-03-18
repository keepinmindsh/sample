package designpattern.study.GatewayProcess.Meterial;

public class Meterial {

    private final int mineral;
    private final int pylon;

    public static class Builder {
        private int mineral;
        private int pylon;

        public Builder mineral(int mineral) {
            this.mineral = mineral;

            return this;
        }

        public Builder pylon(int pylon) {
            this.pylon = pylon;

            return this;
        }

        public Meterial Build() {
            return new Meterial(this);
        }
    }

    private Meterial(Builder builder) {
        this.mineral = builder.mineral;
        this.pylon = builder.pylon;
    }

    public int getMineralAmount() {
        return mineral;
    }

    public int getPylonCapacity() {
        return pylon;
    }

}
