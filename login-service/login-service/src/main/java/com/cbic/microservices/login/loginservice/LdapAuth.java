package com.cbic.microservices.login.loginservice;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LdapAuth{

//	@Autowired
//	MasterDataDao masterDataDao;
	
	@Autowired
	private LoginConfiguration loginConfiguration;
	
	@Autowired
	private LoginDataDao loginDataDao;
	
//	private static final Logger logger = Logger.getLogger(LdapAuth.class);

	public String authenticateUser(String ssoid, String pass) throws NamingException {
//	public void authenticateUser(String ssoid, String pass) throws NamingException {
		String msg = "true";
		if (null != ssoid && !ssoid.isEmpty() && null != pass && !pass.isEmpty()) {
//			logger.info("Entering into authenticateUser method of LdapAuth");
			DirContext context = getOIDConnection();
			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
			String filter = loginConfiguration.getLOGIN_UID() + ssoid;
			NamingEnumeration<SearchResult> results = context.search(loginConfiguration.getLOGIN_DC(), filter, constraints);
//			logger.info(results.hasMore());
			if (results.hasMore()) {
				SearchResult result = results.next();
				String dn = result.getNameInNamespace();
				DirContext ctx = null;
				Hashtable<String, String> env = new Hashtable<String, String>();
				String host = loginConfiguration.getLDAP_URL();
				String port = loginConfiguration.getLDAP_PORT();
				env.put(Context.INITIAL_CONTEXT_FACTORY, loginConfiguration.getLDAP_CONTEXT_FACTORY());
				env.put(Context.PROVIDER_URL, loginConfiguration.getLDAP_DOMAIN() + host + loginConfiguration.getCOLON() + port);
				env.put(Context.SECURITY_AUTHENTICATION, "simple");
				env.put(Context.SECURITY_PRINCIPAL, dn);
				env.put(Context.SECURITY_CREDENTIALS, pass);

				try {
					ctx = new InitialDirContext(env);
//					logger.info("Connected,Login Validation Successful");

				} catch (AuthenticationNotSupportedException ex) {
					msg = "Incorrect Password/Username or Account is Locked";
//					logger.error("The authentication is not supported by the server", ex);
				} catch (AuthenticationException ex) {
					msg = "Incorrect Password/Username or Account is Locked";
//					logger.error("Incorrect password or username or Account is Locked.", ex);
				} catch (NamingException ex) {
					msg = "Please try after sometime";
//					logger.error("Error when trying to Create the context", ex);
				} finally {
					if (null != ctx) {
						try {
							ctx.close();
						} catch (NamingException ex) {
							msg = "Error when trying to close the context";
//							logger.error("Error when trying to close the context", ex);
						}
					}
				}
			} else {
				msg = "Invalid Credentials";
			}
		} else {
			msg = "Unauthorized Access";
		}
//		logger.info("Returning from authenticateUser method of LdapAuth");
		return msg;
	}

public DirContext getOIDConnection() {
//		logger.info("Entering into getOIDConnection method of LdapAuth");
		DirContext context = null;
		Properties initialProperties = new Properties();
		String host = loginConfiguration.getLDAP_URL();
		String port = loginConfiguration.getLDAP_PORT();
		String uname = loginConfiguration.getLOGIN_UID() + loginConfiguration.getLDAP_OID_USER() + loginConfiguration.getCOMMA() + loginConfiguration.getLOGIN_CN()
				+ loginConfiguration.getCOMMA() + loginConfiguration.getLOGIN_DC();
		initialProperties.put(Context.INITIAL_CONTEXT_FACTORY, loginConfiguration.getLDAP_CONTEXT_FACTORY());
		initialProperties.put(Context.PROVIDER_URL, loginConfiguration.getLDAP_DOMAIN() + host + loginConfiguration.getCOLON() + port);
		initialProperties.put(Context.SECURITY_AUTHENTICATION, loginConfiguration.getSECURITY_AUTH_SIMPLE());
		initialProperties.put(Context.SECURITY_PRINCIPAL, uname);
		initialProperties.put(Context.SECURITY_CREDENTIALS, loginConfiguration.getLDAP_PASSWORD());
		try {
			System.out.println("Initialising connection");
			context = new InitialDirContext(initialProperties);
			System.out.println("Got context");
		} catch (NamingException e) {
			System.out.println("Error while connecting with OUD : "+ e);
		}
//		logger.info("Returning from getOIDConnection method of LdapAuth");
		return context;
	}

	public List<String> getUserRoles(String username) throws Exception {
		return loginDataDao.getUserRoles(username);
		//return new ArrayList<String>();
	}

	public List<String> getUserRolesName(String username) throws Exception {
//		return masterDataDao.getUserRolesName(username);
		return new ArrayList<String>();
	}

	public Optional<LdapUserDetailBean> getUserDetail(String ssoid) throws NamingException {
//		logger.info("Entering into getUserDetail method of LdapAuth");
		DirContext context = getOIDConnection();
		SearchControls constraints = new SearchControls();
		constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
		String filter = loginConfiguration.getLOGIN_UID() + ssoid;
		NamingEnumeration<SearchResult> results = context.search(loginConfiguration.getLOGIN_DC(), filter, constraints);
		LdapUserDetailBean bean = new LdapUserDetailBean();
		if (results.hasMore()) {
			SearchResult result = results.next();
			Attributes att = result.getAttributes();
			bean.setUserName(att.get("displayname").get().toString().trim());
			bean.setMobile(att.get("mobilenumber").get().toString().trim());
			bean.setEmail(att.get("emailaddress").get().toString().trim());
			bean.setSsoId(att.get("uidnumber").get().toString().trim());
			return Optional.of(bean);
		}
		return Optional.ofNullable(bean);
	}

//	public static String authenticateUserTest(String ssoid, String pass) throws NamingException {
//		String msg = "true";
//		if (null != ssoid && !ssoid.isEmpty() && null != pass && !pass.isEmpty() && pass.length() <= 20
//				&& ssoid.length() == 8 && Pattern.compile("-?\\d+(\\.\\d+)?").matcher(ssoid).matches()) {
////			logger.info("Entering into authenticateUser method of LdapAuth");
//			DirContext context = getOIDConnectionTest();
//			SearchControls constraints = new SearchControls();
//			constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
//			String filter = loginConfiguration.getLOGIN_UID() + ssoid;
//			NamingEnumeration<SearchResult> results = context.search(Constants.LOGIN_DC, filter, constraints);
//			logger.info(results.hasMore());
//			if (results.hasMore()) {
//				SearchResult result = results.next();
//				String dn = result.getNameInNamespace();
//				DirContext ctx = null;
//				Hashtable<String, String> env = new Hashtable<String, String>();
//				// String host = "10.1.9.66";
//				String host = "10.1.8.107";
//				String port = "1389";
//				env.put(Context.INITIAL_CONTEXT_FACTORY, Constants.LDAP_CONTEXT_FACTORY);
//				env.put(Context.PROVIDER_URL, Constants.LDAP_DOMAIN + host + Constants.COLON + port);
//				env.put(Context.SECURITY_AUTHENTICATION, "simple");
//				env.put(Context.SECURITY_PRINCIPAL, dn);
//				env.put(Context.SECURITY_CREDENTIALS, pass);
//
//				try {
//					ctx = new InitialDirContext(env);
////					logger.info("Connected,Login Validation Successful");
//
//				} catch (AuthenticationNotSupportedException ex) {
//					msg = "Incorrect Password/Username or Account is Locked";
////					logger.error("The authentication is not supported by the server", ex);
//				} catch (AuthenticationException ex) {
//					msg = "Incorrect Password/Username or Account is Locked";
////					logger.error("Incorrect password or username or Account is Locked.", ex);
//				} catch (NamingException ex) {
//					msg = "Please try after sometime";
////					logger.error("Error when trying to Create the context", ex);
//				} finally {
//					if (null != ctx) {
//						try {
//							ctx.close();
//						} catch (NamingException ex) {
//							msg = "Error when trying to close the context";
////							logger.error("Error when trying to close the context", ex);
//						}
//					}
//				}
//			} else {
//				msg = "Invalid Credentials";
//			}
//		} else {
//			msg = "Unauthorized Access";
//		}
////		logger.info("Returning from authenticateUser method of LdapAuth");
//		return msg;
//	}

//	public static DirContext getOIDConnectionTest() {
////		logger.info("Entering into getOIDConnection method of LdapAuth");
//		DirContext context = null;
//		Properties initialProperties = new Properties();
//		// String host = "10.1.9.66";
//		String host = "10.1.8.107";
//		String port = "1389";
//		/*
//		 * String uname = Constants.LOGIN_UID + "vms" + Constants.COMMA +
//		 * Constants.LOGIN_CN + Constants.COMMA + Constants.LOGIN_DC;
//		 */
//		String uname = Constants.LOGIN_UID + "vms_prod" + Constants.COMMA + Constants.LOGIN_CN + Constants.COMMA
//				+ Constants.LOGIN_DC;
//		initialProperties.put(Context.INITIAL_CONTEXT_FACTORY, Constants.LDAP_CONTEXT_FACTORY);
//		initialProperties.put(Context.PROVIDER_URL, Constants.LDAP_DOMAIN + host + Constants.COLON + port);
//		initialProperties.put(Context.SECURITY_AUTHENTICATION, Constants.SECURITY_AUTH_SIMPLE);
//		initialProperties.put(Context.SECURITY_PRINCIPAL, uname);
//		initialProperties.put(Context.SECURITY_CREDENTIALS, "India@2021");
//		try {
//			System.out.println("Initialising connection");
//			context = new InitialDirContext(initialProperties);
//			System.out.println("Got context");
//		} catch (NamingException e) {
//			e.printStackTrace();
////			logger.error("Error while connecting with OUD", e);
//		}
////		logger.info("Returning from getOIDConnection method of LdapAuth");
//		return context;
//	}

//	public static void main(String[] args) {
//		try {
////			authenticateUserTest("27003183", "********");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
}