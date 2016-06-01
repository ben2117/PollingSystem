/**
 * PolSysSoapServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package polsys.soap.client;

public interface PolSysSoapServiceService extends javax.xml.rpc.Service {
    public java.lang.String getPolSysSoapServicePortAddress();

    public polsys.soap.client.PolSysSoapService getPolSysSoapServicePort() throws javax.xml.rpc.ServiceException;

    public polsys.soap.client.PolSysSoapService getPolSysSoapServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
