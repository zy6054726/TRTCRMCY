package org.sftygl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import net.sf.json.JSONObject;

import org.apache.axis.AxisFault;
import org.tempuri.SftyglLocator;
import org.tempuri.SftyglSoapStub;

public class TRTCRMCY {
	private String url;

	public static void main(String[] args) {
		System.out.println("ִ�С�����");
		TRTCRMCY cy = new TRTCRMCY();
		cy.createUser("2016885", "������", "", "", "WANGHAITAO@126.COM", "Test@2016");
//		cy.createUser("20183", "����2", "", "", "zhangyong9", "Aa123455");
//		cy.modifyUser("20181", "����3", "", "", "zhangyong10", "Test@2016");
//		cy.disableUser("20181");
//		cy.enableUser("20181");
	}

	public TRTCRMCY() {
		url = "http://10.8.147.167:81/bflib/WebService/sftygl.asmx?wsdl";
	}

	public TRTCRMCY(String url) {
		this.url = url;
	}

	/**
	 * ����
	 * 
	 * @param rydm
	 *            Ա����� RYDM
	 * @param userName
	 *            ���� PERSON_NAME
	 * @param pym
	 *            ƴ���� PYM ����
	 * @param bmdm
	 *            ���ű�� BMDM
	 * @param userType
	 *            Ա����� WORK_TYPE
	 * @param status
	 *            Ա��״̬ STATUS
	 * @param loginName
	 *            ��¼�� LOGINNAME
	 * @param passWord
	 *            ��½���� LOGIN_PASSWORD
	 * @return
	 */
	// public String createUser(String rydm,String userName,String pym,String
	// bmdm,String userType,String status,String loginName,String passWord){

	public String createUser(String rydm, String userName, String bmdm,
			String status, String loginName, String passWord) {
		System.out.println("create CRM���� >>rydm:" + rydm + "\n userName:"
				+ userName + "\n bmdm:" + bmdm + "\n status:" + status
				+ "\n loginName:" + loginName + "\n passWord:" + passWord);
		String returnCode = "";
		Map<String, String> map = new HashMap<String, String>();
		map.put("RYDM", rydm);
		map.put("PERSON_NAME", userName);
		map.put("BMDM", bmdm);
		map.put("STATUS", status);
		map.put("LOGINNAME", loginName);
		map.put("LOGIN_PASSWORD", passWord);
		try {
			String json = JSONObject.fromObject(map).toString();
			System.out.println("ת��json���ͣ�" + json);
			SftyglLocator sft = new SftyglLocator();
			SftyglSoapStub sst = (SftyglSoapStub) sft.getsftyglSoap();

			returnCode = sst.addAccount(json);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (returnCode.equals("000")) {
			System.out.println(rydm + "�����ɹ�");
		} else if (returnCode.equals("001")) {
			System.out.println(rydm + "�ʺ��Ѿ�����");
		} else if (returnCode.equals("003")) {
			System.out.println(rydm + "�ʺŴ���ʧ��");
		}
		System.out.println("create ����ֵ��" + returnCode);
		return returnCode;
	}

	/**
	 * �޸�
	 * 
	 * @param rydm
	 *            Ա����� RYDM
	 * @param userName
	 *            ���� PERSON_NAME
	 * @param pym
	 *            ƴ���� PYM
	 * @param bmdm
	 *            ���ű�� BMDM
	 * @param userType
	 *            Ա����� WORK_TYPE
	 * @param status
	 *            Ա��״̬ STATUS
	 * @param loginName
	 *            ��¼�� LOGINNAME
	 * @param passWord
	 *            ��½���� LOGIN_PASSWORD
	 * @return
	 */

	// public String modifyUser(String rydm,String userName,String pym,String
	// bmdm,String userType,String status,String loginName,String passWord){

	public String modifyUser(String rydm, String userName, String bmdm,
			String status, String loginName, String passWord) {

		System.out.println("modify CRM���� >>rydm:" + rydm + "\n userName:"
				+ userName + "\n bmdm:" + bmdm + "\n status:" + status
				+ "\n loginName:" + loginName + "\n passWord:" + passWord);
		String returnCode = "";
		Map<String, String> map = new HashMap<String, String>();
		map.put("RYDM", rydm);
		map.put("PERSON_NAME", userName);
		map.put("BMDM", bmdm);
		map.put("STATUS", status);
		map.put("LOGINNAME", loginName);
		map.put("LOGIN_PASSWORD", passWord);
		try {
			String json = JSONObject.fromObject(map).toString();
			System.out.println("ת��json���ͣ�" + json);
			SftyglLocator sft = new SftyglLocator();
			SftyglSoapStub sst = (SftyglSoapStub) sft.getsftyglSoap();

			returnCode = sst.modifyAccount(json);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (returnCode.equals("100")) {
			System.out.println(rydm + "�޸��ʺųɹ�");
		} else if (returnCode.equals("101")) {
			System.out.println(rydm + "�޸��ʺŲ�����");
		} else if (returnCode.equals("103")) {
			System.out.println(rydm + "�޸��ʺ�ʧ��");
		}

		System.out.println("modify ����ֵ��" + returnCode);
		return returnCode;
	}

	/**
	 * ����
	 * 
	 * @param rydm
	 *            Ա�����
	 * @return
	 */
	public String disableUser(String rydm) {

		System.out.println("disable CRM���� >>rydm:" + rydm);
		String returnCode = "";
		try {
			SftyglLocator sft = new SftyglLocator();
			SftyglSoapStub sst = (SftyglSoapStub) sft.getsftyglSoap();

			returnCode = sst.disableAccount(rydm);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (returnCode.equals("200")) {
			System.out.println(rydm + "�ʺŽ��óɹ�");
		} else if (returnCode.equals("201")) {
			System.out.println(rydm + "�ʺŲ�����");
		} else if (returnCode.equals("203")) {
			System.out.println(rydm + "�ʺŽ���ʧ��");
		}
		System.out.println("disable ����ֵ��" + returnCode);
		return returnCode;
	}

	/**
	 * ����
	 * 
	 * @param rydm
	 *            Ա�����
	 * @return
	 */
	public String enableUser(String rydm) {

		System.out.println("eanble CRM���� >>rydm:" + rydm);
		String returnCode = "";
		try {
			SftyglLocator sft = new SftyglLocator();
			SftyglSoapStub sst = (SftyglSoapStub) sft.getsftyglSoap();

			returnCode = sst.enableAccount(rydm);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (returnCode.equals("300")) {
			System.out.println(rydm + "�ʺ����óɹ�");
		} else if (returnCode.equals("201")) {
			System.out.println(rydm + "�ʺŲ�����");
		} else if (returnCode.equals("203")) {
			System.out.println(rydm + "�ʺ�����ʧ��");
		}
		System.out.println("enable ����ֵ��" + returnCode);
		return returnCode;
	}

}
