package com.teste.model;

import java.io.Serializable;

public class Supplier implements Serializable {

	private static final long serialVersionUID = 1L;

	private String supplierCode;
	private String supplierName;
	private String supplierAddress;
	private String companyCode;
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
