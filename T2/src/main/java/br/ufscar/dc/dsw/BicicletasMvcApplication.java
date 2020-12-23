package br.ufscar.dc.dsw;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;

@SpringBootApplication
public class BicicletasMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BicicletasMvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder) {
		return (args) -> {
			
			Usuario u1 = new Usuario();
			u1.setNome("admin");
			u1.setSenha(encoder.encode("admin"));
            u1.setEmail("admin@admin");
            u1.setRole("ROLE_ADMIN");
			usuarioDAO.save(u1);

            Usuario u2 = new Usuario();
			u2.setNome("cliente");
			u2.setSenha(encoder.encode("123"));
            u2.setEmail("cliente@cliente");
			u2.setRole("ROLE_CLIENTE");
			usuarioDAO.save(u2);

            Usuario u3 = new Usuario();
			u3.setNome("locadora");
			u3.setSenha(encoder.encode("123"));
            u3.setCidade("São Carlos");
            u3.setEmail("locadora@locadora");
			u3.setRole("ROLE_LOCADORA");
			usuarioDAO.save(u3);
		};
	}
}