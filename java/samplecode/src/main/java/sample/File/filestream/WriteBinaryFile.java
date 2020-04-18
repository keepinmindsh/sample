package sample.File.filestream;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class WriteBinaryFile {
    public static void main(String[] args) {
        Movie[] movies = getMovies();
        DataOutputStream dataOutputStream = openOutputStream("movies.dat");
        for(Movie movie: movies){
            writeMovie(movie, dataOutputStream);
        }
        closeFile(dataOutputStream);
    }

    private static void closeFile(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.close();
        }catch(IOException ioException){
            log.error(ioException.getMessage());
            System.exit(0);
        }
    }

    private static void writeMovie(Movie movie, DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.writeUTF(movie.title);
            dataOutputStream.writeInt(movie.year);
            dataOutputStream.writeDouble(movie.price);
        } catch (IOException ioException){
            log.error(ioException.getMessage());
            System.exit(0);
        }
    }

    private static DataOutputStream openOutputStream(String s) {
        DataOutputStream outputStream = null;
        try {
            File file = new File(s);
            outputStream = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)
                    )
            );

            return outputStream;
        }catch(IOException ioException){
            log.error("I/O Exception opening file.");
            System.exit(0);
        }
        return outputStream;
    }

    private static Movie[] getMovies() {
        Movie[] movies = new Movie[1];

        movies[0] = new Movie("It's a Wonderful Life", 1946, 14.95);

        return movies;
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
