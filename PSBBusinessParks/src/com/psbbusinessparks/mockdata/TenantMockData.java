package com.psbbusinessparks.mockdata;

import java.util.HashMap;
import java.util.Map;

import com.psbbusinessparks.model.Tenant;

public class TenantMockData {
Map<String, Tenant> tenantMap = new HashMap<String, Tenant>();

public void saveTenantInfo(Tenant tenant){
	
	tenantMap.put(tenant.getTenantName(), tenant);
	
}
public Map<String, Tenant> getMockDataMap(){
	
	
	return tenantMap;
	
}
}
