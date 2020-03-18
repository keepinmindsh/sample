package designpattern.gof_factoryMethod.client.Sample002Application;

import designpattern.gof_factoryMethod.client.Sample002Application.ACCToWav.AACFile;
import designpattern.gof_factoryMethod.client.Sample002Application.ACCToWav.WavAudioConverter;
import designpattern.gof_factoryMethod.client.Sample002Application.ACCToWav.WavConfig;
import designpattern.gof_factoryMethod.sample002.AudioConverter;
import designpattern.gof_factoryMethod.sample002.MFCCObject;

public class Client {

    public static void main(String[] args) {

        WavConfig.Builder wavConfig = new WavConfig.Builder("/home/user/");

        AudioConverter wavConverter = new WavAudioConverter(wavConfig.setWavFileName("wav.wav").build());

        MFCCObject mfccObject = wavConverter.parsingAudio(new AACFile());
    }
}
