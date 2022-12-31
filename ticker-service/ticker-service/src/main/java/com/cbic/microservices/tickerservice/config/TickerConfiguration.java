package com.cbic.microservices.tickerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("ticker-service")
public class TickerConfiguration {
	private String ENC_KEY;
	private String ADMIN_DOC_SERVER_PATH;
	private String MSG_DIGEST_ALGO;

	public String getADMIN_DOC_SERVER_PATH() {
		return ADMIN_DOC_SERVER_PATH;
	}

	public void setADMIN_DOC_SERVER_PATH(String aDMIN_DOC_SERVER_PATH) {
		ADMIN_DOC_SERVER_PATH = aDMIN_DOC_SERVER_PATH;
	}

	public String getMSG_DIGEST_ALGO() {
		return MSG_DIGEST_ALGO;
	}

	public void setMSG_DIGEST_ALGO(String mSG_DIGEST_ALGO) {
		MSG_DIGEST_ALGO = mSG_DIGEST_ALGO;
	}

	public String getENC_KEY() {
		return ENC_KEY;
	}

	public void setENC_KEY(String eNC_KEY) {
		ENC_KEY = eNC_KEY;
	}

	public TickerConfiguration(String eNC_KEY, String aDMIN_DOC_SERVER_PATH, String mSG_DIGEST_ALGO) {
		super();
		ENC_KEY = eNC_KEY;
		ADMIN_DOC_SERVER_PATH = aDMIN_DOC_SERVER_PATH;
		MSG_DIGEST_ALGO = mSG_DIGEST_ALGO;
	}

	public TickerConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
