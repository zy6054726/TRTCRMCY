/**
 * SftyglSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface SftyglSoap extends java.rmi.Remote {

    /**
     * 创建账号
     */
    public java.lang.String addAccount(java.lang.String jsonStr) throws java.rmi.RemoteException;

    /**
     * 修改账号
     */
    public java.lang.String modifyAccount(java.lang.String jsonStr) throws java.rmi.RemoteException;

    /**
     * 禁用账号
     */
    public java.lang.String disableAccount(java.lang.String rydm) throws java.rmi.RemoteException;

    /**
     * 启用账号
     */
    public java.lang.String enableAccount(java.lang.String rydm) throws java.rmi.RemoteException;
}
