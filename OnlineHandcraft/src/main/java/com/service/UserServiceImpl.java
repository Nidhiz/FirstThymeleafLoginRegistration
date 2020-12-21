package com.ohm.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ohm.controller.dto.UserRegistrationDto;
import com.ohm.pojos.Role;
import com.ohm.pojos.User;
import com.ohm.repository.IUserRepository;


@Service
public class UserServiceImpl implements IUserService {
	
	private IUserRepository userRepository;
	
	public UserServiceImpl(IUserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	//to inject encrypted password from Bean
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public User save(UserRegistrationDto registrationDto) {
		
		User user=new User(registrationDto.getFirstName(),registrationDto.getEmail(),
										passwordEncoder.encode(registrationDto.getPassword()),
										registrationDto.getAddress(),
										registrationDto.getContactNo(),registrationDto.getDob(),
										registrationDto.getCity(),registrationDto.getState(),
										registrationDto.getGender(),Arrays.asList(new Role("Role_USER")));
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("Invalid User Name and Password");
		}
		System.out.println(user.getRole());
		//returning User object (provided by Spring Security) here User is class of UserDetails Interface
			return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRole()));
	}
	
	//Method to create Roles to authorized user
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		
		 return roles.stream().map(role-> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
		
	}

}
