package designpattern.study.GatewayProcess.Unit.Builder;

import designpattern.study.GatewayProcess.Unit.DarkTempler;
import designpattern.study.GatewayProcess.Unit.Dragoon;
import designpattern.study.GatewayProcess.Unit.HighTempler;
import designpattern.study.GatewayProcess.Unit.Trainer.Unit;
import designpattern.study.GatewayProcess.Unit.Zealot;

public class UnitBuilder {
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

        public Unit unitTrainer(String unitType) {
            switch (unitType) {
                case "질럿":
                    return new Zealot();
                case "하이템플러0":
                    return new HighTempler();
                case "다크템플러":
                    return new DarkTempler();
                case "드라군":
                    return new Dragoon();
                default:
                    return null;
            }
        }
    }

    private UnitBuilder(Builder builder) {
        this.mineral = builder.mineral;
        this.pylon = builder.pylon;
    }
}
