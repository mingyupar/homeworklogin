package com.example.board_longin.dto;


import com.example.board_longin.entity.MemberEntity;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // ← 이 필드 모두를 매개변수로 하는 생성자를 만든다는 것임
@ToString          // ← DTO객체가 가지고 있는 필드값을 출력할 때 tostring을 자동으로 만들어 주는 것
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());
        return memberDTO;
    }


}