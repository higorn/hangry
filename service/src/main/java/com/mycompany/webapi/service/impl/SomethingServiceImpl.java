package com.mycompany.webapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.mycompany.webapi.model.dto.SomethingDTO;
import com.mycompany.webapi.model.entity.Something;
import com.mycompany.webapi.persistence.dao.SomethingDao;
import com.mycompany.webapi.service.SomethingService;

@Stateless
public class SomethingServiceImpl implements SomethingService {
	@Inject
	private SomethingDao dao;

	public List<SomethingDTO> getSomethings(final String filter) {
		List<Something> somethingList = dao.getAll(filter);
		return somethingList.stream()
			.map(something -> new SomethingDTO(something.getId(), something.getName()))
			.collect(Collectors.toList());
	}

}
