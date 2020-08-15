package com.ps.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("custInfo")
@ConfigurationProperties(prefix = "cust.info")
public class CustomerInfo {

	//Simple properties
	private int cNo;
	private String cName;
	//Array properties
	private String[] addresses;
	//List properties
	private List<String> nicknames;
	//Map properties
	private Map<String,Long> phones;
	
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String[] getAddresses() {
		return addresses;
	}
	public void setAddresses(String[] addresses) {
		this.addresses = addresses;
	}
	public List<String> getNicknames() {
		return nicknames;
	}
	public void setNicknames(List<String> nicknames) {
		this.nicknames = nicknames;
	}
	public Map<String, Long> getPhones() {
		return phones;
	}
	public void setPhones(Map<String, Long> phones) {
		this.phones = phones;
	}
	
	@Override
	public String toString() {
		return "CustomerInfo [cNo=" + cNo + ", cName=" + cName + ", addresses=" + Arrays.toString(addresses)
				+ ", nicknames=" + nicknames + ", phones=" + phones + "]";
	}	
	
}
