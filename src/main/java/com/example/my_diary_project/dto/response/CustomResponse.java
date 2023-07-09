package com.example.my_diary_project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse{
  private HttpStatus status;
  private int statusCode;
  private String message;
  private BaseProxy data;

  public static CustomResponse get(String message, BaseProxy data) {
    HttpStatus httpStatus = HttpStatus.OK;
    return new CustomResponse(httpStatus, httpStatus.value(), message, data);
  }

  public static CustomResponse post(String message, BaseProxy data) {
    HttpStatus httpStatus = HttpStatus.CREATED;
    return new CustomResponse(httpStatus, httpStatus.value(), message, data);
  }

  public static CustomResponse patch(String message, BaseProxy data) {
    HttpStatus httpStatus = HttpStatus.OK;
    return new CustomResponse(httpStatus, httpStatus.value(), message, data);
  }

  public static CustomResponse delete(String message) {
    HttpStatus httpStatus = HttpStatus.RESET_CONTENT;
    return new CustomResponse(httpStatus, httpStatus.value(), message, null);
  }
}
