package com.edu.uce.pw.api.repository;

import org.springframework.stereotype.Repository;

import com.edu.uce.pw.api.repository.modelo.Venta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VentaRepositoryImpl implements IVentaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Venta venta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(venta);
	}

}
