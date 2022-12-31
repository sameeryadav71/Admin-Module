package com.cbic.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbic.microservices.entity.CbicDocMst;
import com.cbic.microservices.repository.CbicDocMstRepository;

@Service
public class CbicDocMstServiceImpl implements CbicDocMstService {

	@Autowired
	private CbicDocMstRepository cbicDocMstRepository;

	@Override
	public CbicDocMst saveCbicDocMst(CbicDocMst cbicDocMst) {
		CbicDocMst docMst = null;
		try {
			docMst = cbicDocMstRepository.save(cbicDocMst);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return docMst;
	}

	@Override
	public List<CbicDocMst> getAllCbicDocMst() {
		List<CbicDocMst> cbicDocMsts = null;
		try {
			cbicDocMsts = cbicDocMstRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cbicDocMsts;
	}

	@Override
	public CbicDocMst findById(Long id) {
		Optional<CbicDocMst> findById = null;
		try {
			findById = cbicDocMstRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != findById && null != findById.get()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public CbicDocMst getCbicDocMstByRequestId(Integer requestId) {
		CbicDocMst findById = null;
		try {
			findById = cbicDocMstRepository.findByRequestId(requestId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findById;
	}

}
