package com.seoultech.blossom.domain.domain.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.seoultech.blossom.domain.domain.common.BaseEntity;
import com.seoultech.blossom.domain.domain.flower.FlowerLike;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "USER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long id;

	@Embedded
	private SocialInfo socialInfo;

	@Column(name = "NICKNAME", nullable = false, length = 30)
	private String nickname;

	@Column(name = "PROFILE_IMAGE_URL", nullable = true, length = 300)
	private String profileImageUrl;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<FlowerLike> flowerLikes = new ArrayList<>();

	public static User newInstance(String socialId, UserSocialType socialType) {
		return User.builder()
			.socialInfo(SocialInfo.of(socialId, socialType))
			.nickname("")
			.profileImageUrl(null)
			.build();
	}
}
