package com.example.board_longin.entity;

import com.example.board_longin.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 50, unique = true)
    private String memberEmail;

    @Column(length = 20)
    private String memberPassword;

    @Column(length = 20)
    private String memberName;

    public <NenberDTO> void toMemberEntitiy(NenberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO, getMemberEmail());
        memberEntity.setMemberPassword(memberDTO, getMemberPassword());
        memberEntity.setMemberName(memberDTO, getMemberName());

    }

    public  <NenberDTO> void setMemberName(NenberDTO memberDTO, String memberName) {
    }

    public  <NenberDTO> void setMemberPassword(NenberDTO memberDTO, String memberPassword) {
    }

    public  <NenberDTO> void setMemberEmail(NenberDTO memberDTO, String memberEmail) {
    }


    public static MemberEntity toSaveEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());

        return memberEntity;
    }


}
