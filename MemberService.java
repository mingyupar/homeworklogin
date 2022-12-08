package com.example.board_longin.controller;

import com.example.board_longin.dto.MemberDTO;
import com.example.board_longin.entity.MemberEntity;
import com.example.board_longin.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private Object MemberEntity;

    public void save(MemberDTO memberDTO) {
        // 1. dto -> entity 변환
        // 2.repository의 save 메서드 호출
        // repository의 save메서드 호출 (조건. entity객체를 넘겨줘야 함)
    }
    public MemberDTO login(MemberDTO memberDTO) {
        /*
            1. 회원이 입력한 이메일로 DB에서 조회 함
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
        */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if (byMemberEmail.isPresebt()) {
            //조회결과가 있다(해당 이메일을 가진 회원정보가 있다.)
            MemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                //비밀번호 일치
                //entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                //비밀번호 불일치(로그인샐패)
                return null;
            }
        } else {
            // 조회결과가 없다(해당 이메일을 가진 회원이 없다)
            return null;
        }
    }

}
