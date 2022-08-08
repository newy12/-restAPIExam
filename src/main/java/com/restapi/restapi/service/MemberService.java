package com.restapi.restapi.service;

import com.restapi.restapi.entity.Member;
import com.restapi.restapi.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public List<Member> selectMemberAndTeam() {
        return memberMapper.selectMemberAndTeam();
    }
}
