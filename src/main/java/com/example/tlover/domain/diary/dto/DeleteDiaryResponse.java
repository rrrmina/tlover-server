package com.example.tlover.domain.diary.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "다이어리 삭제를 위한 응답 객체")
public class DeleteDiaryResponse {

    private String message;
}

