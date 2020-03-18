package sample.HttpClient;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class HttpClientTest {

    public static final String urlLink = "https://wingscmsapi.sanhait.com/WithCMS.WebService/WithPMSBatchService_Allegro.asmx/PMS_Restriction_Daily";
    public static final String urlLink2 = "http://172.30.0.186:8082/api/card/room";

    /**
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static void whenPostRequestUsingHttpClient_thenCorrect()
            throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(urlLink);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("", "John"));
        params.add(new BasicNameValuePair("password", "pass"));
        httpPost.setEntity(new UrlEncodedFormEntity(params));

        CloseableHttpResponse response = client.execute(httpPost);

        // Http Military 의 Status Code를 반환
        System.out.println(response.getStatusLine().getStatusCode());
        // Response의 Entity값을 반환
        System.out.println(EntityUtils.toString(response.getEntity()));

        client.close();
    }

    /**
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static void whenPostRequestUsingHttpClient_withPost()
            throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(urlLink2);

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        //Date date = new Date();
        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        //dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        // book, cancel, in, out

        params.add(new BasicNameValuePair("status", "book"));
        params.add(new BasicNameValuePair("timestamp", String.valueOf(Instant.now().getEpochSecond())));  //dateFormat.format(date)));
        // Response의 Entity값을 반환
        System.out.println("UTC Param :" + String.valueOf(Instant.now().getEpochSecond()));

        params.add(new BasicNameValuePair("siteid", ""));
        params.add(new BasicNameValuePair("spaceid", ""));
        params.add(new BasicNameValuePair("phone", ""));
        params.add(new BasicNameValuePair("email", ""));
        httpPost.setEntity(new UrlEncodedFormEntity(params));

        CloseableHttpResponse response = client.execute(httpPost);

        // Http Military 의 Status Code를 반환
        System.out.println(response.getStatusLine().getStatusCode());
        // Response의 Entity값을 반환
        System.out.println(EntityUtils.toString(response.getEntity()));

        client.close();
    }

    public static void whenGetReqeustUsingHttpClient_withPut() throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpEntityEnclosingRequestBase httpPut = new HttpPut(urlLink2+ "?room=901호&start=19:10:17:15:30&end=19:10:18:15:30");

        CloseableHttpResponse response = client.execute(httpPut);


        // Http Military 의 Status Code를 반환
        System.out.println(response.getStatusLine().getStatusCode());
        // Response의 Entity값을 반환
        System.out.println(EntityUtils.toString(response.getEntity()));

        client.close();
    }

    public static void whenGetReqeustUsingHttpClient_withGet() throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpRequestBase httpPut = new HttpGet(urlLink2+ "?room=901호&start=19:10:17:15:30&end=19:10:18:15:30");

        CloseableHttpResponse response = client.execute(httpPut);

        // Http Military 의 Status Code를 반환
        System.out.println(response.getStatusLine().getStatusCode());
        // Response의 Entity값을 반환
        System.out.println(EntityUtils.toString(response.getEntity()));

        client.close();
    }

    /**
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static void whenPostRequestUsingHttpClient_thenCorrect_withXML()
            throws ClientProtocolException, IOException {
        final String request = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Total_Forecast><Forecast Date=\"2018-01-26\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-19\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-02-24\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-12\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-13\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-14\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-03\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-04-11\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-13\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-19\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-24\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-08\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-13\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-14\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-18\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-03\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-09\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-10\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-13\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-14\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-17\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-18\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-30\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-03\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-04\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-07\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-30\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-12\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-13\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-31\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-01\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-14\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-18\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-19\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-22\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-25\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-26\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-14\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-23\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-11-23\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-24\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-26\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-04\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-07\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-13\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-15\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-23\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-26\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-28\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-29\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-20\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-01-27\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-15\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-03-03\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-22\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-03-30\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-01\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-10\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-15\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-11\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-15\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-20\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-30\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-02\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-06\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-26\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-28\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-17\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-18\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-01\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-23\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-25\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-11\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-23\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-09\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-11\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-12\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-15\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-16\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-22\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-25\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-30\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-11-05\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-07\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-08\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-11\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-14\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-27\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-02\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-01\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-07\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-15\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-18\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-21\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-02-01\" Total=\"137\" Used=\"14\"></Forecast><Forecast Date=\"2018-02-03\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-05\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-11\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-13\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-02-14\" Total=\"137\" Used=\"14\"></Forecast><Forecast Date=\"2018-02-23\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-08\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-16\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-19\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-23\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-04\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-04-17\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-29\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-02\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-23\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-26\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-16\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-24\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-01\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-10\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-23\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-29\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-04\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-04\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-06\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-12\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-16\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-30\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-07\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-11-01\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-16\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-29\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-30\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-03\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-09\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-12\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-17\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-19\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-27\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-31\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-02\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-22\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-26\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-01-29\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-01-30\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-02-16\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-02-22\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-18\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-09\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-18\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-25\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-01\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-07\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-17\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-22\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-08\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-22\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-26\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-28\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-06\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-15\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-16\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-22\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-10\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-15\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-17\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-27\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-28\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-05\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-06\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-08\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-18\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-19\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-24\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-29\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-11-03\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-12\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-13\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-20\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-21\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-14\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-21\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-22\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-05\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-17\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-25\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-01-28\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-09\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-21\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-02-27\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-05\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-06\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-20\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-02\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-12\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-20\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-22\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-04\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-12\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-25\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-28\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-04\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-05\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-19\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-20\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-22\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-23\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-29\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-05\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-03\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-11\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-24\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-28\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-03\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-08\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-20\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-24\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-01\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-13\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-11-06\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-10\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-22\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-25\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-08\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-11\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-16\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-24\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-30\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-04\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-10\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-11\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-14\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-24\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-02-06\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-08\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-12\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-26\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-28\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-04\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-15\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-24\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-27\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-14\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-26\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-10\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-15\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-13\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-15\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-19\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-21\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-08-08\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-10\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-14\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-19\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-26\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-05\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-07\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-29\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-03\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-04\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-10-10\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-21\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-27\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-28\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-11-28\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-01\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-18\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-06\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-13\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-02-02\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-02-07\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-10\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-17\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-02-25\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-02\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-09\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-10\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-21\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-25\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-26\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-28\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-29\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-31\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-07\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-16\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-21\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-06\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-19\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-24\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-01\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-07\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-08\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-11\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-12\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-21\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-25\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-06-27\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-09\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-14\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-16\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-20\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-07-24\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-25\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-07\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-17\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-21\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-27\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-29\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-02\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-09\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-21\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-02\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-20\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-26\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-31\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-11-04\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-15\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-17\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-18\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-19\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-06\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-25\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-03\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-09\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-12\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-19\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-01-31\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-04\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-02-18\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-02-20\" Total=\"137\" Used=\"13\"></Forecast><Forecast Date=\"2018-03-01\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-07\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-11\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-03-17\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-05\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-06\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-08\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-23\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-27\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-28\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-04-30\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-03\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-05\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-09\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-16\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-21\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-27\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-29\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-05-31\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-02\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-06\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-11\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-12\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-27\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-07-31\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-02\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-05\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-09\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-18\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-20\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-08-30\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-09-13\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-10-17\" Total=\"137\" Used=\"12\"></Forecast><Forecast Date=\"2018-11-02\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-11-09\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-05\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-10\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2018-12-20\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-08\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-16\" Total=\"137\" Used=\"0\"></Forecast><Forecast Date=\"2019-01-23\" Total=\"137\" Used=\"0\"></Forecast></Total_Forecast>\n";

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(urlLink);

        httpPost.setHeader("Content-Type", "text/xml");
        httpPost.setEntity(new StringEntity(request, "ISO-8859-1"));

        CloseableHttpResponse response = client.execute(httpPost);

        // Http Military 의 Status Code를 반환
        System.out.println(response.getStatusLine().getStatusCode());
        // Response의 Entity값을 반환
        System.out.println(EntityUtils.toString(response.getEntity()));

        client.close();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        // 임시 테스트를 위해서 try, cas
        try {
            //whenPostRequestUsingHttpClient_withPost();

            whenGetReqeustUsingHttpClient_withPut();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
