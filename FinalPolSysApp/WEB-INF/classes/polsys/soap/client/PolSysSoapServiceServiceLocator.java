/**
 * PolSysSoapServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package polsys.soap.client;

public class PolSysSoapServiceServiceLocator extends org.apache.axis.client.Service implements polsys.soap.client.PolSysSoapServiceService {

    public PolSysSoapServiceServiceLocator() {
    }


    public PolSysSoapServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PolSysSoapServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PolSysSoapServicePort
    private java.lang.String PolSysSoapServicePort_address = "http://localhost:8080/PolSysAppReconstructed/soap/polsys";

    public java.lang.String getPolSysSoapServicePortAddress() {
        return PolSysSoapServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PolSysSoapServicePortWSDDServiceName = "PolSysSoapServicePort";

    public java.lang.String getPolSysSoapServicePortWSDDServiceName() {
        return PolSysSoapServicePortWSDDServiceName;
    }

    public void setPolSysSoapServicePortWSDDServiceName(java.lang.String name) {
        PolSysSoapServicePortWSDDServiceName = name;
    }

    public polsys.soap.client.PolSysSoapService getPolSysSoapServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PolSysSoapServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPolSysSoapServicePort(endpoint);
    }

    public polsys.soap.client.PolSysSoapService getPolSysSoapServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            polsys.soap.client.PolSysSoapServicePortBindingStub _stub = new polsys.soap.client.PolSysSoapServicePortBindingStub(portAddress, this);
            _stub.setPortName(getPolSysSoapServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPolSysSoapServicePortEndpointAddress(java.lang.String address) {
        PolSysSoapServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (polsys.soap.client.PolSysSoapService.class.isAssignableFrom(serviceEndpointInterface)) {
                polsys.soap.client.PolSysSoapServicePortBindingStub _stub = new polsys.soap.client.PolSysSoapServicePortBindingStub(new java.net.URL(PolSysSoapServicePort_address), this);
                _stub.setPortName(getPolSysSoapServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PolSysSoapServicePort".equals(inputPortName)) {
            return getPolSysSoapServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.polsys/", "PolSysSoapServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.polsys/", "PolSysSoapServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PolSysSoapServicePort".equals(portName)) {
            setPolSysSoapServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
