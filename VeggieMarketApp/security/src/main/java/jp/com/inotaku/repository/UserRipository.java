package jp.com.inotaku.repository;

import jp.com.inotaku.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRipository extends JpaRepository<User, Long>{
	
}
