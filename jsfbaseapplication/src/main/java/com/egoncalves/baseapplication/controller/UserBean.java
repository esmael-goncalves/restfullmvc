package com.egoncalves.baseapplication.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egoncalves.baseapplication.annotation.Transacional;
import com.egoncalves.baseapplication.model.User;
import com.egoncalves.baseapplication.repository.UserRepository;
import com.egoncalves.util.FacesMessages;

@ManagedBean(name = "userBean")
@Named
@ViewScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(UserBean.class);

	@Inject
	UserRepository userRepository;

	@Inject
	FacesMessages messages;

	private List<User> todosUsuarios;

	private User usuarioEdicao;

	public UserBean() {
		todosUsuarios = userRepository.findAll();
	}

	@Transacional
	public void salvar() {
		logger.debug("Salvando o usuário: " + usuarioEdicao.getNome());
		userRepository.save(usuarioEdicao);
		usuarioEdicao = new User();
		consultar();

		messages.info("Usuário registrado com sucesso!");
	}

	public void consultar() {
		logger.debug("Buscando todos os usuários");
		todosUsuarios = userRepository.findAll();
	}

	@Transacional
	public void excluir(User usuario) {
		logger.debug("Removendo o usuário: " + usuario.getNome());
		userRepository.delete(usuario);
		consultar();

		messages.info("Usuário removido com sucesso!");
	}

	public List<User> getTodosUsuarios() {
		return todosUsuarios;
	}

	public void setTodosUsuarios(List<User> todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}

	public User getUsuarioEdicao() {
		return usuarioEdicao;
	}

	public void setUsuarioEdicao(User usuarioEdicao) {
		this.usuarioEdicao = usuarioEdicao;
	}

}
