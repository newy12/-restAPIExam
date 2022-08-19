package com.restapi.restapi.controller;


import com.restapi.restapi.entity.Gender;
import com.restapi.restapi.entity.Member;
import com.restapi.restapi.entity.Team;
import com.restapi.restapi.repository.MemberRedisRepository;
import com.restapi.restapi.repository.MemberRepository;
import com.restapi.restapi.repository.TeamRepository;
import com.restapi.restapi.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.cache.CacheKey;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Api(tags = "영재의 스웨거 연습모드")
@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class RestController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final TeamRepository teamRepository;
    private final MemberRedisRepository memberRedisRepository;

    @GetMapping(value = "test")
    public String test(){
        String name = "김영재";
        return name;
    }

    //덧셈 API
    @ApiOperation(value = "덧셈", notes = "덧셈 사칙연산")
    @GetMapping(value = "/add")
    public ResponseEntity<Integer> add(
            @ApiParam(value = "첫째 값", required = true, example = "1")
            @RequestParam(value = "num1", required = true) int num1,
            @ApiParam(value = "두번째 값", required = true, example = "2")
            @RequestParam(value = "num2", required = true) int num2) {

        int sum = num1 + num2;

        return ResponseEntity.ok(sum);
    }

    //밸셈 API
    @ApiOperation(value = "뺄셈", notes = "뺄셈 사칙연산")
    @GetMapping(value = "/minue")
    public ResponseEntity<Integer> minue(
            @ApiParam(value = "첫째 값", required = true, example = "3")
            @RequestParam(value = "num1", required = true) int num1,
            @ApiParam(value = "두번째 값", required = true, example = "4")
            @RequestParam(value = "num2", required = true) int num2) {

        int minus = num1 + num2;

        return ResponseEntity.ok(minus);
    }

    //곱셈 API
    @ApiOperation(value = "곱셈", notes = "곱셈 사칙연산")
    @GetMapping(value = "/multiply")
    public ResponseEntity<Double> multiply(
            @ApiParam(value = "첫째 값", required = true, example = "5")
            @RequestParam(value = "num1", required = true) int num1,
            @ApiParam(value = "두번째 값", required = true, example = "6")
            @RequestParam(value = "num2", required = true) int num2) {

        double res = num1 * num2;

        return ResponseEntity.ok(res);
    }

    //나눗셈 API
    @ApiOperation(value = "나눗셈", notes = "나눗셈 사칙연산")
    @GetMapping(value = "div")
    public ResponseEntity<Double> div(
            @ApiParam(value = "첫째 값", required = true, example = "3")
            @RequestParam(value = "num1", required = true) int num1,
            @ApiParam(value = "두번째 값", required = true, example = "2")
            @RequestParam(value = "num2", required = true) int num2) {

        double res = num1 / num2;

        return ResponseEntity.ok(res);
    }

    @PostMapping("/memberAdd")
    public void memberAdd(){
        Team team = new Team();
        team.setTeamName("영재팀");
        teamRepository.save(team);
        Member member = new Member();
        member.setName("김영재");
        member.setAge("27");
        member.setGender(Gender.남);
        member.setTeam(team);
        memberRepository.save(member);
    }

    //레디스 캐시 데이터 저장 //테스연동 //
    @Cacheable(value = "youngjae")
    @GetMapping("/selectMemberInJPA")
    public List<Member> selectMemberInJPA(){
        return memberRepository.findAll();
    }
    //mybatis select
    @GetMapping("/selectMemberInMybatis")
    public List<Member> selectMemberAndTeamInMybatis(){
        return memberService.selectMemberAndTeam();
    }
    //querydsl select
    @GetMapping("/selectMemberInQueryDSL")
    public List<Member> selectMemberInQueryDSL(){
        return memberService.getMemberInQueryDSL();
    }
    @PostMapping("/insertMemberInRedis")
    public void addMemberInCache(){
        Member member = new Member();
        member.setAge("47");
        member.setGender(Gender.여);
        member.setName("박영순");
        memberRedisRepository.save(member);
    }
    //레디스 캐시데이터 삭제
    @CacheEvict(value = "youngjae")
    @DeleteMapping("/deleteMemberDate")
    public void deleteMemberDate(){
        memberRepository.deleteAll();
    }
}
