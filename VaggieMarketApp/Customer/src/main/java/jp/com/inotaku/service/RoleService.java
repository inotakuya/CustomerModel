package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.domain.Role;

public interface RoleService {

	public void saveRole(Role role);
	
	public List<Role> findAllRole();
}
