package com.edaakyil.generator.password;

import com.edaakyil.generator.password.entity.UserInfo;
import com.edaakyil.generator.password.repository.IUserInfoRepository;
import com.edaakyil.generator.password.repository.UserInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class UserInfoRepositorySaveTest {
    private IUserInfoRepository m_userInfoRepository;
    private File m_file;

    @BeforeEach
    public void setUp() throws IOException
    {
        var path = Files.createDirectories(Path.of("passwords"));
        m_file = new File(path.toFile(), "eda");
        m_file.delete();
        m_userInfoRepository = new UserInfoRepository(new File("passwords"), new Random());
    }

    @Test
    public void test()
    {
        var userInfo = new UserInfo("eda", "1234", 10, 4, LocalDateTime.now());
        m_userInfoRepository.save(userInfo);

        assertTrue(m_file.exists()); // idda ediyorum ki bu test bittikten sonra bu dosya var.
        assertTrue(m_file.length() > 0);
    }
}
