package com.restapi.restapi.entity;

import lombok.*;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
