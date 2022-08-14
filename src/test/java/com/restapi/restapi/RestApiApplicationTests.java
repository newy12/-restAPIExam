package com.restapi.restapi;

import com.restapi.restapi.entity.Member;
import com.restapi.restapi.repository.MemberRedisRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	private MemberRedisRepository memberRedisRepository;



}
