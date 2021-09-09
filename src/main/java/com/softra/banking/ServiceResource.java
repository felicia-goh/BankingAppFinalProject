package com.softra.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceResource  {
  
  @Autowired
  @Qualifier("service")
  private IService<ServiceRequest> service;
  
  public ServiceResource() {
    System.out.println("ServiceResource.ServiceResource()");
  }
  
  
  // displays service request number
  @PostMapping("/services/new")
  public int createServiceRequest(@RequestBody ServiceRequest request) {
	  System.out.println("ServiceResource.createServiceRequest()");
	ServiceRequest returnRequest = service.save(request);
    return returnRequest.getId();
  }
  
  // return status of the service request
  @GetMapping("/users/{request_id}/services")
  public String retrieveServiceRequest(@PathVariable int id) {
	  System.out.println("ServiceResource.retrieveServiceRequest()");
	  
	  ServiceRequest request = service.findById(id);
	  if (request == null) {
		  return null;
	  }
	  return request.getStatus();
  }
 
}
