package com.psbbusinessparks.dao;

import java.util.Map;

import com.psbbusinessparks.mockdata.TenantMockData;
import com.psbbusinessparks.model.Tenant;

public class PSBDao {
	TenantMockData tenantMockData = new TenantMockData();
	
public void saveTenantInfo(Tenant tenant){
	tenantMockData.saveTenantInfo(tenant);
}

public Map<String, Tenant> getMockData(){
	return tenantMockData.getMockDataMap();
	
}
}
