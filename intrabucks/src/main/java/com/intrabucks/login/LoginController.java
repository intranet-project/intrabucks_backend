package com.intrabucks.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intrabucks.jwt.JwtService;

@RestController
@RequestMapping("/api/v1/intrabucks/main")
public class LoginController {
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
		UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(
				credentials.getEmail(), credentials.getPassword());
		
		Authentication auth = authenticationManager.authenticate(creds);
		StringBuilder roles = new StringBuilder("Roles: ");
		auth.getAuthorities().forEach(authority -> roles.append(authority.getAuthority()).append(", "));
		System.out.println(roles.toString());
		// 토큰 생성
		String jwts = jwtService.getToken(auth.getName());
		return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts)
				.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization").build();
	}
	
	@GetMapping("/roles")
    public String getUserRoles() {
        // 현재 인증된 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 사용자가 인증되어 있지 않은 경우
        if (authentication == null || !authentication.isAuthenticated()) {
            return "User not authenticated";
        }

        // 사용자의 역할(Role) 확인하기
        StringBuilder roles = new StringBuilder("Roles: ");
        authentication.getAuthorities().forEach(authority -> roles.append(authority.getAuthority()).append(", "));

        return roles.toString();
    }
}
