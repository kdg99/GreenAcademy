package kr.co.ch09.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyUserDetails implements UserDetails{
	private static final long serialVersionUID = 1L;
	private String uid;
	private String pass;
	private String name;
	private String hp;
	private int age;
	private String rdate;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 계정이 갖는 권한 목록 리턴
		Collection<GrantedAuthority> collector = new ArrayList<>();
		collector.add(new SimpleGrantedAuthority("ADMIN"));
		return collector;
	}
	@Override
	public String getPassword() {
		//계정이 갖는 비밀번호
		return pass;
	}
	@Override
	public String getUsername() {
		//계정이 갖는 ID
		return uid;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		//계정만료 여부 확인 true 만료X, false 만료
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		//계정잠김 여부 확인 true 잠김X, false 잠김
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		//계정 비밀번호 만료 여부
		return true;
	}
	@Override
	public boolean isEnabled() {
		//계정 활성화 여부
		return true;
	}
	
}
