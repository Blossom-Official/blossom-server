package com.seoultech.blossom.external.client.auth.kakao;

import com.seoultech.blossom.external.client.auth.kakao.dto.response.KakaoProfileResponse;

public interface KakaoApiCaller {

	KakaoProfileResponse getProfileInfo(String accessToken);

}
