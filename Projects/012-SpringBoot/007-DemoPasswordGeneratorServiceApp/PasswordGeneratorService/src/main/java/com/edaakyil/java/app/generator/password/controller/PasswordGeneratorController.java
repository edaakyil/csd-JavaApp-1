package com.edaakyil.java.app.generator.password.controller;

import com.edaakyil.generator.password.data.service.PasswordGeneratorDataService;
import com.edaakyil.generator.password.data.service.dto.UserInfoSaveDTO;
import com.edaakyil.java.lib.data.service.exception.DataServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/generator/password")
@ComponentScan(basePackages = "com.edaakyil")
@Slf4j
public class PasswordGeneratorController {
    private final PasswordGeneratorDataService m_passwordGeneratorDataService;

    public PasswordGeneratorController(PasswordGeneratorDataService passwordGeneratorDataService)
    {
        m_passwordGeneratorDataService = passwordGeneratorDataService;
    }

    /*
    * ekleme işlemi olduğu için Post metodunu kullandık
    *
    * generatePassword() metodu argüman olarak UserInfoSaveDTO'yu alırken Json formatında alacak.
    * Bun lgili Json formatını çevirmesi için UserInfoSaveDTO paramteresini @RequestBody annotation'ı ile işaretlememiz lazım.
    * Bilgi GET metodunda url'e takılı olarak verirken POST metodunda bilgiyi header'ın içerisinde saklıyoruz.
    * Dolayısıyla Post ile gelen bu bilgiyi bir sınıf ile eşleştiriyoruz.
    * Bunu çevirmesi için de @RequestBody annotation'ı kullanıyoruz.
    */
    @PostMapping("/generate")
    public ResponseEntity<UserInfoSaveDTO> generatePassword(@RequestBody UserInfoSaveDTO userInfoSaveDTO)
    {
        // internalServerError olan bir ResponseEntity yaratılmasını sağlıyor
        // internalServerError'un status kodu normalde 500'dür.
        //var responseEntity = ResponseEntity.internalServerError().body(userInfoSaveDTO); // 500 kodu ile geri dönecek

        ResponseEntity<UserInfoSaveDTO> responseEntity;

        try {
            var result = m_passwordGeneratorDataService.saveUserInfo(userInfoSaveDTO);

            // Eğer save edebilirse 200 status kodu ile aynı referansa dönüyoruz.
            // Yani response olarak json formatında aynı request'e geri dönüyoruz
            // Eğer save edemezse badRequest olarak geri dönüyoruz:
            responseEntity = result ? ResponseEntity.ok(userInfoSaveDTO) : ResponseEntity.badRequest().body(userInfoSaveDTO);

            log.info("PasswordGeneratorController.generatePassword -> status: {}", result ? HttpStatus.OK : HttpStatus.BAD_REQUEST);

        } catch (DataServiceException ex) {
            log.error("PasswordGeneratorController.generatePassword -> DataServiceException: Exception: {}, Message: {}",
                    ex.getCause().getClass().getSimpleName(), ex.getMessage());

            responseEntity = ResponseEntity.internalServerError().body(userInfoSaveDTO);
        }

        return responseEntity;
    }
}