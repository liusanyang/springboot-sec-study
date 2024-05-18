package com.example.study;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoControllerTest {

	@Value("${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testEndpoint() {
		String url = "http://localhost:" + port + "/api/test";
		String response = restTemplate.getForObject(url, String.class);
		assertEquals("Test Endpoint", response);
	}

	@Test
	public void testPrintGetRequestURI() {
		// You can customize the URL with query parameters as needed
		String url = "http://localhost:" + port + "/api/printGetRequestURI?param1=value1&param2=value2";

		// Make a GET request
		String response = restTemplate.getForObject(url, String.class);

		// Verify the response, you can customize based on your actual implementation
		assertEquals("Printed GET Request URI. Check console for details.", response);
	}
}
