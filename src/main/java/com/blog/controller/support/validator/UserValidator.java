package com.blog.controller.support.validator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.blog.model.User;

/**
 * User validator
 * 
 * @author sylar
 *
 */
@Deprecated
public class UserValidator implements Validator {

	private static final Pattern USERNAME_PATTERN = Pattern.compile("[a-zA-Z0-9_]{4,19}");
	private static final Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9]{5,20}");

	private static final Set<String> FORBIDDEN_WORD_SET = new HashSet<String>();
	static {
		FORBIDDEN_WORD_SET.add("admin");
		FORBIDDEN_WORD_SET.add("fuck");
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "username", "username.not.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "password.not.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "email.not.empty");

		User user = (User) target;

		if (!USERNAME_PATTERN.matcher(user.getUsername()).matches()) {
			errors.rejectValue("username", "username.not.illegal");
		}

		for (String forbiddenWord : FORBIDDEN_WORD_SET) {
			if (user.getUsername().contains(forbiddenWord)) {
				errors.rejectValue("username", "username.forbidden", new Object[] { forbiddenWord }, "用户名包含非法关键词");
				break;
			}
		}

		if (!PASSWORD_PATTERN.matcher(user.getPassword()).matches()) {
			errors.rejectValue("password", "password.not.illegal");
		}

	}

}
