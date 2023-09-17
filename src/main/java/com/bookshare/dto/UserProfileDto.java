package com.bookshare.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserProfileDto {
    private Long id;
    private String email;
    private String role;
    private String state;
    private String firstName;
    private String lastName;
    private String city;
    private String postalCode;
    private Boolean agreement;

}
