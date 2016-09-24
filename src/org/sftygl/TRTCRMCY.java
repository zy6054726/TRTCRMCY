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
		System.out.println("执行》》》");
		TRTCRMCY cy = new TRTCRMCY();
		cy.createUser("2016885", "王海涛", "", "", "WANGHAITAO@126.COM", "Test@2016");
//		cy.createUser("20183", "张勇2", "", "", "zhangyong9", "Aa123455");
//		cy.modifyUser("20181", "张勇3", "", "", "zhangyong10", "Test@2016");
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
	 * 创建
	 * 
	 * @param rydm
	 *            员工编号 RYDM
	 * @param userName
	 *            姓名 PERSON_NAME
	 * @param pym
	 *            拼音码 PYM 不传
	 * @param bmdm
	 *            部门编号 BMDM
	 * @param userType
	 *            员工类别 WORK_TYPE
	 * @param status
	 *            员工状态 STATUS
	 * @param loginName
	 *            登录名 LOGINNAME
	 * @param passWord
	 *            登陆密码 LOGIN_PASSWORD
	 * @return
	 */
	// public String createUser(String rydm,String userName,String pym,String
	// bmdm,String userType,String status,String loginName,String passWord){

	public String createUser(String rydm, String userName, String bmdm,
			String status, String loginName, String passWord) {
		System.out.println("create CRM长益 >>rydm:" + rydm + "\n userName:"
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
			System.out.println("转成json类型：" + json);
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
			System.out.println(rydm + "创建成功");
		} else if (returnCode.equals("001")) {
			System.out.println(rydm + "帐号已经存在");
		} else if (returnCode.equals("003")) {
			System.out.println(rydm + "帐号创建失败");
		}
		System.out.println("create 返回值：" + returnCode);
		return returnCode;
	}

	/**
	 * 修改
	 * 
	 * @param rydm
	 *            员工编号 RYDM
	 * @param userName
	 *            姓名 PERSON_NAME
	 * @param pym
	 *            拼音码 PYM
	 * @param bmdm
	 *            部门编号 BMDM
	 * @param userType
	 *            员工类别 WORK_TYPE
	 * @param status
	 *            员工状态 STATUS
	 * @param loginName
	 *            登录名 LOGINNAME
	 * @param passWord
	 *            登陆密码 LOGIN_PASSWORD
	 * @return
	 */

	// public String modifyUser(String rydm,String userName,String pym,String
	// bmdm,String userType,String status,String loginName,String passWord){

	public String modifyUser(String rydm, String userName, String bmdm,
			String status, String loginName, String passWord) {

		System.out.println("modify CRM长益 >>rydm:" + rydm + "\n userName:"
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
			System.out.println("转成json类型：" + json);
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
			System.out.println(rydm + "修改帐号成功");
		} else if (returnCode.equals("101")) {
			System.out.println(rydm + "修改帐号不存在");
		} else if (returnCode.equals("103")) {
			System.out.println(rydm + "修改帐号失败");
		}

		System.out.println("modify 返回值：" + returnCode);
		return returnCode;
	}

	/**
	 * 禁用
	 * 
	 * @param rydm
	 *            员工编号
	 * @return
	 */
	public String disableUser(String rydm) {

		System.out.println("disable CRM长益 >>rydm:" + rydm);
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
			System.out.println(rydm + "帐号禁用成功");
		} else if (returnCode.equals("201")) {
			System.out.println(rydm + "帐号不存在");
		} else if (returnCode.equals("203")) {
			System.out.println(rydm + "帐号禁用失败");
		}
		System.out.println("disable 返回值：" + returnCode);
		return returnCode;
	}

	/**
	 * 启用
	 * 
	 * @param rydm
	 *            员工编号
	 * @return
	 */
	public String enableUser(String rydm) {

		System.out.println("eanble CRM长益 >>rydm:" + rydm);
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
			System.out.println(rydm + "帐号启用成功");
		} else if (returnCode.equals("201")) {
			System.out.println(rydm + "帐号不存在");
		} else if (returnCode.equals("203")) {
			System.out.println(rydm + "帐号启用失败");
		}
		System.out.println("enable 返回值：" + returnCode);
		return returnCode;
	}

}
