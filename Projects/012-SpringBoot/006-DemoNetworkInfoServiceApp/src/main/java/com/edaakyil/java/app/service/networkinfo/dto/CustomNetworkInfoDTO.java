package com.edaakyil.java.app.service.networkinfo.dto;

import java.time.LocalDateTime;

public class CustomNetworkInfoDTO {
    private String m_firstName;
    private String m_middleName;
    private String m_lastName;
    private int m_localPort;
    private int m_remotePort;
    private String m_remoteHost;
    private String m_localAddress;
    private LocalDateTime m_serviceRequestTime;

    public CustomNetworkInfoDTO(String firstName, String middleName, String lastName, int localPort,
                                int remotePort, String remoteHost, String localAddress, LocalDateTime serviceRequestTime)
    {
        this.m_firstName = firstName;
        this.m_middleName = middleName;
        this.m_lastName = lastName;
        this.m_localPort = localPort;
        this.m_remotePort = remotePort;
        this.m_remoteHost = remoteHost;
        this.m_localAddress = localAddress;
        this.m_serviceRequestTime = serviceRequestTime;
    }

    public String getMiddleName()
    {
        return m_middleName;
    }


    @Override
    public String toString()
    {
        return "First name: %s, Middle name: %s, Last Name: %s, localPort: %d, remotePort: %s, remoteHost: %s, localAddress: %s"
                .formatted(m_firstName, m_middleName, m_lastName, m_localPort, m_remotePort, m_remoteHost, m_localAddress);
    }

}
