package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.domain.Item;


public interface ItemService {

	public List<Item> findAllItems();

	public void saveItem(Item item);

	public void deleteItem(long itemId);
}
