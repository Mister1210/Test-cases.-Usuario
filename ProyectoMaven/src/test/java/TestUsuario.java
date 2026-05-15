import org.example.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestUsuario {

    @Test
    void testRegistroValido() {
        Usuario u = new Usuario("Admin", "Ab12", 20, "test@mail.com");
        assertTrue(u.validarRegistro(), "El registro debería ser válido con estos datos");
    }

    @Test
    void testUsuarioInvalido() {
        Usuario u = new Usuario("UsuarioLargo", "Ab12", 20, "test@mail.com");
        assertFalse(u.validarUsuario(), "Debería fallar por longitud de usuario > 5");
    }

    @Test
    void testContrasenaInvalida() {
        Usuario u = new Usuario("Admin", "Abc123456", 20, "test@mail.com");
        assertFalse(u.validarContrasena(), "Debería fallar por longitud > 7");
    }

    @Test
    void testEdadInvalida() {
        Usuario u = new Usuario("Admin", "Ab12", 17, "test@mail.com");
        assertFalse(u.validarEdad(), "Debería fallar por ser menor de 18 años");
    }

    @Test
    void testCorreoInvalido() {
        Usuario u = new Usuario("Admin", "Ab12", 20, "test@mailcom");
        assertFalse(u.validarCorreo(), "Debería fallar porque el correo no tiene punto");
    }
}