package com.example.my_diary_project.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse {

    private HttpStatus status;
    private int statusCode;
    private BaseProxy[] content;
    private int contentSize;

    private CustomResponse(HttpStatus httpStatus, int statusCode, Object content, int contentSize) {
        this.status = httpStatus;
        this.statusCode = statusCode;
        if (content instanceof  List) {
            this.content = (BaseProxy[]) ((List<?>) content).toArray(Object[]::new);
        } else {
            BaseProxy[] baseProxies = new BaseProxy[1];
            baseProxies[0] = (BaseProxy) content;
            this.content = baseProxies;
        }
        this.contentSize = contentSize;
    }

    public static CustomResponse get(List<? extends BaseProxy> content) {
        HttpStatus httpStatus = HttpStatus.OK;
        return new CustomResponse(httpStatus, httpStatus.value(),
            content.toArray(BaseProxy[]::new), content.size());
    }

    public static CustomResponse get(BaseProxy content) {
        HttpStatus httpStatus = HttpStatus.OK;
        return new CustomResponse(httpStatus, httpStatus.value(), content, 1);
    }

    public static CustomResponse post(BaseProxy content) {
        HttpStatus httpStatus = HttpStatus.CREATED;
        BaseProxy[] baseProxies = new BaseProxy[1];
        baseProxies[0] = content;
        return new CustomResponse(httpStatus, httpStatus.value(), baseProxies, 1);
    }

    public static CustomResponse patch(BaseProxy content) {
        HttpStatus httpStatus = HttpStatus.OK;
        return new CustomResponse(httpStatus, httpStatus.value(), content, 1);
    }

    public static CustomResponse delete() {
        HttpStatus httpStatus = HttpStatus.RESET_CONTENT;
        return new CustomResponse(httpStatus, httpStatus.value(), null, 1);
    }
}
