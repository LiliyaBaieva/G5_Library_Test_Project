package com.bookshare.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
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
