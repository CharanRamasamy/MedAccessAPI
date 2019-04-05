/*

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.MedAccess.Models.Patient;

public class RESTPatientClient {

    public void getArticleByIdDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/MedAccess/patient/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Patient> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Patient.class, 1);
        Patient article = responseEntity.getBody();
        System.out.println("Id:"+article.getPatient_firstname());
    }

    public static void main(String args[]) {
        RESTPatientClient util = new RESTPatientClient();
        //util.getArticleByIdDemo();
        //util.addArticleDemo();
        //util.updateArticleDemo();
        //util.deleteArticleDemo();
        util.getArticleByIdDemo();
    }
}
*/
