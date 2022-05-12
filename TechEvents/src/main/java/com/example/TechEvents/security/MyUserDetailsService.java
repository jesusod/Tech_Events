package com.example.TechEvents.security;

import com.example.TechEvents.models.entity.Usuario;
import com.example.TechEvents.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Buscar el usuario por su email
        Usuario usuario = usuarioRepository.findByEmail(email);

        // se lo pasas a MyUserDetails
        return new MyUserDetails(usuario);
    }
}
