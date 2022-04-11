package com.example.tlover.global.sms.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "네이버에서 원하는 정보(메시지)를 담기 위한 객체")
public class MessageModel {
    private String to;
    private String content;
}