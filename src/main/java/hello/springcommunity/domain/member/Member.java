package hello.springcommunity.domain.member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

import static hello.springcommunity.domain.validation.ValidationGroups.*;

@Data
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups = NotBlankGroup.class) //groups 속성으로 해당 검증에 해당하는 인터페이스를 설정
    @Pattern(regexp = "^[a-z0-9]{4,15}$", message = "아이디는 영어 소문자와 숫자만 사용하여 4~15자리여야 합니다.", groups = PatternGroup.class)
    private String loginId; //로그인 ID

    @NotBlank(groups = NotBlankGroup.class)
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]{2,10}$", message = "닉네임은 특수문자를 포함하지 않은 2~10자리여야 합니다.", groups = PatternGroup.class)
    private String name; //사용자 이름

    @NotBlank(groups = NotBlankGroup.class)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message = "비밀번호는 영문 대소문자, 숫자, 특수문자를 1개 이상 포함한 8~16자리수여야 합니다.", groups = PatternGroup.class)
    private String password;

//    @NotBlank(message = "이메일은 필수 입력사항입니다")
//    @Email(message = "이메일 형식에 맞지 않습니다")
//    private String userEmail;

    public Member() {
    }


}
