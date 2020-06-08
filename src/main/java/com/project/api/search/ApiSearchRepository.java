package com.project.api.search;

import com.project.api.search.exception.InternalServerException;
import com.project.api.search.freemarker.FreeMarkerTemplateReader;
import com.project.api.search.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@Repository
public class ApiSearchRepository {

    public String elasticUrl;

    private RestTemplate restTemplate;

    private FreeMarkerTemplateReader freeMarkerTemplateReader;

    @Autowired
    public ApiSearchRepository(RequestFactory requestFactory, FreeMarkerTemplateReader freeMarkerTemplateReader, @Value("${elastic.url}") String elasticUrl) {
        this.restTemplate = requestFactory.getRestTemplate();
        this.freeMarkerTemplateReader = freeMarkerTemplateReader;
        this.elasticUrl = elasticUrl;
    }

    public Response findByKeyword(String keyword) throws InternalServerException {

        HttpHeaders requestHeaders = buildHeader();

        URI uri = fromHttpUrl(elasticUrl).path("api/_search")
                .build()
                .encode()
                .toUri();

        String queryBody = buildESRequest(keyword);

        HttpEntity<String> requestEntity = new HttpEntity<>(queryBody, requestHeaders);

        try{
            return restTemplate.exchange(uri, POST, requestEntity, Response.class).getBody();
        } catch (HttpClientErrorException e){
            throw new InternalServerException("index or alias not found");
        }
    }

    private HttpHeaders buildHeader() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);

        return requestHeaders;
    }

    private String buildESRequest(String keyword) {
        Map<String, Object> params = Map.of(
                "keywords", keyword);

        return freeMarkerTemplateReader.readTemplate("search-property.json", params);
    }
}
