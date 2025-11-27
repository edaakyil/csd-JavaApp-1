package com.edaakyil.generator.password.repository;

import com.edaakyil.generator.password.entity.UserInfo;
import com.edaakyil.java.lib.data.repository.ICrudRepository;

import java.util.Optional;

public interface IUserInfoRepository extends ICrudRepository<UserInfo, String> {
    Optional<UserInfo> saveIfNotExists(UserInfo userInfo);
}