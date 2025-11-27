package com.edaakyil.java.app.service.networkinfo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * NetworkInfoDTO sınıfı, data'yı taşıyacak olan katmandır.
 */

@Data
@Builder
public class NetworkInfoDTO {
    @Accessors(prefix = "m_")
    private String m_firstName;

    @Accessors(prefix = "m_")
    private String m_middleName;

    @Accessors(prefix = "m_")
    private String m_lastName;

    @Accessors(prefix = "m_")
    private int m_localPort;  // bağlantının sağlandığı port numarası

    @Accessors(prefix = "m_")
    private int m_remotePort; // (ephemeral port) iletimin yapıldığı port numarası

    @Accessors(prefix = "m_")
    private String m_remoteHost;

    @Accessors(prefix = "m_")
    private String m_localAddress;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("serviceRequestTime")
    @Accessors(prefix = "m_")
    private LocalDateTime m_serviceRequestTime;

    // lombok'un getter'ını ezdik
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getMiddleName()
    {
        return m_middleName;
    }
}
