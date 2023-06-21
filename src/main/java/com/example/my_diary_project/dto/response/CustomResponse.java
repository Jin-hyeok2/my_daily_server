package com.example.my_diary_project.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Setter
@Getter
public class CustomResponse<T> extends ResponseEntity<T> {

  private String message;
  private T data;

  private CustomResponse(HttpStatus status) {
    super(status);
  }

  private CustomResponse(HttpStatus status, String message, T data) {
    super(status);
    this.message = message;
    this.data = data;
  }

  public static <T> CustomResponse<T> get(String message, T data) {
    return new CustomResponse<>(HttpStatus.OK, message, data);
  }

  public static <T> CustomResponse<T> post(String message, T data) {
    return new CustomResponse<>(HttpStatus.CREATED, message, data);
  }

  public static <T> CustomResponse<T> patch(String message, T data) {
    return new CustomResponse<>(HttpStatus.OK, message, data);
  }

  public static <T> CustomResponse<T> delete() {
    return new CustomResponse<>(HttpStatus.RESET_CONTENT);
  }
}
