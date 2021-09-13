package com.softra.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softra.banking.Exception.AccountNotFoundException;

@RestController
@CrossOrigin("*")
public class ServiceRequestResource  {
  
  @Autowired
  @Qualifier("serviceRequest")
  private IService<ServiceRequest> service;
  
  @Autowired
  @Qualifier("account")
  private IService<Account> accountService;
  
  public ServiceRequestResource() {
    System.out.println("ServiceResource.ServiceResource()");
  }
  
  
  // displays service request number
  @PostMapping("accounts/{account_id}/services/new")
  public ServiceRequest createServiceRequest(@PathVariable("account_id") int account_id, @RequestBody ServiceRequest request) throws AccountNotFoundException {
	  System.out.println("ServiceResource.createServiceRequest()");
	  Account account = accountService.findById(account_id);
	  if (account.getId() != 0) {
		  request.setAccount(account);
		  ServiceRequest returnRequest = service.save(request);	  
		  return returnRequest;
	  } else {
		  throw new AccountNotFoundException("Account with id " + account_id + " not found");
	  }
	  
  }
  
  // return status of the service request
  @GetMapping("/accounts/{account_id}/services/{service_id}")
  public String retrieveServiceRequest(@PathVariable("account_id") int account_id, @PathVariable("service_id") int service_id) {
	  System.out.println("ServiceResource.retrieveServiceRequest()");
	  
	  ServiceRequest request = service.findById(service_id);
	  return request == null ? null : request.getStatus();

  }
 
}
