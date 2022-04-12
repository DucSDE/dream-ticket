package com.hutech.ticket.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class IRepositoryImpl<T,ID> implements IRepository<T,ID>{
	
	@PersistenceContext
	private EntityManager em;

}
