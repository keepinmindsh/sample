package designpattern.study.Package.MakeMeterial;

public class MeterialBuilder {

    private String water = "";
    private String milk = "";
    private String chocolate = "";
    private String wondoo = "";

    public static class Builder {

        private String water = "";
        private String milk = "";
        private String chocolate = "";
        private String wondoo = "";

        public Builder setWater(String water) {
            this.water = water;
            return this;
        }

        public Builder setMilk(String milk) {
            this.milk = milk;
            return this;
        }


        public Builder setChocolate(String chocolate) {
            this.water = chocolate;
            return this;
        }

        public Builder setWondu(String wondu) {
            this.wondoo = wondu;
            return this;
        }

        public MeterialBuilder build() {
            return new MeterialBuilder(this);
        }

    }

    private MeterialBuilder(Builder builder) {
        this.water = builder.water;
        this.milk = builder.milk;
        this.chocolate = builder.chocolate;
        this.wondoo = builder.wondoo;
    }

    public void SetMeterial() {

        String strLink = "";

        if (!water.isEmpty()) {
            strLink += "," + water;
        }

        if (!milk.isEmpty()) {
            strLink += "," + milk;
            System.out.println();
        }

        if (!chocolate.isEmpty()) {
            strLink += "," + chocolate;
        }


        if (!wondoo.isEmpty()) {
            strLink += "," + wondoo;
        }

        System.out.println(strLink);
    }
}
