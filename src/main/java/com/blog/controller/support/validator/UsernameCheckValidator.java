package com.blog.controller.support.validator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.blog.controller.support.annotation.UsernameCheck;

/**
 * 验证用户实现类
 * 
 * @author sylar
 *
 */
public class UsernameCheckValidator implements ConstraintValidator<UsernameCheck, String> {

	private static final Pattern USERNAME_PATTERN = Pattern.compile("[a-zA-Z0-9_]{4,19}");
	private Set<String> USERNAME_FORBIDDEN_WORDS = new HashSet<String>();

	@Override
	public void initialize(UsernameCheck constraintAnnotation) {
		USERNAME_FORBIDDEN_WORDS.add("admin");
		USERNAME_FORBIDDEN_WORDS.add("fuck");
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		value = value.trim();
		if (value == null || value.isEmpty()) {
			return false;
		}
		if (!USERNAME_PATTERN.matcher(value).matches()) {
			return false;
		}
		for (String word : USERNAME_FORBIDDEN_WORDS) {
			if (value.contains(word)) {
				return false;
			}
		}
		return true;
	}

}
