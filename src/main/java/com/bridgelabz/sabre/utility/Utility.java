/*package com.bridgelabz.sabre.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.elasticsearch.cli.UserException;



*//**
 * @author Chaitra Ankolekar
 * Purpose :Utility class for validation
 *//*
public class Utility {
	
	static final String KEY = "chaitra";

	public Utility() {

	}
	*//**
	 * to create a jwt token
	 * 
	 * @param id
	 * @return
	 *//*
	public String createToken(String id) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		Date date = new Date();

		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(date).signWith(signatureAlgorithm, KEY);
		return builder.compact();
	}

	*//**
	 * to decode the jwt token
	 * 
	 * @param jwt
	 * @return
	 * @throws ToDoException 
	 *//*
	public Claims parseJwt(String jwt) throws ToDoException {
		
		return Jwts.parser().setSigningKey(KEY).parseClaimsJws(jwt).getBody();
		}

	*//**
	 * @param user
	 * @return token
	 *//*
	public String createTokens(User user) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		JwtBuilder builder = Jwts.builder().setSubject(user.getEmailId()).setIssuedAt(new Date())
				.setIssuer(user.getUserId()).signWith(signatureAlgorithm, KEY);
		return builder.compact();
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
			.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");

	private static final Pattern PASSWORD_PATTERN = Pattern
			.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})");

	private static final Pattern CONTACT_PATTERN = Pattern.compile("^[0-9]{10}$");

	public static boolean validateEmail(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if (!matcher.find()) {
			return false;
		}
		return true;
	}

	public static boolean validatePassword(String password) {
		Matcher matcher = PASSWORD_PATTERN.matcher(password);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

	public static boolean validatePhoneNumber(String phoneNumber) {
		Matcher matcher = CONTACT_PATTERN.matcher(phoneNumber);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

	public static void validateUserForRegistration(User user) throws UserException, UserExceptionHandler {

		if((user.getUserName() == null) || user.getUserName().length() < 3) {
			throw new UserExceptionHandler("Name should have atleast 3 characters");
		}

		if (user.getPhoneNumber() == null || (!validatePhoneNumber(user.getPhoneNumber()))) {
			throw new UserExceptionHandler("Contact number should be exactly 10 digit numbers");
		}

		if ((!validatePassword(user.getPassword()))) {
			throw new UserExceptionHandler("Password should have atleast one uppercase character");
			// + "atlest one lowercase character, " + "one special character, " + "and
			// atleast one number");
		}

		if (user.getEmailId() == null || user.getEmailId().trim().length() == 0) {
			throw new UserExceptionHandler("Incorrect email format");
		}

		 if (user.getPassword() == null || (!validatePassword(user.getPassword()))) {// || user.getPassword().length()<=8) {
	        throw new UserExceptionHandler("password should have less than 8 characters");
	    }
	}

	
	
	public static User getUser(User registrationDto) {
		User user = new User();
		user.setEmailId(registrationDto.getEmailId());
		user.setUserName(registrationDto.getUserName());
		user.setPhoneNumber(registrationDto.getPhoneNumber());
		user.setPassword(registrationDto.getPassword());
		return user;
	}

	public static void validateUserForLogin(User user) throws LoginExceptionHandler {
		
		if (user.getEmailId() == null || user.getEmailId().length() == 0) {
			throw new LoginExceptionHandler("Incorrect email format");
		}

		 if (user.getPassword() == null || (!validatePassword(user.getPassword())) ) {
	            throw new LoginExceptionHandler("Password should have atleast one uppercase character atlest one lowercase character one special character and atleast one number");
	        }
	}
	
	public static void validateUserForResetPassword(ForgotPasswordModel resetPassword) throws UserExceptionHandler {
		
		if (resetPassword.getNewPassword() == null || (!validatePassword(resetPassword.getNewPassword()))) {
			throw new UserExceptionHandler("Password should have atleast one uppercase character atlest one lowercase character one special character and atleast one number");
		}

		if (resetPassword.getConfirmPassword() == null || (!resetPassword.getNewPassword().equals(resetPassword.getConfirmPassword()))) {
			throw new UserExceptionHandler("password should match with confirm password");
		}
	}

	public static String generateUUID() {
		UUID randomString = UUID.randomUUID();
		return randomString.toString();
	}
}
*/