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
public class UpdatedBookDto {
  private Integer bookId;
  private String title;
  private String author;
  private String description;
  private Integer categoryId;
  private Integer languageId;
  private Integer pages;
  private String publisherDate;
  private String cover;
  private Integer owner;
  private String location;
  private String queueSize;

}


