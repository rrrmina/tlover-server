package com.example.tlover.domain.authority_plan.service;

import com.example.tlover.domain.authority_plan.dto.AuthorityPlanListResponse;
import com.example.tlover.domain.authority_plan.dto.SharePlanRequest;
import com.example.tlover.domain.authority_plan.entity.AuthorityPlan;
import com.example.tlover.domain.authority_plan.repository.AuthorityPlanRepository;
import com.example.tlover.domain.plan.entity.Plan;
import com.example.tlover.domain.plan.repository.PlanRepository;
import com.example.tlover.domain.plan.service.PlanService;
import com.example.tlover.domain.plan.service.PlanServiceImpl;
import com.example.tlover.domain.user.entity.User;
import com.example.tlover.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorityPlanServiceImpl implements AuthorityPlanService{
    private final PlanRepository planRepository;
    private final UserRepository userRepository;
    private final AuthorityPlanRepository authorityPlanRepository;

    //공유 요청
    @Override
    public void sharePlan(Long planId, SharePlanRequest sharePlanRequest) {
        Plan plan = planRepository.findByPlanId(planId).get();
        User user = userRepository.findByUserNickName(sharePlanRequest.getUserNickName());
        AuthorityPlan authorityPlan = AuthorityPlan.toEntity(plan, user,"REQUEST");
        authorityPlanRepository.save(authorityPlan);
    }

    //원글쓴이 권한 저장
    @Override
    public void addPlanUser(Plan plan, String loginId) {
        User user = userRepository.findByUserLoginId(loginId).get();
        AuthorityPlan authorityPlan = AuthorityPlan.toEntity(plan, user, "HOST");
        authorityPlanRepository.save(authorityPlan);
    }

    @Override
    @Transactional
    public void deleteAuthorityPlan(Plan plan) {
        authorityPlanRepository.deleteAllByPlan(plan);
    }

    @Override
    public List<AuthorityPlanListResponse> getSharePlanList(String loginId) {
        User user = userRepository.findByUserLoginId(loginId).get();
        List<AuthorityPlan> authorityPlans = authorityPlanRepository.findAllByUser(user).get();
        authorityPlans = checkStatus(authorityPlans,"REQUEST");
        List<AuthorityPlanListResponse> authorityPlanList = new ArrayList<>();
         // 빈경우 어케 처리?
        for(int i=0; i<authorityPlans.size(); i++)
            authorityPlanList.add(AuthorityPlanListResponse.from(authorityPlans.get(i)));
        return authorityPlanList;
    }

    public static List<AuthorityPlan> checkStatus(List<AuthorityPlan> authorityPlans, String status) {
        for(int i=0; i<authorityPlans.size(); i++) {
            if (!authorityPlans.get(i).getAuthorityPlanStatus().equals(status)) {
                authorityPlans.remove(i);
            }
        }
        return authorityPlans;
    }

    @Override
    @Transactional
    public void updateAcceptAuthorityPlan(Long authorityPlanId) {
        AuthorityPlan authorityPlan = authorityPlanRepository.findByAuthorityPlanId(authorityPlanId).get();
        authorityPlan.setAuthorityPlanStatus("ACCEPT");
    }

    @Override
    @Transactional
    public void updateRejectAuthorityPlan(Long authorityPlanId) {
        AuthorityPlan authorityPlan = authorityPlanRepository.findByAuthorityPlanId(authorityPlanId).get();
        authorityPlan.setAuthorityPlanStatus("REJECT");
    }

}
