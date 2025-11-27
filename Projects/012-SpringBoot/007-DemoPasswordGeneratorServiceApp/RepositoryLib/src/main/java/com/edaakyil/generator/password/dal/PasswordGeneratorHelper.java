package com.edaakyil.generator.password.dal;

import com.edaakyil.generator.password.entity.UserInfo;
import com.edaakyil.generator.password.repository.IUserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * The DAL layer corresponds to the facade pattern from the design patterns.
 *
 * <p>PasswordGeneratorHelper can also be named PasswordGeneratorFacade.</p>
 */
@Component
@Slf4j
public class PasswordGeneratorHelper {
    private final IUserInfoRepository m_userInfoRepository;
    // Other repositories

    public PasswordGeneratorHelper(IUserInfoRepository userInfoRepository)
    {
        m_userInfoRepository = userInfoRepository;
    }

    public List<String> findAllUsernames()
    {
        log.info("PasswordGeneratorHelper.findAllUsernames");

        return StreamSupport.stream(m_userInfoRepository.findAll().spliterator(), false)
                .map(UserInfo::getUsername).toList();
    }

    public Iterable<UserInfo> findAllUsers()
    {
        log.info("PasswordGeneratorHelper.findAllUsers:");

        return m_userInfoRepository.findAll();
    }

    public Optional<UserInfo> saveUserIfNotExists(UserInfo userInfo)
    {
        //...

        log.info("PasswordGeneratorHelper.saveUserInfoIfNotExists: {}", userInfo.toString());

        return m_userInfoRepository.saveIfNotExists(userInfo);
    }

    //...
}
