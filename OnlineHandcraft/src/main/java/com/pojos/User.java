package com.ohm.pojos;

//import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.*;

//import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Users" )
public class User {

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@Column(name = "username")
	private String userName;
	
	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "contactno")
	private String contactNo;
	
	@Column(name = "dob")
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String dob;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "gender")
	private String gender;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
		            name = "user_id", referencedColumnName = "userid"),
			inverseJoinColumns = @JoinColumn(
				            name = "role_id", referencedColumnName = "roleid"))
	
	private Collection<Role> roles;

	
	public User() {
		System.out.println("in ctor of "+getClass().getName());
	}

	
	public User(String userName, String email, String password, String address, String contactNo,
			String dob, String city, String state, String gender, Collection<Role> roles) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contactNo = contactNo;
		this.dob = dob;
		this.city = city;
		this.state = state;
		this.gender = gender;
		this.roles=roles;
	}




	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Collection<Role> getRole() {
		return roles;
	}

	public void setRole(Collection<Role> role) {
		this.roles = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", contactNo=" + contactNo + ", expDate=" + dob + ", city=" + city
				+ ", state=" + state + ", gender=" + gender + ", role=" + roles + "]";
	}


}
