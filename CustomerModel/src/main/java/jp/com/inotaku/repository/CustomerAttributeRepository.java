package jp.com.inotaku.repository;
import java.util.List;

import jp.com.inotaku.domain.CustomerAttribute;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = CustomerAttribute.class)
public interface CustomerAttributeRepository {
	@Query("FROM CustomerAttribute where name like %:name%")
	List<CustomerAttribute> findByNameLikeAndLocaleCode(@Param("name")String name);
}
