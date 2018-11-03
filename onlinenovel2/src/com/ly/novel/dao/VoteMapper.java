package com.ly.novel.dao;

import org.apache.ibatis.annotations.Param;

public interface VoteMapper {

	int delUserVoteByUid(int userid);

	int createVote(int bid);

	int delVoteByBid(int bid);

	int delUserVoteByBid(int bid);

	int queryUserVoteById(@Param("userid") int userid,@Param("bid") int bid);

	int addUserVote(@Param("userid") int userid,@Param("bid") int bid);

	int addVote(int bid);

}
