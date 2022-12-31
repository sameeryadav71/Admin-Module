package com.cbic.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbic.microservices.entity.CbicContentMst;
import com.cbic.microservices.repository.CbicContentMstRepository;

@Service
public class CbicContentMstServiceImpl implements CbicContentMstService{

	@Autowired
	private CbicContentMstRepository cbicContentMstRepository;
	
	@Override
	public CbicContentMst saveCbicContentMst(CbicContentMst cbicContentMst) {
		CbicContentMst contentMst = null;
		try {
			contentMst = cbicContentMstRepository.save(cbicContentMst);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentMst;
	}

	@Override
	public List<CbicContentMst> getAllCbicContentMst() {
		List<CbicContentMst> cbicContentMsts = null;
		try {
			cbicContentMsts = cbicContentMstRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cbicContentMsts;
	}

	@Override
	public CbicContentMst getCbicContentMstById(Integer id) {
		Optional<CbicContentMst> findById = null;
		try {
			findById = cbicContentMstRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != findById && null != findById.get()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public CbicContentMst getCbicContentMstByRequestId(Integer requestId) {
		CbicContentMst findById = null;
		try {
			findById = cbicContentMstRepository.findByRequestId(requestId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findById;
	}

}
