package com.restapi.restapi.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.restapi.restapi.entity.Member;
import com.restapi.restapi.entity.QMember;
import com.restapi.restapi.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final EntityManager em;

    public List<Member> selectMemberAndTeam() {
        return memberMapper.selectMemberAndTeam();
    }
//dd
    public List<Member> getMemberInQueryDSL() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        QMember member = QMember.member;
        return jpaQueryFactory
                .select(member)
                .from(member)
                .distinct()
                .fetch();
    }
}
