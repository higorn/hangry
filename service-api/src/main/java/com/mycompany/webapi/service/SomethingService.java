package com.mycompany.webapi.service;

import java.util.List;

import com.mycompany.webapi.model.dto.SomethingDTO;


public interface SomethingService {
	List<SomethingDTO> getSomethings(String filter);
}
