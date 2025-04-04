package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

@Builder
@Getter @Setter
public class ResponseDto {
    private HttpStatus status;
    private Object message;
}
