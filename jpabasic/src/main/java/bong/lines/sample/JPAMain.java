package bong.lines.sample;

import bong.lines.comm.TransactionTemplate;
import bong.lines.sample.opration.BasicSample;
import bong.lines.sample.opration.IdentitySample;

public class JPAMain {
    public static void main(String[] args) {
        // Basic Sample
        // new TransactionTemplate(new BasicSample()).process();

        // Basic Identity Sample
        new TransactionTemplate(new IdentitySample()).process();
    }
}
