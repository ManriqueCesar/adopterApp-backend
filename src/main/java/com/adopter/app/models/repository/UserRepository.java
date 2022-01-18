package com.adopter.app.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adopter.app.models.dto.UserDto;
import com.adopter.app.models.entity.user.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("select new com.adopter.app.models.dto.UserDto(u) from UserRole u where u.usuario.username=:username")
	public UserDto findByUsuario(String username);
	
	@Query("select new com.adopter.app.models.dto.UserDto(u) from UserRole u where u.usuario.username=:username")
	public UserDto findUserByUsername(String username);
	
	@Query("select u FROM User u where u.username=:username")
	public User findUsuarioByName(String username);
	
	@Query("select u FROM User u where u.password=:password")
	public String findByContrasena(String password);
	
	@Query("SELECT u FROM User u where u.id=:idUser")
	public User findUsuarioById(Long idUser);
	
}
