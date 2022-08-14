package com.restapi.restapi.repository;

import com.restapi.restapi.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRedisRepository extends CrudRepository<Member,Long> {
}
