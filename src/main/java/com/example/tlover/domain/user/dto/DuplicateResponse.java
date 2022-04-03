package com.example.tlover.domain.user.dto;



import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "아이디 중복 확인을 위한 응답 객체")
public class DuplicateResponse {

    private String message;

}