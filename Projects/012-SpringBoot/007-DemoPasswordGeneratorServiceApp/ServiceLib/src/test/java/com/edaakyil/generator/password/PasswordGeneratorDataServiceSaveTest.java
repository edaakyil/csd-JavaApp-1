package com.edaakyil.generator.password;

import com.edaakyil.generator.password.dal.PasswordGeneratorHelper;
import com.edaakyil.generator.password.data.service.PasswordGeneratorDataService;
import com.edaakyil.generator.password.data.service.dto.UserInfoSaveDTO;
import com.edaakyil.generator.password.data.service.mapper.UserInfoMapper;
import com.edaakyil.generator.password.repository.UserInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

/* That test class can not know the file. We will change later */
public class PasswordGeneratorDataServiceSaveTest {
    @BeforeEach
    public void setUp() throws IOException
    {
        var path = Files.createDirectories(Path.of("passwords"));
        Files.delete(path.resolve("merve"));

        //var file  = new File(path.toFile(), "merve");
        //file.delete();
    }

    @Test
    public void test()
    {
        var service = new PasswordGeneratorDataService(new PasswordGeneratorHelper(new UserInfoRepository(new File("passwords"), new Random())), new UserInfoMapper());
        var userInfoDTO = new UserInfoSaveDTO("merve", "1234", 20, 5);

        assertTrue(service.saveUserInfo(userInfoDTO));
    }
}