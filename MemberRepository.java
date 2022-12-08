package com.example.board_longin.repository;

import com.example.board_longin.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // select * from member_table where membweEmail = ?
    //리턴타입: MemberEntity
    //매개변수: memberEmail(String)

    Optional<MemberEntity> findByMemberEmail(String memberEmail);


}
