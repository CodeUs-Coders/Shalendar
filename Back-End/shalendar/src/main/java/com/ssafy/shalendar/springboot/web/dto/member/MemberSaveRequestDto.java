package com.ssafy.shalendar.springboot.web.dto.member;

import com.ssafy.shalendar.springboot.domain.member.Member;
import com.ssafy.shalendar.springboot.domain.member.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//여기서 Entity 클래스와 거의 유사한 형태임에도 DTO 클래스를 추가로 생성했는데요.
//절대로 테이블과 매핑되는 Entity 클래스를 Request/ Response 클래스로 사용해서는 안됩니다.
//Entity 클래스는 가장 Core한 클래스라고 보시면 되는데요.
//수많은 서비스 클래스나 비지니스 로직들이 Entity 클래스를 기준으로 동작합니다.
//Entity 클래스가 변경되면 여러 클래스에 영향을 끼치게 되는 반면 Request와 Response용 DTO는 View를 위한 클래스라 정말 자주 변경이 필요합니다.
//View Layer와 DB Layer를 철저하게 역할 분리를 하는게 좋습니다.
//실제로 Controller에서 결과값으로 여러 테이블을 조인해서 줘야할 경우가 빈번하기 때문에 Entity 클래스만으로 표현하기가 어려운 경우가 많습니다.
//꼭꼭 Entity 클래스와 Controller에서 쓸 DTO는 분리해서 사용하시길 바랍니다.

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequestDto {
    private Long mem_no;
    private String id;
    private String pw;
    private String birth;
    private String name;
    private String nickname;
    private String img;
    private String link;
    private String msg;
    private Role role;
    private List<String> interests;

    @Builder
    public MemberSaveRequestDto(Long mem_no, String id, String pw, String birth, String name, String nickname, String img, String link, String msg, Role role, List<String> interests) {
        this.mem_no = mem_no;
        this.id = id;
        this.pw = pw;
        this.birth = birth;
        this.name = name;
        this.nickname = nickname;
        this.img = img;
        this.link = link;
        this.msg = msg;
        this.role = Role.USER;
        this.interests = interests;
    }

    public Member toEntity() {
        return Member.builder().mem_no(mem_no).id(id).pw(pw).birth(birth).name(name).nickname(nickname).img(img).link(link).msg(msg).role(role).build();
    }

    @Override
    public String toString() {
        return "MemberSaveRequestDto{" +
                "mem_no=" + mem_no +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", birth='" + birth + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", img='" + img + '\'' +
                ", link='" + link + '\'' +
                ", msg='" + msg + '\'' +
                ", role=" + role +
                ", interests=" + interests +
                '}';
    }
}
