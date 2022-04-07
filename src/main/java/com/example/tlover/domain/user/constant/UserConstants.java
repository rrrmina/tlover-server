package com.example.tlover.domain.user.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserConstants {

    @Getter
    @AllArgsConstructor
    public enum EOAuth2UserServiceImpl {

        eBearer("Bearer "),
        eAuthorization("Authorization"),
        eGetMethod("GET"),
        eResponse("response"),
        eNameAttribute("name"),
        eGoogleIdToken("id_token"),
        eEmailAttribute("email"),
        eNaverProfileImageAttribute("profile_image"),
        eGoogleProfileImageAttribute("picture"),
<<<<<<< HEAD
=======
        eKakaoProfileImageAttribute("profile_image"),
        eKakaoProperties("properties"),
        eKakaoAcount("kakao_account"),

        eNaverApiResponseException("NAVER API 응답을 읽는데 실패했습니다."),
        eNaverAuthenticationFailedException("Naver 인증에 실패했습니다."),
        eNaverPermissionException("Naver API 호출 권한이 없습니다."),
        eNotFoundException("Naver API 검색 결과가 없습니다."),
        eNaverApiUrlException("NAVER API URL이 잘못되었습니다. : "),
        eNaverConnectionException("NAVER와의 연결이 실패했습니다. : "),
        eKakaoLoginFailException("Kakao 로그인에 실패했습니다."),
>>>>>>> 167628786061ef759e2498d7a972b53fa67c3401
        eGoogleTokenInvalid("잘못된 토큰입니다.");
        private final String value;
    }

    @Getter
    @AllArgsConstructor
    public enum ESocialProvider{
        eGoogle,
        eNaver,
        eKakao,
        eApp;
    }

    @Getter
    @AllArgsConstructor
    public enum ENaverExceptionMessage {
        eNaverApiResponseExceptionMessage("NAVER API 응답을 읽는데 실패했습니다."),
        eNaverAuthenticationFailedExceptionMessage("Naver 인증에 실패했습니다."),
        eNaverPermissionExceptionMessage("Naver API 호출 권한이 없습니다."),
        eNaverNotFoundExceptionMessage("Naver API 검색 결과가 없습니다."),
        eNaverApiUrlExceptionMessage("NAVER API URL이 잘못되었습니다. : "),
        eNaverConnectionExceptionMessage("NAVER와의 연결이 실패했습니다. : ");
        private final String value;
    }
}
