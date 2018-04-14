package com.sah.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sah.dao.UsuarioDao;
import com.sah.model.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Usuario login(String usuario, String contraseña) {
		Usuario usuarioLogin = em.createQuery("FROM Usuario u WHERE u.usuario =:usuario"
				+ " AND u.contrasena =:contraseña", Usuario.class)
				.setParameter("usuario", usuario)
				.setParameter("contraseña", contraseña)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null);
		return usuarioLogin;
		
	}

	@Override
	public Usuario consultarEnSesion(Integer idUsuario) {
		return em.find(Usuario.class, idUsuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> consultarGeneral() {
		return em.createQuery("FROM Usuario").getResultList();
	}

	@Override
	public int eliminar(int idUsuario) {
		Usuario usuario = new Usuario();
		usuario = em.find(Usuario.class, idUsuario);
		em.remove(usuario);
		return idUsuario;
	}

	@Override
	public int agregar(Usuario usuario) {
		em.persist(usuario);
		return 1;
	}

	@Override
	public int editar(Usuario usuario) {
		em.merge(usuario);
		return 1;
	}

	@Override
	public Usuario consultarPorUsuario(String usuario, int id) {
		Usuario usuarioConsulta = em.createQuery("FROM Usuario u WHERE u.usuario =:usuario AND u.idUsuario !=:idUsuario", Usuario.class)
				.setParameter("usuario", usuario)
				.setParameter("idUsuario", id)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null);
		return usuarioConsulta;
	}
	
}
