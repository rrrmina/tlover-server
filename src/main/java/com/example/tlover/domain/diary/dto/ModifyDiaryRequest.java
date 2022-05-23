package com.example.tlover.domain.diary.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "다이어리 수정을 위한 요청 객체")
public class ModifyDiaryRequest {

    @NotBlank(message = "다이어리 고유 번호를 입력해주세요.")
    @ApiModelProperty(notes = "다이어리 키 값을 입력해주세요.")
    private Long diaryId;

    @NotBlank(message = "제목을 입력해주세요.")
    @ApiModelProperty(notes = "다이어리의 제목을 입력해 주세요.")
    private String diaryTitle;

    @ApiModelProperty(notes = "여행시에 찍었던 사진들")
    private List<MultipartFile> diaryImages;

    @NotNull(message = "여행 시작 날짜를 입력해주세요.")
    @ApiModelProperty(notes = "여행 시작 날짜를 입력해 주세요.")
    @DateTimeFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private LocalDateTime diaryStartDate;

    @NotNull(message = "여행 마지막 날짜를 입력해주세요.")
    @ApiModelProperty(notes = "여행 마지막 날짜를 입력해 주세요.")
    @DateTimeFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private LocalDateTime diaryEndDate;

    @NotNull(message = "여행 지역을 입력해주세요.")
    @ApiModelProperty(notes = "여행 지역을  입력해 주세요.")
    private String regionNameDetail;

    @NotNull
    @ApiModelProperty(notes = "여행 테마를 입력해주세요.")
    private String[] themaName;



    @ApiModelProperty(notes = "여행의 총경비를 입력해주세요.")
    private int totalCost;



    @ApiModelProperty(notes = "여행 내용을 입력해 주세요.")
    @NotBlank(message = "여행 내용을 입력해주세요.")
    private String diaryContext;

    @Min(value = 1 , message = "1이상의 수를 입력해주세요.")
    @ApiModelProperty(notes = "몇일차인지 입력해주세요")
    private int diaryDay;


}
