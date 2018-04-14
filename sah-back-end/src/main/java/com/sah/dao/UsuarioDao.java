package com.sah.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sah.model.Usuario;
// CrudRepository es un aspecto que viene con Spring
public interface UsuarioDao /**extends CrudRepository<Usuario,Integer>*/ {
	public Usuario login(String usuario, String contraseña);
	public Usuario consultarEnSesion(Integer idUsuario);
	public List<Usuario> consultarGeneral();
	public int eliminar(int idUsuario);
	public int agregar(Usuario usuario);
	public int editar(Usuario usuario);
	public Usuario consultarPorUsuario(String usuario, int id);
}
