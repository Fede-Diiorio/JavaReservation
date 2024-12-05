package com.coderhouse.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResDTO {

	private Long userId;
	private String userName;
	private String userEmail;
	private String userLevel;
}
