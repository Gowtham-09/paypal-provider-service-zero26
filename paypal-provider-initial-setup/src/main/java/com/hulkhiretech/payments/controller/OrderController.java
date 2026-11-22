package com.hulkhiretech.payments.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.hulkhiretech.payments.pojo.CreateOrderReq;
import com.hulkhiretech.payments.pojo.OrderRes;
import com.hulkhiretech.payments.service.interfaces.OrderService;

@RestController
@Slf4j
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;
	
	@PostMapping
	public ResponseEntity<OrderRes> createOrder(@RequestBody CreateOrderReq createOrderReq) {
		log.info("createOrder called (controller) - delegating to service with createOrderReq",createOrderReq);
		OrderRes response = orderService.createOrder(createOrderReq);
		log.info("createOrder response = {}", response);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PostMapping("/{orderId}/capture")
	public ResponseEntity<OrderRes> captureOrder(@PathVariable String orderId) {
		log.info("captureOrder called with providerReference: {}", orderId);
		OrderRes response = orderService.captureOrder(orderId);
		log.info("captureOrder response = {}", response);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
