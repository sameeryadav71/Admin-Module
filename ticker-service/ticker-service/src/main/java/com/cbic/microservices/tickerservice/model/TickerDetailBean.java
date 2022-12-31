package com.cbic.microservices.tickerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerDetailBean {
	private String fileName_en;
	private String fileName_hi;
	private String fileHypertext;
	private long size;
	private String checkSum;
	private String path_en;
	private String path_hi;
	public String getFileName_en() {
		return path_hi;
	}
	public void setFileName_en(String fileName_en) {
		this.fileName_en = fileName_en;
	}
	public String getFileName_hi() {
		return fileName_hi;
	}
	public void setFileName_hi(String fileName_hi) {
		this.fileName_hi = fileName_hi;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getFileHypertext() {
		return fileHypertext;
	}
	public void setFileHypertext(String fileHypertext) {
		this.fileHypertext = fileHypertext;
	}
	public String getCheckSum() {
		return checkSum;
	}
	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}
	public String getPath_en() {
		return path_en;
	}
	public void setPath_en(String path_en) {
		this.path_en = path_en;
	}
	public String getPath_hi() {
		return path_hi;
	}
	public void setPath_hi(String path_hi) {
		this.path_hi = path_hi;
	}
	public TickerDetailBean(String fileName_en, String fileName_hi, String fileHyperText, long size, String checksum,
			String path_en, String path_hi) {
		super();
		this.fileName_en = fileName_en;
		this.fileName_hi = fileName_hi;
		this.fileHypertext = fileHyperText;
		this.size = size;
		this.checkSum = checksum;
		this.path_en = path_en;
		this.path_hi = path_hi;
	}
	public TickerDetailBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
