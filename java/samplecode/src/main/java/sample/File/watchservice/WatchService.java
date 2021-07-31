package sample.File.watchservice;

/*import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;*/

import java.nio.file.*;
import java.util.List;

public class WatchService { //extends Application {
    class WatchServiceThread extends Thread {

        @Override
        public void run() {
//            try {
//                java.nio.file.WatchService watchService = FileSystems.getDefault().newWatchService();
//                Path directory = Paths.get("./");
//                directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
//                        StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
//
//                while (true) {
//                    WatchKey watchKey = watchService.take();
//                    List<WatchEvent<?>> list = watchKey.pollEvents();
//
//                    for (WatchEvent<?> watchEvent : list) {
//                        WatchEvent.Kind<?> kind = watchEvent.kind();
//                        Path path = (Path) watchEvent.context();
//
//                        if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
//                            Platform.runLater(() -> textArea.appendText("파일 생성됨 -> " + path.getFileName() + "\n"));
//                        } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
//                            Platform.runLater(() -> textArea.appendText("파일 삭제됨 -> " + path.getFileName() + "\n"));
//                        } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
//                            Platform.runLater(() -> textArea.appendText("파일 수정됨 -> " + path.getFileName() + "\n"));
//                        } else if (kind == StandardWatchEventKinds.OVERFLOW) {
//
//                        }
//                    }
//
//                    boolean valid = watchKey.reset();
//
//                    if (!valid) {
//                        break;
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }

    }

    //TextArea textArea;

//    @Override
//    public void start(Stage arg0) throws Exception {
//        BorderPane root = new BorderPane();
//        root.setPrefSize(500, 300);
//
//        textArea = new TextArea();
//        textArea.setEditable(false);
//        root.setCenter(textArea);
//
//        Scene scene = new Scene(root);
//        arg0.setScene(scene);
//        arg0.setTitle("WatchServiceExample");
//        arg0.show();
//
//        WatchServiceThread wst = new WatchServiceThread();
//        wst.start();
//    }

 //   public static void main(String[] args) {
 //       launch(args);
 //   }
}
