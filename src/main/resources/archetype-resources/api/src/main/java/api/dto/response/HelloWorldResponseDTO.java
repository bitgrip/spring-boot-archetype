package ${package}.api.dto.response;

import java.util.UUID;

public class HelloWorldResponseDTO {

	private UUID id;

	private String message;

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id=id;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message=message;
	}

}
