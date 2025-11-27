package com.edaakyil.java.app.service.networkinfo.dto;

import java.time.LocalDateTime;

public class Custom2NetworkInfoDTO {
    private String m_firstName;
    private String m_middleName;
    private String m_lastName;
    private int m_localPort;
    private int m_remotePort;
    private String m_remoteHost;
    private String m_localAddress;
    private LocalDateTime m_serviceRequestTime;

    public Custom2NetworkInfoDTO(String firstName, String middleName, String lastName, int localPort, int remotePort,
                                 String remoteHost, String localAddress, LocalDateTime serviceRequestTime)
    {
        m_firstName = firstName;
        m_middleName = middleName;
        m_lastName = lastName;
        m_localPort = localPort;
        m_remotePort = remotePort;
        m_remoteHost = remoteHost;
        m_localAddress = localAddress;
        m_serviceRequestTime = serviceRequestTime;
    }

    public String getFirstName()
    {
        return m_firstName;
    }

    public String getMiddleName()
    {
        return m_middleName;
    }

    public String getLastName()
    {
        return m_lastName;
    }

    public int getLocalPort()
    {
        return m_localPort;
    }

    public int getRemotePort()
    {
        return m_remotePort;
    }

    public String getRemoteHost()
    {
        return m_remoteHost;
    }

    public String getLocalAddress()
    {
        return m_localAddress;
    }

    public LocalDateTime getServiceRequestTime()
    {
        return m_serviceRequestTime;
    }
}
