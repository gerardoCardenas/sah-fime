package com.sah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sah.dao.UsuarioDao;
import com.sah.general.GeneralValidatorService;
import com.sah.model.Usuario;
import com.sah.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired // Injecta la interfaz UsuarioDao en el contenedor de Spring
	private UsuarioDao usuarioDao;

	private GeneralValidatorService validator = new GeneralValidatorService();

	@Override
	@Transactional(readOnly = true)
	public Usuario login(String usuario, String contraseña) throws Exception {
		Usuario usuarioLogin = usuarioDao.login(usuario, contraseña);
		if (usuarioLogin == null) {
			throw new Exception("El usuario o la contraseña son invalidos");
		} else {
			return usuarioLogin;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario consultarEnSesion(Integer idUsuario) {
		return usuarioDao.consultarEnSesion(idUsuario);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> consultarGeneral() {
		return this.usuarioDao.consultarGeneral();
	}

	@Transactional()
	@Override
	public int eliminar(int idUsuario) {
		return this.usuarioDao.eliminar(idUsuario);
	}

	@Override
	@Transactional()
	public int agregar(Usuario usuario) {
		Usuario usuarioConsulta = this.usuarioDao.consultarPorUsuario(usuario.getUsuario(), 0);
		if (usuarioConsulta != null) {
			throw new RuntimeException("El usuario ya existe favor de capturar otro");
		} else {
			if (validator.validarStringSinEspacios(usuario.getUsuario(),"El usuario contiene espacios favor de quitarselos." )) {
				usuarioDao.agregar(usuario);
			}
		}
		return 1;
	}

	@Override
	@Transactional()
	public int editar(Usuario usuario) {
		Usuario usuarioConsulta = this.usuarioDao.consultarPorUsuario(usuario.getUsuario(), usuario.getIdUsuario());
		if (usuarioConsulta != null) {
			throw new RuntimeException("El usuario ya existe favor de capturar otro");
		} else {
			if (validator.validarStringSinEspacios(usuario.getUsuario(),"El usuario contiene espacios favor de quitarselos." )) {
				usuarioDao.editar(usuario);
			}
		}
		return 1;
	}

}
