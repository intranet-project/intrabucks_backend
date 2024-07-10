package com.intrabucks.login;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.intrabucks.employee.data.repository.EmployeeRepository;
import com.intrabucks.entity.Employee;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String empEmail) {
		//Optional<T>to-generated method stub
		Employee user = repository.findByEmpEmail(empEmail);
		
		String role = "ROLE_" + user.getDepartment().getDeptCode();
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(role));

        // 디버깅 로그
        System.out.println("User email: " + empEmail);
        System.out.println("User role: " + role);
        
        // UserBuilder를 사용하여 UserDetails 객체를 생성
        UserDetails userDetails = User.builder()
                .username(empEmail)
                .password(user.getEmpPassword())
                .authorities(authorities)
                .build();
        
        // 추가 디버깅 로그
        System.out.println("User authorities: " + userDetails.getAuthorities());

        return userDetails;
	}
	
}
