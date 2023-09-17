package com.bookshare.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class RegistrationUserDto {

  private String email;
  private String password;
  private String confirmPassword;

}
