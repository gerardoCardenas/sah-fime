package com.sah.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "sah")
public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idUsuario;
	private String contrasena;
	private String usuario;
	private Set<Empleado> empleados = new HashSet<Empleado>(0);

	public Usuario() {
	}

	public Usuario(String contrasena, String usuario) {
		this.contrasena = contrasena;
		this.usuario = usuario;
	}

	public Usuario(String contrasena, String usuario, Set<Empleado> empleados) {
		this.contrasena = contrasena;
		this.usuario = usuario;
		this.empleados = empleados;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_usuario", unique = true, nullable = false)
	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "contrasena", nullable = false, length = 50)
	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Column(name = "usuario", nullable = false, length = 50)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@JsonBackReference("empleados")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

}
