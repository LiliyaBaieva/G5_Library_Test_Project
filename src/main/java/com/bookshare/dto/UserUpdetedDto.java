package com.bookshare.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserUpdetedDto {

  private String firstName;
  private String lastName;
  private String postalCode;

}
