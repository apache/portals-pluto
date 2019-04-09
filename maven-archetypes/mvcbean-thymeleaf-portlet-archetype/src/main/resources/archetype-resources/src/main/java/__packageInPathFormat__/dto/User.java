package ${package}.dto;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.FormParam;
import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1747238523552345552L;

	@Inject
	@FormParam("firstName")
	@NotBlank
	private String firstName;

	@Inject
	@FormParam("lastName")
	@NotBlank
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}