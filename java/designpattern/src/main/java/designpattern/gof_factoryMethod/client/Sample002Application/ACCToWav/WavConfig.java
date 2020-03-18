package designpattern.gof_factoryMethod.client.Sample002Application.ACCToWav;

import designpattern.gof_factoryMethod.sample002.Config;

public class WavConfig implements Config {
    private final String wavFilePath;

    private final String wavFileName;

    public static class Builder {

        // 필수 값
        private final String wavFilePath;

        private String wavFileName;

        public Builder(String wavFilePath) {
            this.wavFilePath = wavFilePath;
        }

        public Builder setWavFileName(String wavFileName) {
            wavFileName = wavFileName;
            return this;
        }

        public WavConfig build() {
            return new WavConfig(this);
        }
    }

    private WavConfig(Builder builder) {
        wavFilePath = builder.wavFilePath;
        wavFileName = builder.wavFileName;
    }

    public String getWavFileName() {
        return wavFileName;
    }
}
