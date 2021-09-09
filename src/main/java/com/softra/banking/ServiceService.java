package com.softra.banking;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("service")
public class ServiceService implements IService<ServiceRequest> {

	@Autowired
	@Qualifier("serviceJPA")
	private IDao<ServiceRequest> dao;

	public ServiceService() {
		System.out.println("ServiceService.ServiceService()");
	}

	@Override
	public ServiceRequest findById(int id) {
		System.out.println("ServiceService.findById()");
		Optional<ServiceRequest> request = dao.findById(id);
		return request.isPresent() ? dao.findById(id).get() : null;
	}

	@Override
	public List<ServiceRequest> findAll() {
		// no definition
		return null;
	}

	@Override
	public ServiceRequest save(ServiceRequest request) {
		System.out.println("ServiceService.save()");
		return dao.save(request);
	}

	@Override
	public ServiceRequest deleteById(int id) {
		// no definition
		return null;
	}

}
