package designpattern.gof_composite.sample001;

import designpattern.gof_composite.sample001.speech.*;

public class Speaker {
    public static void main(String[] args) {

        RecordHandler recorder4 = new RecordHandler();

        recorder4.add(new ah());
        recorder4.add(new hey());
        recorder4.add(new yes());
        recorder4.add(new good());

        RecorderType recordFolderSub = new RecorderType();

        recordFolderSub.add(new top());
        recordFolderSub.add(recorder4);

        RecordHandler recorder = new RecordHandler();

        recorder.add(new ah());
        recorder.add(new hey());
        recorder.add(new yes());
        recorder.add(new good());

        RecordHandler recorder2 = new RecordHandler();

        recorder2.add(new ah());
        recorder2.add(new hey());
        recorder2.add(new yes());
        recorder2.add(new good());

        RecordHandler recorder3 = new RecordHandler();

        recorder3.add(new ah());
        recorder3.add(new hey());
        recorder3.add(new yes());
        recorder3.add(new good());

        RecorderType recordFolder = new RecorderType();

        recordFolder.add(new top());
        recordFolder.add(recorder);

        RecorderType recordFolder2 = new RecorderType();

        recordFolder2.add(new top());
        recordFolder2.add(recorder2);

        RecorderType recordFolder3 = new RecorderType();

        recordFolder3.add(new top());
        recordFolder3.add(recorder3);
        recordFolder3.add(recordFolder);
        recordFolder3.add(recordFolder2);

        System.out.println(recordFolder3.speak(0));

    }
}
