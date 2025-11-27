package com.edaakyil.java.app.service.networkinfo.controller;

import com.edaakyil.java.app.service.networkinfo.dto.Custom2NetworkInfoDTO;
import com.edaakyil.java.app.service.networkinfo.dto.CustomNetworkInfoDTO;
import com.edaakyil.java.app.service.networkinfo.dto.NetworkInfoDTO;
import com.karandev.datetime.configuration.constant.BeanName;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/*
 * İstekler controller katmanı tarafından karşılanır.
 *
 * endpoint, @RequestMapping annotation'ından belirtiriz
 *
 * DispatcherServlet "/info/network" endpoint'i ile gelen istekleri (requests)
 * NetworkInfoController controller'ına yönlendirecek
 *
 * NetworkInfoController'ın her istekte yeninden yaratılmasını istediğimiz için
 * NetworkInfoController bean'inin scope'unu prototype olarak ayarladık
 *
 * **: Bir istek geldiği zaman otomatik olarak o isteğe ilişkin yani o isteğe karılık gelen HttpServletRequest
 * türünden nesne yaratılır. Biz de doğrudan o nesnenin referansını buraya enjekte ediyoruz.
 * (Her istekde HttpServletRequest türünden bir nesne  Servlet'de otomatik olarak yaratılır.
 * Bu nesnenin içerisinde IP, port gibi bir takım bilgiler olur. Bu ugulamada bu bilgileri bu nesne
 * içerisinden alacağız)
 *
 * Controller üzerinden action metodu çağırma
 */

@RestController
@RequestMapping("/info/network")
@ComponentScan("com.karandev")
@Scope("prototype")
@Slf4j
public class NetworkInfoController {
    private final HttpServletRequest m_request; //**
    private final LocalDateTime m_localDateTime;

    public NetworkInfoController(@Qualifier(BeanName.LOCAL_CURRENT_DATETIME_BEAN) LocalDateTime localDateTime, HttpServletRequest request)
    {
        m_localDateTime = localDateTime;
        m_request = request;
    }

    /*
    * Action metotlarının (GET, PUT, POST, DELETE) geri döndürdükleri değerler respose'lardır.
    */


    //"remoteHost:remotePort/info/network/my?first=eda&last=akyil" url'si için bu metot çalıştırılacak
    // Action Method (iletim metodu) - Business side
    //@RequestMapping(value = "/my", method = RequestMethod.GET)
    @GetMapping("/my")
    public NetworkInfoDTO networkInfo(@RequestParam(name = "first") String firstName,
                                      @RequestParam(name = "middle", required = false) String middleName,
                                      @RequestParam(name = "last") String lastName,
                                      int age)
    {
        //Network bilgilerini oluşturma
        var info = NetworkInfoDTO.builder()
                .lastName(lastName)
                .firstName(firstName)
                .middleName(middleName)
                .age(age)
                .remoteHost(m_request.getRemoteHost())
                .localAddress(m_request.getLocalAddr())
                .remotePort(m_request.getRemotePort())
                .localPort(m_request.getLocalPort())
                .serviceRequestTime(m_localDateTime)
                .build();

        log.info("Network information request: {}", info);
        //log.info("Network information request: {}", info.toString());

        // Network bilgilerine geri dönme
        return info;
    }

    @GetMapping("/demo")
    public String demoNetworkInfo()
    {
        return "Demo Network Info";
    }

    @GetMapping("/custom")
    public CustomNetworkInfoDTO customNetworkInfo(@RequestParam(name = "first") String firstName,
                                                  @RequestParam(name = "middle", required = false) String middleName,
                                                  @RequestParam(name = "last") String lastName)
    {
        var info = new CustomNetworkInfoDTO(
                firstName,
                middleName,
                lastName,
                m_request.getLocalPort(),
                m_request.getRemotePort(),
                m_request.getRemoteHost(),
                m_request.getLocalAddr(),
                m_localDateTime
        );

        log.info("Network information request: {}", info);
        //log.info("Network information request: {}", info.toString());

        // Network bilgilerine geri dönme
        return info;
    }

    @GetMapping("/custom3")
    public String custom3NetworkInfo(@RequestParam(name = "first") String firstName,
                                     @RequestParam(name = "middle", required = false) String middleName,
                                     @RequestParam(name = "last") String lastName)
    {
        var info = new CustomNetworkInfoDTO(
                firstName,
                middleName,
                lastName,
                m_request.getLocalPort(),
                m_request.getRemotePort(),
                m_request.getRemoteHost(),
                m_request.getLocalAddr(),
                m_localDateTime
        );

        log.info("Network information request: {}", info);
        //log.info("Network information request: {}", info.toString());

        // Network bilgilerine geri dönme
        return info.toString();
    }

    @GetMapping("/custom2")
    public Custom2NetworkInfoDTO custom2NetworkInfo(@RequestParam(name = "first") String firstName,
                                                    @RequestParam(name = "middle", required = false) String middleName,
                                                    @RequestParam(name = "last") String lastName)
    {
        var info = new Custom2NetworkInfoDTO(
                firstName,
                middleName,
                lastName,
                m_request.getLocalPort(),
                m_request.getRemotePort(),
                m_request.getRemoteHost(),
                m_request.getLocalAddr(),
                m_localDateTime
        );

        log.info("Network information request: {}", info);
        //log.info("Network information request: {}", info.toString());

        // Network bilgilerine geri dönme
        return info;
    }
}
