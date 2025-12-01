package com.edaakyil.generator.password.data.service.mapper;

import com.edaakyil.generator.password.data.service.dto.UserInfoSaveDTO;
import com.edaakyil.generator.password.entity.UserInfo;

public interface IUserInfoMapper {
    UserInfo toUserInfo(UserInfoSaveDTO userInfoSaveDTO);
}
