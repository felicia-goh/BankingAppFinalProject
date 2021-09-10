package com.softra.banking;

import java.io.Serializable;
import java.util.List;

public interface IService<T> {

   public T findById(int id);
   public List<T> findAll();
   public T save(T entity);
   public T deleteById(int id);
   
}
