//package com.omar.clinicaodontologica.controller;
//
//import com.omar.clinicaodontologica.dto.UsuarioDTO;
//import com.omar.clinicaodontologica.entity.Usuario;
//import com.omar.clinicaodontologica.exception.ResourceNotFound;
//import com.omar.clinicaodontologica.repository.UsuarioRepository;
//import com.omar.clinicaodontologica.service.UsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collection;
//import java.util.List;
//
//@RestController
//@RequestMapping("/auth")
//@CrossOrigin(origins = "http://localhost:5173")
//public class UsuarioController {
//
//    @Autowired
//    private UsuarioService usuarioService;
//    @Autowired
//    private PasswordEncoder bCryptPasswordEncoder;
//    @Autowired
//    private JwtUtil jwtService;
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody UsuarioDTO usuario) throws Exception{
//        System.out.println("Usuario: " + usuario.getUsername());
//        System.out.println("Contraseña: " + usuario.getPassword());
//
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword())
//            );
//        } catch (BadCredentialsException e) {
//            throw new Exception("Credenciales incorrectas", e);
//        }
//
//        System.out.println("Iniciando busqueda de usuario");
//
//        final UserDetails userDetails = usuarioService.loadUserByUsername(usuario.getUsername());
//        System.out.println("Usuario encontrado");
//        System.out.println("Generando token");
//        final String jwt = jwtService.generateToken(userDetails);
//        System.out.println("Token generado");
//
//        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
//        boolean isAdmin = authorities.stream()
//                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
//
//
//        if (isAdmin) {
//            System.out.println("El usuario es un administrador");
//        } else {
//            System.out.println("El usuario no es un administrador");
//        }
//
//        return ResponseEntity.ok(jwt);
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) throws Exception{
//        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
//        return usuarioService.save(usuario);
//    }
//
//    @GetMapping("/{username}")
//    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String username) throws ResourceNotFound {
//        return usuarioService.getByUsername(username);
//    }
//
//    @DeleteMapping("/{usuarioId}")
//    public void eliminarUsuario(@PathVariable Long usuarioId) throws ResourceNotFound {
//        usuarioService.deleteById(usuarioId);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Usuario>> getUsuarios(){
//        return usuarioService.getAll();
//    }
//}
