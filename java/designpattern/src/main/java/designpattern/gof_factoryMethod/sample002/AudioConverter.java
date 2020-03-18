package designpattern.gof_factoryMethod.sample002;

public abstract class AudioConverter {

    protected abstract Config AudioFileByConverter(AudioFile audioFile);

    protected abstract MFCCObject AnalizeAudioFile(Config audioFile);

    public MFCCObject parsingAudio(AudioFile audioFile) {

        Config config = AudioFileByConverter(audioFile);

        return AnalizeAudioFile(config);
    }
}
