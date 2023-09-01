package com.seoultech.blossom.api.config.convert;

import static com.seoultech.blossom.common.exception.ErrorCode.*;

import com.seoultech.blossom.common.exception.ValidationException;
import com.seoultech.blossom.domain.domain.flower.FlowerCategory;
import org.springframework.core.convert.converter.Converter;

public class FlowerCategoryConverter implements Converter<String, FlowerCategory> {
	@Override
	public FlowerCategory convert(String source) {
		try {
			return FlowerCategory.valueOf(source.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new ValidationException("잘못된 Enum 형태입니다.", VALIDATION_EXCEPTION);
		}
	}
}
