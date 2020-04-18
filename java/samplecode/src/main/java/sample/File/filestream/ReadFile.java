package sample.File.filestream;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.text.NumberFormat;

@Slf4j
public class ReadFile {
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        BufferedReader bufferedReader = getReader("movies.txt");
        Movie movie = readMovie(bufferedReader);
        while ( movie != null){
            String msg = Integer.toString(movie.year);
            msg += ": " + movie.title;
            msg += " (" + numberFormat.format(movie.price) + ")";
            log.info(msg);
            movie = readMovie(bufferedReader);
        }

        // Write
        Movie[] movies = getMovies();
        PrintWriter printWriter = openWriter("file.txt");
        for(Movie movie1 : movies){
            writeMovie(movie, printWriter);
        }
        printWriter.close();
    }

    private static Movie[] getMovies() {
        Movie[] movies = new Movie[1];

        movies[0] = new Movie("It's a Wonderful Life", 1946, 14.95);

        return movies;
    }

    private static Movie readMovie(BufferedReader bufferedReader) {
        String title;
        int year;
        double price;
        String line = "";
        String[] data;
        try {
            line = bufferedReader.readLine();
        }catch (IOException ioException){
            log.error("I/O Error");
            System.exit(0);
        }

        if( line == null){
            return null;
        }else {
            data = line.split("\t");
            title = data[0];
            year = Integer.parseInt(data[1]);
            price = Double.parseDouble(data[2]);
            return new Movie(title, year, price);
        }
    }

    private static BufferedReader getReader(String s) {
        BufferedReader bufferedReader = null;
        try {
            File file = new File(s);
            bufferedReader = new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException fileNotFoundException){
            log.info("The file doesn't exist.");
            System.exit(0);
        }
        return bufferedReader;
    }

    private static PrintWriter openWriter(String name){
        try {
            File file = new File(name);
            PrintWriter printWriter = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(file)
                    ), true
            );
        }catch (IOException ioException){
            log.error(ioException.getMessage());
            System.exit(0);
        }
        return null;
    }

    private static void writeMovie(Movie movie, PrintWriter printWriter){
        String line = movie.title;
        line += "\t" + Integer.toString(movie.year);
        line += "\t" + Double.toString(movie.price);
        log.info(line);
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
