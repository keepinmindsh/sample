package sample.File.filestream;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.text.NumberFormat;

@Slf4j
public class ReadBinaryFile {
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

        DataInputStream dataInputStream = getStream("movies.dat");
        boolean eof = false;
        while (!eof){
            Movie movie = readMovie(dataInputStream);
            if(movie == null){
                eof = true;
            }else {
                String msg = Integer.toString(movie.year);
                msg += ": " + movie.title;
                msg += " (" + numberFormat.format(movie.price);
                log.info(msg);
            }
        }
        closeFile(dataInputStream);
    }

    private static void closeFile(DataInputStream dataInputStream) {
        try {
            dataInputStream.close();
        }catch(IOException ioException){
            log.error(ioException.getMessage());
        }
    }

    private static Movie readMovie(DataInputStream dataInputStream) {
        String title = "";
        int year = 0;
        double price = 0.0;

        try {
            title = dataInputStream.readUTF();
            year = dataInputStream.readInt();
            price = dataInputStream.readDouble();
        }catch (EOFException eofException){
            return null;
        }catch (IOException ioException){
            log.error(ioException.getMessage());
            System.exit(0);
        }
        return new Movie(title, year, price);
    }

    private static DataInputStream getStream(String s) {
        DataInputStream in = null;
        try {
            File file = new File(s);
            in = new DataInputStream(new BufferedInputStream(
                    new FileInputStream(file)
            ));
        }catch (FileNotFoundException fileNotFoundException){
            log.error("The file doesn't exist");
            System.exit(0);
        }
        return in;
    }

    private static class Movie {
        public String title;
        public int year;
        public double price;
        public Movie(String title, int year, double prices){
            this.title = title;
            this.year = year;
            this.price = prices;
        }
    }
}
