/**
 * PolSysSoapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package polsys.soap.client;

public interface PolSysSoapService extends java.rmi.Remote {
    public boolean login(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean isLogin() throws java.rmi.RemoteException;
    public java.lang.String[] viewPoll(int arg0, java.lang.String arg1, int arg2) throws java.rmi.RemoteException;
    public void closePoll(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String createPoll(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public void createOptions(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public java.lang.String getPoll(int arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getPolls() throws java.rmi.RemoteException;
}
