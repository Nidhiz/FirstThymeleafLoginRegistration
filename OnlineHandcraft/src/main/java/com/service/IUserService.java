package com.ohm.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ohm.controller.dto.UserRegistrationDto;
import com.ohm.pojos.User;

public interface IUserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

}
