package com.seoultech.blossom.api.service.image.provider.dto.request;

import com.seoultech.blossom.common.type.FileType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageUploadFileRequest implements UploadFileRequest {

	private FileType type;

	public static ImageUploadFileRequest of(FileType type) {
		return new ImageUploadFileRequest(type);
	}

	@Override
	public String getFileNameWithBucketDirectory(String originalFileName) {
		return type.createUniqueFileNameWithExtension(originalFileName);
	}
}
