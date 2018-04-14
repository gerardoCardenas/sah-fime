package com.sah.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sah.dao.EmpleadoDao;
import com.sah.model.Empleado;
@Repository
public class EmpleadoDaoImpl implements EmpleadoDao {
	
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> consultar() {
		return em.createQuery("From Empleado").getResultList();
	}

	@Override
	public Empleado consultarPorId(Integer id) {
		return em.find(Empleado.class, id);
	}

	@Override
	public int agregar(Empleado empleado) {
		em.persist(empleado);
		return 1;
	}

	@Override
	public int editar(Empleado empleado) {
		em.merge(empleado);
		return 1;
	}

	@Override
	public int eliminar(Integer id) {
		Empleado empleado = em.find(Empleado.class,id);
		em.remove(empleado);
		return 1;
	}

}
