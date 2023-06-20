package com.joyfe.naruto.des.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joyfe.naruto.des.dto.TokenDto;
import com.joyfe.naruto.des.entity.Usuarios;
import com.joyfe.naruto.des.execption.NotFound;
import com.joyfe.naruto.des.execption.NullPoint;
import com.joyfe.naruto.des.service.LoginService;

import jakarta.validation.Valid;

@RestController	
public class LoginController {
	private LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	final static String port = "4200";
	@Autowired
	LoginService ls;
	
	@Autowired
	private JavaMailSender sendmail;
	
	@PostMapping(path = "/register")
	@CrossOrigin(origins = "http://localhost:" + port)
	public ResponseEntity<Usuarios> registrarUsuario(@Valid @RequestBody Usuarios user ) throws NullPoint{
		
		SimpleMailMessage mail = new SimpleMailMessage();
		
		if(user.getGmail().contains("@") && user.getGmail().contains(".com") || user.getGmail().contains(".es")) {
			
			if(ls.verificar(user.getNick(), user.getGmail())) {
				
				Usuarios newuser = new Usuarios(user.getNombre(), user.getApellidos(), user.getNick(), user.getPassword(), user.getGmail());
				
				ls.registarUsuario(newuser);
				
				try 
				{
					mail.setTo(user.getGmail());
					mail.setSubject("Hola bienvenido " + user.getNombre() + " " + user.getApellidos());
					mail.setText("Te damos la bienvenida a nuestra API de Naruto, espero que la disfrutes. Te has registrado con el nick: " + user.getNick());
					sendmail.send(mail);
				}
				catch (Exception e) {
					
					throw new NotFound("No se ha encontrado dicho email o " + e);
				}
			
				return ResponseEntity.ok(newuser);
			}
		
			else {
				
				throw new NullPoint("Nick o gmail ya registrado");
			}
		}
		else {
			
			throw new NullPoint("El gmail debe ser válido");
		}
	}
	
	
	@GetMapping(path = "/login", consumes = { MediaType.ALL_VALUE })
	@CrossOrigin(origins = "http://localhost:" + port)
	public TokenDto login(@RequestParam String nick, @RequestParam String pass) {
		
		if(ls.loguear(nick, pass) != null) {
			
			return this.loginService.login("bart", "170502");
		}
		else {
			
			throw new NotFound("No coinciden contraseña o nick");
		}
		
	}

}
