package com.sah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sah.model.Usuario;
import com.sah.service.UsuarioService;

@RestController
@RequestMapping("api/seguridad/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/login/", method = RequestMethod.GET, params = { "usuario",
			"contrasena" }, headers = "Accept=application/json")
	public Usuario login(@RequestParam String usuario, @RequestParam String contrasena) throws Exception {
		return usuarioService.login(usuario, contrasena);
	}

	@RequestMapping(value = "/consultarEnSesion/", method = RequestMethod.GET, params = {
			"idUsuario" }, headers = "Accept=application/json")
	public Usuario consultarEnSesion(@RequestParam Integer idUsuario) {
		return usuarioService.consultarEnSesion(idUsuario);
	}

	@RequestMapping(value = "/consultar/", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Usuario> consultarGeneral() {
		return this.usuarioService.consultarGeneral();
	}

	@RequestMapping(value = "/eliminar/", method = RequestMethod.DELETE, params = {
			"idUsuario" }, headers = "Accept=application/json")
	public int eliminar(@RequestParam String idUsuario) {
		int id = Integer.parseInt(idUsuario);
		return this.usuarioService.eliminar(id);
	}
	@RequestMapping(value = "/agregar/", method = RequestMethod.POST, 
			headers = "Accept=application/json")
	public int agregar(@RequestBody Usuario usuario) {
		return usuarioService.agregar(usuario);
	}
	@RequestMapping(value = "/editar/", method = RequestMethod.PUT, 
			headers = "Accept=application/json")
	public int editar(@RequestBody Usuario usuario) {
		return usuarioService.editar(usuario);
	}
}
