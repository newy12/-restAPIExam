package com.restapi.restapi.repository;

import com.restapi.restapi.entity.Member;
import com.restapi.restapi.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
