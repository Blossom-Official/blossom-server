package com.seoultech.blossom.external.client.auth.kakao;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.seoultech.blossom.common.exception.BadGatewayException;
import com.seoultech.blossom.common.exception.ValidationException;
import com.seoultech.blossom.external.client.auth.kakao.dto.response.KakaoProfileResponse;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class WebClientKakaoCaller implements KakaoApiCaller {

	private final WebClient webClient;

	@Override
	public KakaoProfileResponse getProfileInfo(String accessToken) {
		return webClient.get()
			.uri("https://kapi.kakao.com/v2/user/me")
			.headers(headers -> headers.setBearerAuth(accessToken))
			.retrieve()
			.onStatus(HttpStatus::is4xxClientError, clientResponse ->
				Mono.error(new ValidationException(String.format("잘못된 카카오 액세스 토큰 (%s) 입니다.", accessToken))))
			.onStatus(HttpStatus::is5xxServerError, clientResponse ->
				Mono.error(new BadGatewayException("카카오 로그인 연동 중 에러가 발생하였습니다.")))
			.bodyToMono(KakaoProfileResponse.class)
			.block();
	}

}
