package com.example.TechEvents.models.service;

import com.example.TechEvents.dto.UsuarioRegistroDTO;
import com.example.TechEvents.models.entity.Evento;
import com.example.TechEvents.models.entity.Usuario;
import com.example.TechEvents.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarTodos() {

        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarporId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        super();
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(),
        registroDTO.getEmail(), passwordEncoder.encode(registroDTO.getPassword())/*,Arrays.asList(new Evento("EVENTO_USER"))*/);
        return usuarioRepository.save(usuario);

    }


   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o password incorrectos");
        }
        return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesEventos(usuario.getEventos()));

    }*/

    private Collection<? extends GrantedAuthority> mapearAutoridadesEventos(Collection<Evento> eventos){
        return eventos.stream().map(evento -> new SimpleGrantedAuthority(evento.getTitulo())).collect(Collectors.toList());
    }


}
