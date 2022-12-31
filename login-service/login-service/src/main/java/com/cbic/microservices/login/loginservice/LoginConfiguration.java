package com.cbic.microservices.login.loginservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("login-service")
public class LoginConfiguration {
	private String LDAP_OID_USER;
	private String LDAP_PASSWORD;
	private String LDAP_URL;
	private String LDAP_PORT;
	
	private String LDAP_CONTEXT_FACTORY;
	private String LOGIN_DC;
	private String COLON;
	private String LOGIN_UID;
	private String SECURITY_AUTH_SIMPLE;
	private String LDAP_DOMAIN;
	private String COMMA;
	private String LOGIN_CN;
	public String getLDAP_OID_USER() {
		return LDAP_OID_USER;
	}
	public void setLDAP_OID_USER(String lDAP_OID_USER) {
		LDAP_OID_USER = lDAP_OID_USER;
	}
	public String getLDAP_PASSWORD() {
		return LDAP_PASSWORD;
	}
	public void setLDAP_PASSWORD(String lDAP_PASSWORD) {
		LDAP_PASSWORD = lDAP_PASSWORD;
	}
	public String getLDAP_URL() {
		return LDAP_URL;
	}
	public void setLDAP_URL(String lDAP_URL) {
		LDAP_URL = lDAP_URL;
	}
	public String getLDAP_PORT() {
		return LDAP_PORT;
	}
	public void setLDAP_PORT(String lDAP_PORT) {
		LDAP_PORT = lDAP_PORT;
	}
	public String getLDAP_CONTEXT_FACTORY() {
		return LDAP_CONTEXT_FACTORY;
	}
	public void setLDAP_CONTEXT_FACTORY(String lDAP_CONTEXT_FACTORY) {
		LDAP_CONTEXT_FACTORY = lDAP_CONTEXT_FACTORY;
	}
	public String getLOGIN_DC() {
		return LOGIN_DC;
	}
	public void setLOGIN_DC(String lOGIN_DC) {
		LOGIN_DC = lOGIN_DC;
	}
	public String getCOLON() {
		return COLON;
	}
	public void setCOLON(String cOLON) {
		COLON = cOLON;
	}
	public String getLOGIN_UID() {
		return LOGIN_UID;
	}
	public void setLOGIN_UID(String lOGIN_UID) {
		LOGIN_UID = lOGIN_UID;
	}
	public String getSECURITY_AUTH_SIMPLE() {
		return SECURITY_AUTH_SIMPLE;
	}
	public void setSECURITY_AUTH_SIMPLE(String sECURITY_AUTH_SIMPLE) {
		SECURITY_AUTH_SIMPLE = sECURITY_AUTH_SIMPLE;
	}
	public String getLDAP_DOMAIN() {
		return LDAP_DOMAIN;
	}
	public void setLDAP_DOMAIN(String lDAP_DOMAIN) {
		LDAP_DOMAIN = lDAP_DOMAIN;
	}
	public String getCOMMA() {
		return COMMA;
	}
	public void setCOMMA(String cOMMA) {
		COMMA = cOMMA;
	}
	public String getLOGIN_CN() {
		return LOGIN_CN;
	}
	public void setLOGIN_CN(String lOGIN_CN) {
		LOGIN_CN = lOGIN_CN;
	}
	public LoginConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginConfiguration(String lDAP_OID_USER, String lDAP_PASSWORD, String lDAP_URL, String lDAP_PORT,
			String lDAP_CONTEXT_FACTORY, String lOGIN_DC, String cOLON, String lOGIN_UID, String sECURITY_AUTH_SIMPLE,
			String lDAP_DOMAIN, String cOMMA, String lOGIN_CN) {
		super();
		LDAP_OID_USER = lDAP_OID_USER;
		LDAP_PASSWORD = lDAP_PASSWORD;
		LDAP_URL = lDAP_URL;
		LDAP_PORT = lDAP_PORT;
		LDAP_CONTEXT_FACTORY = lDAP_CONTEXT_FACTORY;
		LOGIN_DC = lOGIN_DC;
		COLON = cOLON;
		LOGIN_UID = lOGIN_UID;
		SECURITY_AUTH_SIMPLE = sECURITY_AUTH_SIMPLE;
		LDAP_DOMAIN = lDAP_DOMAIN;
		COMMA = cOMMA;
		LOGIN_CN = lOGIN_CN;
	}

	

}
