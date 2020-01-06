package kr.revelope.example.spring.boot.actuator.message;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MessageHolder {
	private String message;

	public MessageHolder(
		@Value("${app.message}") String message
	) {
		this.message = message;
	}
}
