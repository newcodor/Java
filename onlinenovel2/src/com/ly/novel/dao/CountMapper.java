package com.ly.novel.dao;

public interface CountMapper {

	void addCount(int bid);

	void updateAccessCount(int bid);

	void delCountByBid(int bid);


}
