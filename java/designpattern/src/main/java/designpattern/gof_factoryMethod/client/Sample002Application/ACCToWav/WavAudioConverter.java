package designpattern.gof_factoryMethod.client.Sample002Application.ACCToWav;

import designpattern.gof_factoryMethod.sample002.AudioConverter;
import designpattern.gof_factoryMethod.sample002.AudioFile;
import designpattern.gof_factoryMethod.sample002.Config;
import designpattern.gof_factoryMethod.sample002.MFCCObject;

public class WavAudioConverter extends AudioConverter {

    private Config config = null;

    public WavAudioConverter(Config config) {
        this.config = config;
    }

    protected Config AudioFileByConverter(AudioFile audioFile) {

        config.getWavFileName();

        return config;
    }

    protected MFCCObject AnalizeAudioFile(Config config) {
        return null;
    }
}
