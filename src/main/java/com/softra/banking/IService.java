package com.softra.banking;

import java.io.Serializable;
import java.util.List;


//public interface IService {
//	
//	public List<User> findAll();
//	public User findById(int id);
//	public User save(User user);
//	public User deleteById(int id);
//
//
//}

public interface IService<T> {

   public T findById(int id);

   public List<T> findAll();

   public T save(T entity);

   public T deleteById(int id);
   
}
