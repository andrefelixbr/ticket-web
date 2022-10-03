package br.com.feltex.ticketweb.repository;

import br.com.feltex.ticketweb.constants.enums.Perfil;
import br.com.feltex.ticketweb.constants.enums.StatusUsuario;
import br.com.feltex.ticketweb.modelo.Usuario;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TicketRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    void setUp() {
        usuarioRepository.deleteAll();
    }

    @Test
    @DisplayName("Realizar todas as operacaoes de um CRUD de usuário")
    void crud() {
        var usuario = new Usuario();
        usuario.setNome("Jose");
        usuario.setSobrenome("da Silva");
        usuario.setStatus(StatusUsuario.ATIVO);
        usuario.setPerfil(Perfil.USUARIO);
        usuario.setEmail("jose@feltex.com.br");

        usuarioRepository.save(usuario);
        var usuarioEncontrado = usuarioRepository.findByEmail("jose@feltex.com.br");
        assertEquals(usuario, usuarioEncontrado);

        usuarioEncontrado.setStatus(StatusUsuario.INATIVO);
        usuarioRepository.save(usuarioEncontrado);
        var usuarioAlterado = usuarioRepository.findById(usuario.getId());

        assertTrue(usuarioAlterado.isPresent());

        assertEquals(StatusUsuario.INATIVO, usuarioAlterado.get().getStatus());
        usuarioRepository.delete(usuarioAlterado.get());
        Optional<Usuario> usuarioDeletado = usuarioRepository.findById(usuario.getId());
        assertTrue(usuarioDeletado.isEmpty());
    }

    @Test
    @DisplayName("Falhar na inclusão de usuário")
    void falhar() {
        Usuario usuario = new Usuario();
        usuario.setNome("Jose");
        usuario.setSobrenome("da Silva");
        usuario.setEmail("jose@feltex.com.br");

        assertThrows(DataIntegrityViolationException.class, () ->
                usuarioRepository.save(usuario));
    }

}