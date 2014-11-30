package jp.com.inotaku.repository;

import jp.com.inotaku.domain.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
