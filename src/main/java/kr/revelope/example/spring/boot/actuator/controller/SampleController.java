package kr.revelope.example.spring.boot.actuator.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import kr.revelope.example.spring.boot.actuator.message.MessageHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {
	private final MessageHolder messageHolder;
	private final Counter counter;

	public SampleController(
		MeterRegistry meterRegistry,
		MessageHolder messageHolder
	) {
		this.messageHolder = messageHolder;
		this.counter = meterRegistry.counter("message.call.count");
	}

	@GetMapping("/message")
	public String getMessage() {
		counter.increment();
		log.debug("message call : {}", counter.count());

		return messageHolder.getMessage();
	}
}
