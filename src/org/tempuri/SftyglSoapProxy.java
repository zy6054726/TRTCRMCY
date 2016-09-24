package org.tempuri;

public class SftyglSoapProxy implements org.tempuri.SftyglSoap {
  private String _endpoint = null;
  private org.tempuri.SftyglSoap sftyglSoap = null;
  
  public SftyglSoapProxy() {
    _initSftyglSoapProxy();
  }
  
  public SftyglSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initSftyglSoapProxy();
  }
  
  private void _initSftyglSoapProxy() {
    try {
      sftyglSoap = (new org.tempuri.SftyglLocator()).getsftyglSoap();
      if (sftyglSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sftyglSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sftyglSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sftyglSoap != null)
      ((javax.xml.rpc.Stub)sftyglSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.SftyglSoap getSftyglSoap() {
    if (sftyglSoap == null)
      _initSftyglSoapProxy();
    return sftyglSoap;
  }
  
  public java.lang.String addAccount(java.lang.String jsonStr) throws java.rmi.RemoteException{
    if (sftyglSoap == null)
      _initSftyglSoapProxy();
    return sftyglSoap.addAccount(jsonStr);
  }
  
  public java.lang.String modifyAccount(java.lang.String jsonStr) throws java.rmi.RemoteException{
    if (sftyglSoap == null)
      _initSftyglSoapProxy();
    return sftyglSoap.modifyAccount(jsonStr);
  }
  
  public java.lang.String disableAccount(java.lang.String rydm) throws java.rmi.RemoteException{
    if (sftyglSoap == null)
      _initSftyglSoapProxy();
    return sftyglSoap.disableAccount(rydm);
  }
  
  public java.lang.String enableAccount(java.lang.String rydm) throws java.rmi.RemoteException{
    if (sftyglSoap == null)
      _initSftyglSoapProxy();
    return sftyglSoap.enableAccount(rydm);
  }
  
  
}