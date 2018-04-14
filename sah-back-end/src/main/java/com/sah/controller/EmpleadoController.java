package com.sah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sah.model.Empleado;
import com.sah.service.EmpleadoService;

@RestController
@RequestMapping(value = "api/seguridad/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@RequestMapping(value = "/consultar/", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Empleado> consultar() {
		return empleadoService.consultar();
	}

	@RequestMapping(value = "/consultarPorId/", method = RequestMethod.GET, params = {
			"id" }, headers = "Accept=application/json")
	public Empleado consultarPorId(@RequestParam Integer id) {
		return empleadoService.consultarPorId(id);
	}

	@RequestMapping(value = "/agregar/", method = RequestMethod.POST, headers = "Accept=application/json")
	public int agregar(@RequestBody Empleado empleado) {
		return empleadoService.agregar(empleado);
	}

	@RequestMapping(value = "/editar/", method = RequestMethod.PUT, headers = "Accept=application/json")
	public int editar(@RequestBody Empleado empleado) {
		return empleadoService.editar(empleado);
	}

	@RequestMapping(value = "/eliminar/", method = RequestMethod.DELETE, params = {
			"id" }, headers = "Accept=application/json")
	public int eliminar(@RequestParam String id) {

		return empleadoService.eliminar(Integer.parseInt(id));
	}
}
