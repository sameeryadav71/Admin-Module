package com.cbic.microservices.login.loginservice;

import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cbic.microservices.login.loginservice.auth.JwtTokenFilter;
import com.cbic.microservices.login.loginservice.auth.JwtTokenUtil;
import com.cbic.microservices.login.loginservice.user.User;
import com.cbic.microservices.login.loginservice.user.api.AuthResponse;

@RestController
public class LoginController {

//	@Autowired
//	private LoginConfiguration loginConfiguration;
	@Autowired
	private JwtTokenFilter jwtTokenFilter;
	@Autowired
	LdapAuth ldapAuth;
	@Autowired
	AuthenticationManager authManager;
	@Autowired
	JwtTokenUtil jwtUtil;

	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<AuthResponse> ldapAuth(@PathVariable String username, @PathVariable String password)
			throws NamingException {
		String userInfo = ldapAuth.authenticateUser(username, password);
		if (userInfo.compareTo("true") == 0 || userInfo.compareTo("Invalid Credentials") == 0) {
			try {
				List<String> roles = ldapAuth.getUserRoles(username);
				if (!roles.isEmpty() && roles != null) {
					User user = new User();
					user.setEmail(username);
					user.setId(80006559);
					user.setPassword(password);
					// String ss=roles.get(0);
					user.setRole("Admin");

					String accessToken = jwtUtil.generateAccessToken(user);
					AuthResponse response = new AuthResponse(username, accessToken);

					return ResponseEntity.ok().body(response);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ResponseEntity.badRequest().body(null);

	}

	@GetMapping("/ValidateRequest")
	public ResponseEntity<AuthResponse> Validateuser()
			throws NamingException {

		try {
			
			//  String tocken=jwtTokenFilter.getAccessToken(); 
			  //User userDetails = jwtTokenFilter.getUserDetails(tocken);
			 
		//	List<String> roles = ldapAuth.getUserRoles(username);
			//if (!roles.isEmpty() && roles != null) {
				User user = new User();
				//user.setEmail();
				user.setId(80006559);
				//user.setPassword(password);
				// String ss=roles.get(0);
				user.setRole("Admin");

				//String accessToken = jwtUtil.validateAccessToken(user);
				//AuthResponse response = new AuthResponse("80006559", accessToken);
				AuthResponse response = new AuthResponse();

				return ResponseEntity.ok().body(null);
			//}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.badRequest().body(null);

	}

	private void generateJWTToken() {
		// TODO Auto-generated method stub

	}

}
