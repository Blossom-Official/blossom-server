package com.seoultech.blossom.domain.domain.user.repository;

import com.seoultech.blossom.domain.domain.user.User;
import com.seoultech.blossom.domain.domain.user.UserSocialType;

public interface UserRepositoryCustom {

	boolean existsBySocialIdAndSocialType(String socialId, UserSocialType socialType);

	User findUserById(Long id);

	User findUserBySocialIdAndSocialType(String socialId, UserSocialType socialType);
}
