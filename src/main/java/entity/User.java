package entity;

import lombok.Getter;
import lombok.Setter;

public class User {

	@Getter
	@Setter
	private Long id;
	private String userName;
	private String password;

}
