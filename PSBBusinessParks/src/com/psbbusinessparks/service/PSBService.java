package com.psbbusinessparks.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.psbbusinessparks.dao.PSBDao;
import com.psbbusinessparks.model.Tenant;

public class PSBService {
	PSBDao psbdao = new PSBDao();
public List<Tenant> compareTenantInfo(String addressLine1){
	Map<String, Tenant> mockData = psbdao.getMockData();
	List<Tenant> matchedTenantList = new ArrayList<Tenant>();
	for(Map.Entry<String, Tenant> pair : mockData.entrySet()){
		if(pair.getValue().getAddress().getAddressLine1().contains(addressLine1)){
			matchedTenantList.add(pair.getValue());
		}
	}
	return matchedTenantList;
	
}

public void saveTenantInfo(Tenant tenant){
	psbdao.saveTenantInfo(tenant);
	
}
}
