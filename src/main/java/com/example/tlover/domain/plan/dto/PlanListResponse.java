package com.example.tlover.domain.plan.dto;

import com.example.tlover.domain.plan.entity.Plan;
import com.example.tlover.domain.plan_region.entity.PlanRegion;
import com.example.tlover.domain.user.dto.ProfileResponse;
import com.example.tlover.domain.user.entity.User;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "여행 계획 목록 조회를 위한 응답 객체")
public class PlanListResponse {
    private Long planId;
    private String planTitle;
    private String planStatus;
    private String planStartDate;
    private String planEndDate;
    private Long day;
    private String[] regionName;
    private Long expense;

    @QueryProjection
    public PlanListResponse(Long planId, String planTitle, String planStartDate
            ,String planEndDate,  Long day, String[] regionName, Long expense){
        this.planId = planId;
        this.planTitle = planTitle;
        this.planStartDate = planStartDate;
        this.planEndDate = planEndDate;
        this.day = day;
        this.regionName = regionName;
        this.expense = expense;
    }

   public static PlanListResponse from(Plan plan, List<PlanRegion> planRegions) {
       String[] regionName = new String[planRegions.size()];
       for(int i=0; i< regionName.length; i++){
           regionName[i] = planRegions.get(i).getRegion().getRegionName();
       }
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       long period = ChronoUnit.DAYS.between(LocalDateTime.parse(plan.getPlanStartDate(),formatter).toLocalDate(), LocalDateTime.parse(plan.getPlanEndDate(),formatter).toLocalDate())+1;
       long day = ChronoUnit.DAYS.between(LocalDateTime.parse(plan.getPlanStartDate(),formatter).toLocalDate(), LocalDate.now())+1;
       if(period-day<0||day<0){
           day = -1;
       }

        return PlanListResponse.builder()
                .planId(plan.getPlanId())
                .planTitle(plan.getPlanTitle())
                .planStatus(plan.getPlanStatus())
                .planStartDate(plan.getPlanStartDate())
                .planEndDate(plan.getPlanEndDate())
                .expense(plan.getExpense())
                .day(day)
                .regionName(regionName)
                .build();
    }
}
