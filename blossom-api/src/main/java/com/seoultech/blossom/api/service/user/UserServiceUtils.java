package com.seoultech.blossom.api.service.user;

import static com.seoultech.blossom.common.exception.ErrorCode.*;

import java.util.List;

import com.seoultech.blossom.common.exception.ConflictException;
import com.seoultech.blossom.common.exception.NotFoundException;
import com.seoultech.blossom.domain.domain.user.DefaultProfileImage;
import com.seoultech.blossom.domain.domain.user.User;
import com.seoultech.blossom.domain.domain.user.UserSocialType;
import com.seoultech.blossom.domain.domain.user.repository.UserRepository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserServiceUtils {

	static void validateNotExistsUser(UserRepository userRepository, String socialId, UserSocialType socialType) {
		if (userRepository.existsBySocialIdAndSocialType(socialId, socialType)) {
			throw new ConflictException(String.format("이미 존재하는 유저 (%s - %s) 입니다", socialId, socialType),
				CONFLICT_USER_EXCEPTION);
		}
	}

	public static User findUserBySocialIdAndSocialType(UserRepository userRepository, String socialId,
		UserSocialType socialType) {
		User user = userRepository.findUserBySocialIdAndSocialType(socialId, socialType);
		if (user == null) {
			throw new NotFoundException(String.format("존재하지 않는 유저 (%s) (%s) 입니다", socialType, socialId),
				NOT_FOUND_USER_EXCEPTION);
		}
		return user;
	}

	public static User findUserById(UserRepository userRepository, Long userId) {
		User user = userRepository.findUserById(userId);
		if (user == null) {
			throw new NotFoundException(String.format("존재하지 않는 유저 (%s) 입니다", userId), NOT_FOUND_USER_EXCEPTION);
		}
		return user;
	}

	public static void validateDeleteProfileImageRequest(User user) {
		if (isDefaultProfileImage(user.getProfileImageUrl())) {
			throw new ConflictException(
				String.format("이미 기본이미지 (%s) 로 설정된 유저 (%s) 입니다.", user.getProfileImageUrl(), user.getId()),
				CONFLICT_DELETE_PROFILE_IMAGE_EXCEPTION);
		}
	}

	public static boolean isDefaultProfileImage(String imageUrl) {
		List<String> defaultProfileImageUrls = DefaultProfileImage.getUrlList();
		return defaultProfileImageUrls.contains(imageUrl);
	}
}
