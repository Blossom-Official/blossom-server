package com.seoultech.blossom.api.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.seoultech.blossom.api.service.image.provider.S3Provider;
import com.seoultech.blossom.api.service.image.provider.dto.request.ImageUploadFileRequest;
import com.seoultech.blossom.api.service.user.dto.request.CreateUserRequestDto;
import com.seoultech.blossom.common.type.FileType;
import com.seoultech.blossom.domain.domain.user.User;
import com.seoultech.blossom.domain.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;
	private final S3Provider s3Provider;

	public Long registerUser(CreateUserRequestDto request) {
		UserServiceUtils.validateNotExistsUser(userRepository, request.getSocialId(), request.getSocialType());
		User user = userRepository.save(User.newInstance(request.getSocialId(), request.getSocialType()));
		return user.getId();
	}

	public void updateProfileImage(MultipartFile image, Long userId) {
		User user = UserServiceUtils.findUserById(userRepository, userId);
		if (image != null) {
			s3Provider.deleteFile(user.getProfileImageUrl());
			String uploadImageUrl = s3Provider.uploadFile(ImageUploadFileRequest.of(FileType.PROFILE_IMAGE), image);
			user.updateProfileImageUrl(uploadImageUrl);
		}
	}
}
