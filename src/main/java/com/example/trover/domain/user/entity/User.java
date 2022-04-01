package com.example.trover.domain.user.entity;

import com.example.trover.domain.annonce.entity.Annonce;
import com.example.trover.domain.authority_annonce.entity.AuthorityAnnonce;
import com.example.trover.domain.authority_plan.entity.AuthorityPlan;
import com.example.trover.domain.emotion.entity.Emotion;
import com.example.trover.domain.plan.entity.Plan;
import com.example.trover.domain.reply.entity.Reply;
import com.example.trover.domain.report.entity.Report;
import com.example.trover.domain.scrap.entity.Scrap;
import com.example.trover.domain.user_refreshtoken.entity.UserRefreshToken;
import com.example.trover.domain.user_region.entity.UserRegion;
import com.example.trover.domain.user_thema.entitiy.UserThema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long userId;

    private String userLoginId;

    private String userPassword;

    private String userGender;

    private String userAge;

    private String userProfileImg;

    private String userRating;

    private String userPhoneNum;

    private String userState;

    private String userRealName;

    private String userNickName;

    /**
     * 새로 추가한 콜럼입니다.
     */

    private String user_socialProvider;

    @OneToMany(mappedBy = "user")
    private List<Annonce> annonces = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Plan> plans = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Scrap> scraps = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Emotion> emotions = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Report> reports = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserRefreshToken> userRefreshTokens = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserRegion> userRegions = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserThema> userThemas = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<AuthorityAnnonce> authorityAnnonces = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<AuthorityPlan> authorityPlans = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Reply> replies = new ArrayList<>();


    /**
     * 연관관계 메서드
     */

    public void addAnnonce(Annonce annonce) {
        this.annonces.add(annonce);
        annonce.setUser(this);
    }

    public void addPlan(Plan plan) {
        this.plans.add(plan);
        plan.setUser(this);
    }

    public void addScrap(Scrap scrap) {
        this.scraps.add(scrap);
        scrap.setUser(this);
    }

    public void addEmotion(Emotion emotion) {
        this.emotions.add(emotion);
        emotion.setUser(this);
    }

    public void addReport(Report report) {
        this.reports.add(report);
        report.setUser(this);
    }

}
