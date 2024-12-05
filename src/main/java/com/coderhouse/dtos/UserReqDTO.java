package com.coderhouse.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserReqDTO {

	private String name;
	private String email;
	private Long role;

}
