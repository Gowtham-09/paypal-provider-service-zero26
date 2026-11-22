package com.hulkhiretech.payments.service.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hulkhiretech.payments.http.HttpRequest;
import com.hulkhiretech.payments.http.HttpServiceEngine;
import com.hulkhiretech.payments.service.TokenService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaypalClient {
	
	private final TokenService tokenService;
	private final HttpServiceEngine httpServiceEngine;
	
	public ResponseEntity<String> makeCall(HttpRequest httpRequest) {
		log.info("PaypalClient.makeCall called with httpRequest: {}",httpRequest);
		
		// Get access token from TokenService
		String accessToken = tokenService.getAccessToken();
		
		HttpHeaders headers = httpRequest.getHttpHeaders();
		if(headers == null) {
			headers = new HttpHeaders();
			httpRequest.setHttpHeaders(headers);
		}
		headers.setBearerAuth(accessToken);
		
		// Make Http call using HttpServiceEngine
		ResponseEntity<String> httpResponse = httpServiceEngine.makeHttpCall(httpRequest);
		log.info("HttpServiceEngine.makeHttpCall response: {}", httpResponse);
		return httpResponse;
	}
}
