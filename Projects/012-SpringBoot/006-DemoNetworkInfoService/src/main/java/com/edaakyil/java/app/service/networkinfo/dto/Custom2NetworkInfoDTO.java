package com.edaakyil.java.app.service.networkinfo.dto;

import java.time.LocalDateTime;

public class CustomNetworkInfoDTO {
    public String m_firstName;
    public String m_middleName;
    public String m_lastName;
    public int m_localPort;
    public int m_remotePort;
    public String m_remoteHost;
    public String m_localAddress;
    public LocalDateTime m_serviceRequestTime;

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

    /*
    @Override
    public String toString()
    {
        return "First name: %s, Middle name: %s, Last Name: %s, localPort: %d, remotePort: %s, remoteHost: %s, localAddress: %s"
                .formatted(m_firstName, m_middleName, m_lastName, m_localPort, m_remotePort, m_remoteHost, m_localAddress);
    }
    */
}
