package com.seoultech.blossom.api.service.user;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.seoultech.blossom.api.service.image.provider.S3Provider;
import com.seoultech.blossom.api.service.image.provider.dto.request.ImageUploadFileRequest;
import com.seoultech.blossom.api.service.user.dto.request.CreateUserRequestDto;
import com.seoultech.blossom.api.service.user.dto.request.UpdateNicknameRequest;
import com.seoultech.blossom.common.constant.ProfileType;
import com.seoultech.blossom.common.type.FileType;
import com.seoultech.blossom.domain.domain.user.DefaultProfileImage;
import com.seoultech.blossom.domain.domain.user.User;
import com.seoultech.blossom.domain.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;
	private final S3Provider s3Provider;

	@Value(value = "${spring.profiles.active}")
	private String profile;

	public Long registerUser(CreateUserRequestDto request) {
		UserServiceUtils.validateNotExistsUser(userRepository, request.getSocialId(), request.getSocialType());
		User user = userRepository.save(
			User.newInstance(request.getSocialId(), request.getSocialType(), getRandomDefaultProfileImage()));
		return user.getId();
	}

	public void updateProfileImage(MultipartFile image, Long userId) {
		User user = UserServiceUtils.findUserById(userRepository, userId);
		if (image != null) {
			if (!UserServiceUtils.isDefaultProfileImage(user.getProfileImageUrl())) {
				s3Provider.deleteFile(user.getProfileImageUrl());
			}
			String uploadImageUrl = s3Provider.uploadFile(ImageUploadFileRequest.of(FileType.PROFILE_IMAGE), image);
			user.updateProfileImageUrl(uploadImageUrl);
		}
	}

	public void deleteProfileImage(Long userId) {
		User user = UserServiceUtils.findUserById(userRepository, userId);
		UserServiceUtils.validateDeleteProfileImageRequest(user);
		s3Provider.deleteFile(user.getProfileImageUrl());
		user.updateProfileImageUrl(getRandomDefaultProfileImage());
	}

	public void updateNickname(UpdateNicknameRequest request, Long userId) {
		User user = UserServiceUtils.findUserById(userRepository, userId);
		user.updateNickname(request.getNickname());
	}

	private String getRandomDefaultProfileImage() {
		List<DefaultProfileImage> defaultProfileImages = DefaultProfileImage.getList();
		int randomNumber = new Random().nextInt(defaultProfileImages.size());
		DefaultProfileImage defaultProfileImage = defaultProfileImages.get(randomNumber);
		if (profile.equals(ProfileType.PROD)) {
			return defaultProfileImage.getProdImageUrl();
		}
		return defaultProfileImage.getDevImageUrl();
	}
}
