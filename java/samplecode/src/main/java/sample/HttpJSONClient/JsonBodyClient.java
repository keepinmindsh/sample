package sample.HttpJSONClient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.Arrays;


public class JsonBodyClient {

    private static String body = "{{\"cmd\"  : \"cmd-event\",\"status\" : \"book\",\"siteid\" : \"shh\",\"spaceid\" : \"101\",\"payload\" : {\"phone\" : \"+821012345678\",\"stayAfter\" : \"2019-09-01T07:12:00Z\", \"stayBefore\" : \"2019-09-03T02:00:00Z\", \"email\" : \"guest@example.com\" }}}";
    private static String url = "https://api.onescape.io/istay/stayguardian/smartlink";
    public static void main(String[] args) throws Exception {

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);

        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("X-Api-Key", "r3U2uv1f80aMoLiNI20oPaxfbDGDUaAx3onO7XGz");

        ReqVO reqVO = new ReqVO();

        reqVO.setCmd("cmd-event");
        reqVO.setStatus("book");
        reqVO.setSiteid("shh");
        reqVO.setSpaceid("101");

        Payload payload = new Payload();

        payload.setPhone("+821012345678");
        payload.setStayAfter("2019-09-01T07:12:00Z");
        payload.setStayBefore("2019-09-03T02:00:00Z");
        payload.setEmail("guest@example.com");

        reqVO.setPayload(payload);

        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonString = mapper.writeValueAsString(reqVO);

        System.out.println(jsonString);

        StringEntity stringEntity = new StringEntity(jsonString);
        httpPost.getRequestLine();
        httpPost.setEntity(stringEntity);

        HttpResponse response = httpClient.execute(httpPost);

        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");

        Arrays.stream(response.getAllHeaders()).forEach(value -> {
            System.out.println(value.toString());
        });

        System.out.println(responseString);
    }
}

class Payload {
    private String phone;
    private String stayAfter;
    private String stayBefore;
    private String email;
    private String name;
    private String firstName;
    private String middleName;
    private String lastName;
    private String title;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStayAfter() {
        return stayAfter;
    }

    public void setStayAfter(String stayAfter) {
        this.stayAfter = stayAfter;
    }

    public String getStayBefore() {
        return stayBefore;
    }

    public void setStayBefore(String stayBefore) {
        this.stayBefore = stayBefore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class ReqVO {
    private String cmd;
    private String status;
    private String siteid;
    private String spaceid;
    private Payload payload;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getSpaceid() {
        return spaceid;
    }

    public void setSpaceid(String spaceid) {
        this.spaceid = spaceid;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
