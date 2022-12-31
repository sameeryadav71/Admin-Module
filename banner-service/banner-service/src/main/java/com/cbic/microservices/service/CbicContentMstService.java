package com.cbic.microservices.service;

import java.util.List;

import com.cbic.microservices.entity.CbicContentMst;

public interface CbicContentMstService {

	public CbicContentMst saveCbicContentMst(CbicContentMst cbicContentMst);
	public List<CbicContentMst> getAllCbicContentMst();
	public CbicContentMst getCbicContentMstById(Integer id);
	public CbicContentMst getCbicContentMstByRequestId(Integer requestId);
}
