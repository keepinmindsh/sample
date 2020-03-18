package sample.AudioAnalize;

import com.musicg.fingerprint.FingerprintSimilarity;
import com.musicg.wave.Wave;

import java.io.FileInputStream;
import java.io.InputStream;

public class AnalizeByMusicG02 {


    private float result;
    private float score;

    public static void main(String[] args) {
        new AnalizeByMusicG02().match();
    }

    public void match() {
        String filename1 = "F:\\Drive\\5_Project\\private\\02_VM_Project\\0003_Project\\08_SpeechAnalize_API\\2_Analize\\RecordSample\\ah001.wav";
        String filename2 = "F:\\Drive\\5_Project\\private\\02_VM_Project\\0003_Project\\08_SpeechAnalize_API\\2_Analize\\RecordSample\\ah002.wav";

        try {

            InputStream fis1 = null, fis2 = null;

            fis1 = new FileInputStream(filename1);
            fis2 = new FileInputStream(filename2);

            Wave wave1 = new Wave(fis1);
            Wave wave2 = new Wave(fis2);

            FingerprintSimilarity similarity;

            double[][] db1 = wave1.getSpectrogram().getNormalizedSpectrogramData();
            double[][] db2 = wave2.getSpectrogram().getNormalizedSpectrogramData();


/*
            for (int i = 0; i < db1.length; i++) {
                for (int j = 0; j < db1[i].length; j++) {
                    System.out.println(db1[i] + db2[j]);
                }
                
            }
*/

            // initialize dyanamic time warpping object. The variance represents the variance for each dimension.
            // the purpose is to normalize each dimension when we do euclidean calculation, since the scale
            // of each dimension may quite different.
            DynamicTimeWrapping dtw = new DynamicTimeWrapping2D(db1, db2);

            // calculate the distance
            double distance = dtw.calDistance();

            System.out.println(distance);


            similarity = wave1.getFingerprintSimilarity(wave2);
            result = similarity.getSimilarity() * 100;


            score = similarity.getScore();

            System.out.println(result);
            System.out.println(score);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
