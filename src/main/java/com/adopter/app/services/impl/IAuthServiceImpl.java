package com.adopter.app.services.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.adopter.app.models.dto.UserDto;
import com.adopter.app.models.entity.user.User;
import com.adopter.app.models.response.LoginResponseModel;
import com.adopter.app.models.repository.UserRepository;
import com.adopter.app.security.JwtTokenUtil;
import com.adopter.app.services.IAuthService;

@Service
public class IAuthServiceImpl implements IAuthService {

	private final Logger LOGGER = Logger.getLogger(IAuthServiceImpl.class.getName());

	@Autowired
	private UserRepository usuarioRepo;

	/*@Autowired
	private UsuarioDaoImpl usuarioDao;*/

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	public void authenticate(String username, String password) throws DisabledException, BadCredentialsException {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}

	public LoginResponseModel login(UserDto usuario) {
		try {
			// authenticate(usuario.getUsuario(), usuario.getContrasena());
			User user = new User();
			user = usuarioRepo.findUsuarioByName(usuario.getUsuario());

			if (user == null) {
				return new LoginResponseModel(null, null, "Credenciales incorrectas", HttpStatus.UNAUTHORIZED.value());
			} else if (!usuario.getContrasena().equals(user.getPassword())) {
				return new LoginResponseModel(null, null, "Credenciales incorrectas", HttpStatus.UNAUTHORIZED.value());
			} else {
				UserDto userDto = new UserDto();
				userDto = usuarioRepo.findUserByUsername(usuario.getUsuario());
				userDto.setContrasena(null);
				return new LoginResponseModel(jwtTokenUtil.generateToken(usuario),
						userDto,
						"Sesion iniciada", HttpStatus.OK.value());
			}

		} catch (DataAccessException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new LoginResponseModel(null, null, "Error al realizar la consulta en la base de datos",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		} catch (DisabledException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new LoginResponseModel(null, null, "El usuario está deshabilitado", HttpStatus.UNAUTHORIZED.value());
		} catch (BadCredentialsException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new LoginResponseModel(null, null,  "El usuario o contraseña son incorrectos",
					HttpStatus.UNAUTHORIZED.value());
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new LoginResponseModel(null, null, "Ocurrió un error inesperado",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}



}
