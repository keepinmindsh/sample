package basic.Builder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuilderSample {
    public static void main(String[] args) {

        ParamBuilder.Builder builder = new ParamBuilder.Builder();

        ParamBuilder paramBuilder = builder.setAValue("1111")
                .setBValue("12123")
                .build();

        log.info("AValue : {}", paramBuilder.getAValue());
        log.info("BValue : {}", paramBuilder.getBValue());
    }
}

class ParamBuilder {

    private final String BValue;
    private final String AValue;

    public static class Builder{

        private String AValue;
        private String BValue;

        public Builder setAValue(String AValue) {
            this.AValue = AValue;
            return this;
        }

        public Builder setBValue(String BValue) {
            this.BValue = BValue;
            return this;
        }

        public ParamBuilder build(){
            return new ParamBuilder(this);
        }
    }

    public String getBValue() {
        return BValue;
    }

    public String getAValue() {
        return AValue;
    }

    private ParamBuilder(Builder builder){
        this.AValue = builder.AValue;
        this.BValue = builder.BValue;
    }
}
