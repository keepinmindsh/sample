package sample.AudioAnalize;

import java.util.ArrayList;

/* A similarity measure based on "Dynamic Time Warping". The DTW distance is
 * mapped to a similarity measure using f(x)= 1 - (x / (1 + x)). Feature weights
 * are also supported.
 *
 */
public class DTWSimilarity {

    private static final long serialVersionUID = -8898553450277603746L;
    // la disntace optimale
    double Distance = 0.0D;

    /* XXX DOC
     * @param i
     * @param j
     * @param ts1
     * @param ts2
     * @return
     * */
    private double pointDistance(int i, int j, ArrayList<double[]> ts1, ArrayList<double[]> ts2) {
        // double framei[]=(double[])(ts1.get(i)); : is the frame i for the the first recording
        //double framei[]=(double[])(ts2.get(i)); : is the frame i for the the second recording
        // ts1.size(): is the number of frames for the first recording
        //ts2.size(): is the number of frames for the second recording
        double diff = 0;
        for (int k = 0; k < 39; k++)
            diff = diff + ((double[]) ts1.get(i))[k] - ((double[]) ts2.get(j))[k];
        return (diff * diff);// return the distance (Euclidian distance) between tow frames
    }

    /**
     * XXX DOC
     *
     * @param x
     * @return
     */
    private double distance2Similarity(double x) {
        return (1.0 - (x / (1 + x)));
    }

    /**
     * XXX DOC
     */
    public double measure(ArrayList<double[]> ts1, ArrayList<double[]> ts2) {

        int i, j;

        /** Build a point-to-point distance matrix */
        double[][] dP2P = new double[ts1.size()][ts2.size()];
        for (i = 0; i < ts1.size(); i++) {
            for (j = 0; j < ts2.size(); j++) {
                dP2P[i][j] = pointDistance(i, j, ts1, ts2);
            }
        }

        /** Check for some special cases due to ultra short time series */
        if (ts1.size() == 0 || ts2.size() == 0) {
            return Double.NaN;
        }

        if (ts1.size() == 1 && ts2.size() == 1) {
            return distance2Similarity(Math.sqrt(dP2P[0][0]));
        }

        /**
         * Build the optimal distance matrix using a dynamic programming
         * approach
         */
        double[][] D = new double[ts1.size()][ts2.size()];

        D[0][0] = dP2P[0][0]; // Starting point

        for (i = 1; i < ts1.size(); i++) { // Fill the first column of our
            // distance matrix with optimal
            // values
            D[i][0] = dP2P[i][0] + D[i - 1][0];
        }

        if (ts2.size() == 1) { // TS2 is a point
            double sum = 0;
            for (i = 0; i < ts1.size(); i++) {
                sum += D[i][0];
            }
            return distance2Similarity(Math.sqrt(sum) / ts1.size());
        }

        for (j = 1; j < ts2.size(); j++) { // Fill the first row of our
            // distance matrix with optimal
            // values
            D[0][j] = dP2P[0][j] + D[0][j - 1];
        }

        if (ts1.size() == 1) { // TS1 is a point
            double sum = 0;
            for (j = 0; j < ts2.size(); j++) {
                sum += D[0][j];
            }
            return distance2Similarity(Math.sqrt(sum) / ts2.size());
        }

        for (i = 1; i < ts1.size(); i++) { // Fill the rest
            for (j = 1; j < ts2.size(); j++) {
                double[] steps = {D[i - 1][j - 1], D[i - 1][j], D[i][j - 1]};
                double min = Math.min(steps[0], Math.min(steps[1], steps[2]));
                D[i][j] = dP2P[i][j] + min;
            }
        }

        /**
         * Calculate the distance between the two time series through optimal
         * alignment.
         */
        i = ts1.size() - 1;
        j = ts2.size() - 1;
        int k = 1;
        double dist = D[i][j];

        while (i + j > 2) {
            if (i == 0) {
                j--;
            } else if (j == 0) {
                i--;
            } else {
                double[] steps = {D[i - 1][j - 1], D[i - 1][j], D[i][j - 1]};
                double min = Math.min(steps[0], Math.min(steps[1], steps[2]));

                if (min == steps[0]) {
                    i--;
                    j--;
                } else if (min == steps[1]) {
                    i--;
                } else if (min == steps[2]) {
                    j--;
                }
            }
            k++;
            dist += D[i][j];
        }
        Distance = dist;
        return distance2Similarity(Math.sqrt(dist) / k);
    }

    public static void main(String args[]) {
        DTWSimilarity dtws = new DTWSimilarity();
        //FeatureFileDumper ffd1=new FeatureFileDumper(cm,frontEndName,inputfile);
        //FeatureFileDumper ffd2=new FeatureFileDumper(cm,frontEndName,inputfile);
        //ArrayList<double[]> ts1=ffd1.allfeatres;
        //ArrayList<double[]> ts2=ffd2.allfeatres;
// I just rectifie your class to get allfeatres as a ArrayList of (double[])vectors;
        //dtws.measure(ts1,ts2);

    }
}