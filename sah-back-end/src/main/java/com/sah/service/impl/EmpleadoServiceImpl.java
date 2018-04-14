package com.sah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sah.dao.EmpleadoDao;
import com.sah.model.Empleado;
import com.sah.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoDao empleadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> consultar() {
		return this.empleadoDao.consultar();
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado consultarPorId(Integer id) {
		return this.consultarPorId(id);
	}
	@Transactional()// Abre la conexion con la base de datos
	@Override
	public int agregar(Empleado empleado) {
		return empleadoDao.agregar(empleado);
	}
	@Transactional()
	@Override
	public int editar(Empleado empleado) {
		return empleadoDao.editar(empleado);
	}
	@Transactional()
	@Override
	public int eliminar(Integer id) {
		return empleadoDao.eliminar(id);
	}

}
