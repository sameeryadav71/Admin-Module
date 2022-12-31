package com.cbic.microservices.service;

import java.util.List;

import com.cbic.microservices.entity.CbicDocMst;

public interface CbicDocMstService {

	public CbicDocMst saveCbicDocMst(CbicDocMst cbicDocMst);
	public List<CbicDocMst> getAllCbicDocMst();
	public CbicDocMst findById(Long id);
	public CbicDocMst getCbicDocMstByRequestId(Integer requestId);

}
