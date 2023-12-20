package org.rnt.com.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("proPertyService")
public class ProPertyService {
    
    @Value("${factoryCd}")
    private String factoryCd;
    
	public String getFactoryCd() {
		return factoryCd;
	}

	public void setFactoryCd(String factoryCd) {
		this.factoryCd = factoryCd;
	}
}
