package com.example.tlover.domain.user_region.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "사용자 관심지역 수정을 위한 응답 객체")
public class UpdateUserRegionResponse {

    String message;
}
