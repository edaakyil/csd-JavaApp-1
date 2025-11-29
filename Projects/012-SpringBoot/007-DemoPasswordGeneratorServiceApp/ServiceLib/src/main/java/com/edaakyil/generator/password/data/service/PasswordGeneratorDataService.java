package com.edaakyil.generator.password.data.service;

import com.edaakyil.generator.password.dal.PasswordGeneratorHelper;
import com.edaakyil.generator.password.data.service.dto.UserInfoSaveDTO;
import com.edaakyil.generator.password.data.service.mapper.IUserInfoMapper;
import com.edaakyil.java.lib.data.repository.exception.RepositoryException;
import com.edaakyil.java.lib.data.service.exception.DataServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PasswordGeneratorDataService {
    private final PasswordGeneratorHelper m_passwordGeneratorHelper;
    private final IUserInfoMapper m_userInfoMapper;

    public PasswordGeneratorDataService(PasswordGeneratorHelper passwordGeneratorHelper, IUserInfoMapper userInfoMapper)
    {
        m_passwordGeneratorHelper = passwordGeneratorHelper;
        m_userInfoMapper = userInfoMapper;
    }

    public List<String> findAllUsernames()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public boolean saveUserInfo(UserInfoSaveDTO userInfoSaveDTO)
    {
        try {
            log.info("PasswordGeneratorService.saveUserInfo: {}", userInfoSaveDTO.toString());

            return m_passwordGeneratorHelper.saveUserIfNotExists(m_userInfoMapper.toUserInfo(userInfoSaveDTO)).isPresent();

        } catch (RepositoryException ex) {
            log.error("PasswordGeneratorDataService.saveUserInfo -> RepositoryException: {}", ex.getMessage());

            throw new DataServiceException("PasswordGeneratorDataService.saveUserInfo -> RepositoryException", ex);

        } catch (Throwable ex) {
            log.error("PasswordGeneratorDataService.saveUserInfo -> Any Exception: Exception: {}, Message: {}",
                    ex.getClass().getSimpleName(), ex.getMessage());

            throw new DataServiceException("PasswordGeneratorDataService.saveUserInfo -> Any Exception", ex);
        }
    }
}
