package com.sah.service;

import java.util.List;

import com.sah.model.Usuario;

public interface UsuarioService {
	
	public Usuario login(String usuario,String contraseña) throws Exception;
	
	public Usuario consultarEnSesion(Integer idUsuario);

	public List<Usuario> consultarGeneral();
	
	public int eliminar(int idUsuario);
	
	public int agregar(Usuario usuario);
	
	public int editar(Usuario usuario);
	
}
