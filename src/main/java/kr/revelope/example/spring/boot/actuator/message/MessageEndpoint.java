package kr.revelope.example.spring.boot.actuator.message;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "message")
public class MessageEndpoint {
	private final MessageHolder messageHolder;

	public MessageEndpoint(MessageHolder messageHolder) {
		this.messageHolder = messageHolder;
	}

	@ReadOperation
	public String getMessage() {
		return messageHolder.getMessage();
	}

	@WriteOperation
	public String setMessage(String message) {
		messageHolder.setMessage(message);
		return messageHolder.getMessage();
	}
}
