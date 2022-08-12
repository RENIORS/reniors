package com.common.reniors.dto.kakao;

import com.common.reniors.domain.entity.Type.Gender;
import com.common.reniors.domain.entity.Type.IsOpen;
import com.common.reniors.domain.entity.Type.LastEdu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KakaoUserCreateRequest {
    private String kakaoId;

    @NotBlank
    private String name;

    @NotNull
    private Date birth;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank
    private String phone;

    private int totalCareer;

    @NotBlank
    private String address;

    private String extraAddress;

    @NotNull
    @Enumerated(EnumType.STRING)
    private IsOpen isOpen;

    @Enumerated(EnumType.STRING)
    private LastEdu lastEdu;

    @NotBlank
    private String userProfile;
}
