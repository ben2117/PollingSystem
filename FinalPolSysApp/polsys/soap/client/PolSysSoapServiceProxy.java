package polsys.soap.client;

public class PolSysSoapServiceProxy implements polsys.soap.client.PolSysSoapService {
  private String _endpoint = null;
  private polsys.soap.client.PolSysSoapService polSysSoapService = null;
  
  public PolSysSoapServiceProxy() {
    _initPolSysSoapServiceProxy();
  }
  
  public PolSysSoapServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPolSysSoapServiceProxy();
  }
  
  private void _initPolSysSoapServiceProxy() {
    try {
      polSysSoapService = (new polsys.soap.client.PolSysSoapServiceServiceLocator()).getPolSysSoapServicePort();
      if (polSysSoapService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)polSysSoapService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)polSysSoapService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (polSysSoapService != null)
      ((javax.xml.rpc.Stub)polSysSoapService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public polsys.soap.client.PolSysSoapService getPolSysSoapService() {
    if (polSysSoapService == null)
      _initPolSysSoapServiceProxy();
    return polSysSoapService;
  }
  
  public boolean login(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (polSysSoapService == null)
      _initPolSysSoapServiceProxy();
    return polSysSoapService.login(arg0, arg1);
  }
  
  public boolean isLogin() throws java.rmi.RemoteException{
    if (polSysSoapService == null)
      _initPolSysSoapServiceProxy();
    return polSysSoapService.isLogin();
  }
  
  public java.lang.String[] viewPoll(int arg0, java.lang.String arg1, int arg2) throws java.rmi.RemoteException{
    if (polSysSoapService == null)
      _initPolSysSoapServiceProxy();
    return polSysSoapService.viewPoll(arg0, arg1, arg2);
  }
  
  public void closePoll(java.lang.String arg0) throws java.rmi.RemoteException{
    if (polSysSoapService == null)
      _initPolSysSoapServiceProxy();
    polSysSoapService.closePoll(arg0);
  }
  
  public java.lang.String createPoll(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (polSysSoapService == null)
      _initPolSysSoapServiceProxy();
    return polSysSoapService.createPoll(arg0, arg1, arg2);
  }
  
  public void createOptions(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (polSysSoapService == null)
      _initPolSysSoapServiceProxy();
    polSysSoapService.createOptions(arg0, arg1, arg2);
  }
  
  public java.lang.String getPoll(int arg0) throws java.rmi.RemoteException{
    if (polSysSoapService == null)
      _initPolSysSoapServiceProxy();
    return polSysSoapService.getPoll(arg0);
  }
  
  public java.lang.String[] getPolls() throws java.rmi.RemoteException{
    if (polSysSoapService == null)
      _initPolSysSoapServiceProxy();
    return polSysSoapService.getPolls();
  }
  
  
}