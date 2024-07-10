package com.intrabucks.login;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AccountCredentials {
	private String email;
	private String password;
}
