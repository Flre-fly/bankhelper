package back.helper2.controller;

import back.helper2.dto.AuthDTO;
import back.helper2.dto.ResponseAuthDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.json.simple.JSONObject; // JSON객체 생성
import org.json.simple.JSONArray; // JSON이 들어있는 Array 생성
import org.json.simple.parser.JSONParser; // JSON객체 파싱
import org.json.simple.parser.ParseException; // 예외처리
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.image.RescaleOp;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    RestTemplate restTemplate  = new RestTemplate();

    @PostMapping("/")
    public ResponseEntity<String> firstAuth(@RequestBody AuthDTO auth){
        final HttpHeaders headers = new HttpHeaders();
        headers.clear();
        headers.add("Connection", "keep-alive");
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
        headers.add("Host", "<calculated when request is sent>");
        headers.add("Accept-Encoding", "gzip, deflate, br");
        //Map<String, String> params = new HashMap<String, String>();
        JSONObject params = new JSONObject();
        params.clear();
        String authUrl = "https://testapi.openbanking.or.kr/oauth/2.0/authorize";
        URI targetUrl= UriComponentsBuilder.fromUriString(authUrl)  // Build the base link
                .queryParam("response_type", auth.getResponse_type())                                // Add one or more query params
                .queryParam("client_id", auth.getClient_id())
                .queryParam("redirect_uri", auth.getRedirect_uri())
                .queryParam("scope", auth.getScope())
                .queryParam("state", auth.getState())
                .queryParam("auth_type", auth.getAuth_type())
                .build()                                                 // Build the URL
                .encode()                                                // Encode any URI items that need to be encoded
                .toUri();

        params.put("response_type", auth.getResponse_type());
        params.put("client_id", auth.getClient_id());
        params.put("redirect_uri", auth.getRedirect_uri());
        params.put("scope", auth.getScope());
        params.put("state", auth.getState());
        params.put("auth_type", auth.getAuth_type());

        System.out.println(targetUrl);
        final HttpEntity entity = new HttpEntity(headers);

        return restTemplate.exchange(targetUrl, HttpMethod.GET, entity, String.class);

    }

}
