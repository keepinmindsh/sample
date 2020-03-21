package sample.Reactive.callrestapi.command;


import sample.Reactive.callrestapi.vo.ParameterVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class URLCommand<T> implements Command {

    private PrintWriter out = null;
    private BufferedReader in = null;

    @Override
    public T execute(String url, String path, ParameterVO parameterVO) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        try{

            String queryParameter = parameterVO.toString();

            String connectionURL = url + path;

            URL urlConnection = new URL(connectionURL);

            URLConnection connection = urlConnection.openConnection();

            HttpURLConnection hurl = (HttpURLConnection)connection;

            hurl.setRequestMethod("POST");
            hurl.setDoOutput(true);
            hurl.setDoInput(true);
            hurl.setUseCaches(false);
            hurl.setDefaultUseCaches(false);

            out = new PrintWriter(hurl.getOutputStream());
            out.println(queryParameter);

            in = new BufferedReader(new InputStreamReader(hurl.getInputStream()));

            String inputLine = null;

            while((inputLine = in.readLine()) != null){
                stringBuilder.append(inputLine);
            }

        }catch(Exception ex){
            System.out.println(ex);
        }finally {
            if(out != null){
                out.close();
            }

            try {
                if(in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return (T) stringBuilder.toString();
    }
}
