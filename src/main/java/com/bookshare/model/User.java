package com.bookshare.model;

import java.util.Objects;

public class User {

  public String email;
  public String password;
  public String confirmPassword;

  public String getEmail() {
    return email;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public User setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
    return this;
  }

}
