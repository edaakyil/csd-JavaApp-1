package com.edaakyil.generator.password.data.service.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfoSaveDTO {
    @Accessors(prefix = "m_")
    private String m_username;

    @Accessors(prefix = "m_")
    private String m_password;

    @Accessors(prefix = "m_")
    private int m_textCount;

    @Accessors(prefix = "m_")
    private int m_textLength;
}
