package sample.AudioAnalize;

import com.musicg.fingerprint.FingerprintSimilarity;
import com.musicg.wave.Wave;

public class AnalizeByMusicG {

    public static void main(String[] args) {
        String recording = "src/musicG/moiz_sample_1.wav "; // Size is 30 sec
        String beep = "src/musicG/beep_exotel.wav";  // Size is 0.4 Sec

        Wave waveRecording = new Wave(recording);
        Wave waveBeep = new Wave(beep);

        FingerprintSimilarity similarity = waveRecording.getFingerprintSimilarity(waveBeep);
        System.out.println("clip is found at " + similarity.getsetMostSimilarTimePosition());
    }
}
