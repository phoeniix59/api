package com.project.api;

import com.project.api.search.RequestFactory;
import com.project.api.search.freemarker.FreeMarkerTemplateReader;
import com.project.api.search.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@SpringBootApplication
public class ApiApplication {

	@Value("${elastic.url}")
	public String elasticUrl;

	@Autowired
	private FreeMarkerTemplateReader freeMarkerTemplateReader;

	@Autowired
	private RequestFactory requestFactory;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@PostConstruct
	private void init() {
		URI uri = fromHttpUrl(elasticUrl)
				.path("/_bulk")
				.build()
				.encode()
				.toUri();

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Content-Type", "application/x-ndjson");

		Map<String, Object> params = new HashMap<>();
		String queryBody = freeMarkerTemplateReader.readTemplate("bulk.json", params);

		HttpEntity<String> requestEntity = new HttpEntity<>(queryBody, requestHeaders);
		requestFactory.getRestTemplate().exchange(uri, HttpMethod.POST, requestEntity, Response.class);
	}
}
