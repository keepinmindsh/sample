package designpattern.java_sample;


public class sample {
    public static void main(String[] args) {

        design des1 = provider.createSampleOrNull("A");

        des1.value();
    }
}

interface design {

    public void value();

}

class provider {

    public static design createSampleOrNull(String gubun) {
        switch (gubun) {
            case "A":
                return new sampleB();
            case "B":
                return new sampleC();


        }

        return null;
    }
}

class sampleA extends sample {

}

class sampleB implements design {

    @Override
    public void value() {

    }
}

class sampleC implements design {

    @Override
    public void value() {

    }
}