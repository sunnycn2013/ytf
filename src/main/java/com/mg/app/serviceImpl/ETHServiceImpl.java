package com.mg.app.serviceImpl;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.app.service.ETHService;
import com.mg.app.util.ETHUtils;

@Service("ETHService")
public class ETHServiceImpl implements ETHService{
	
	@Autowired
	ETHUtils ethutils;
	
	// 新建钱包
	@Override
	public JSONObject getNewaddress(String walletPassword) throws Exception {
		// TODO Auto-generated method stub
		String s = ethutils.main("eth_getBalance", "[\""+walletPassword+"\", \"latest\"]");
		JSONObject json = JSONObject.fromObject(s); 
        return json;
	}

	// 获取账户数量
	@Override
	public JSONObject eth_accounts() throws Exception {
		String s = ethutils.main("eth_accounts", "[]");
		JSONObject json = JSONObject.fromObject(s);
		return json;
	}

	@Override
	public JSONObject getbalance(String address) throws Exception {
		String s = ethutils.main("eth_getBalance", "[\""+address+"\", \"latest\"]");
		JSONObject json = JSONObject.fromObject(s); 
        return json;
	}
	
}
