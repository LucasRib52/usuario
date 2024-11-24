package com.lucas.usuario.business;

import com.lucas.usuario.business.converter.UsuarioConverter;
import com.lucas.usuario.business.dto.UsuarioDTO;
import com.lucas.usuario.infrastructure.entity.Usuario;
import com.lucas.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {  // para salvarmos um usuario, recebemos um usuario dto
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);  // transformamos o usuariodto em um usuario entity
        usuario = usuarioRepository.save(usuario); // salvamos como usuario entity
        return usuarioConverter.paraUsuarioDTO(usuario); // transformamos novamente para usuariodto
    }
}
