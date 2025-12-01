package com.edaakyil.generator.password.data.service.mapper;

import com.edaakyil.generator.password.data.service.dto.UserInfoSaveDTO;
import com.edaakyil.generator.password.entity.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/*
* @Mapper annotation'ı UserInfoMapperImpl diye bir sınıf üretecek
*/
@Mapper(implementationName = "UserInfoMapperImpl", componentModel = "spring")
public interface IUserInfoMapper {
    @Mappings({@Mapping(source = "textCount", target = "count"), @Mapping(source = "textLength", target = "len")})
    //@Mapping(source = "textCount", target = "count")
    //@Mapping(source = "textLength", target = "len")
    UserInfo toUserInfo(UserInfoSaveDTO userInfoSaveDTO);
}
