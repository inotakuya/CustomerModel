package jp.com.inotaku.repository;

import jp.com.inotaku.domain.CustomerRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRoleRepository extends JpaRepository<CustomerRole, Long>{

}
