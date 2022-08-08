package com.restapi.restapi.mapper;


import com.restapi.restapi.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MemberMapper {
    List<Member> selectMemberAndTeam();
}
