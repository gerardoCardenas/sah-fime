package com.sah.dao;

import java.util.List;

import com.sah.model.Empleado;

public interface EmpleadoDao {
	public List<Empleado> consultar();

	public Empleado consultarPorId(Integer id);
	
	public int agregar(Empleado empleado);
	
	public int editar(Empleado empleado);
	
	public int eliminar(Integer id);
}
