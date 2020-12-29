package br.ufscar.dc.dsw;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.dao.ILocadoraDAO;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.dao.IAdminDAO;
import br.ufscar.dc.dsw.domain.Admin;
import br.ufscar.dc.dsw.dao.ILocacaoDAO;
import br.ufscar.dc.dsw.domain.Locacao;

@SpringBootApplication
public class BicicletasMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BicicletasMvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IClienteDAO clienteDAO, ILocadoraDAO locadoraDAO, IAdminDAO adminDAO, BCryptPasswordEncoder encoder, ILocacaoDAO locacaoDAO) {
		return (args) -> {
			
			Admin a1 = new Admin();
			a1.setNome("admin");
			a1.setSenha(encoder.encode("admin"));
            a1.setEmail("admin");
            a1.setRole("ROLE_ADMIN");
			adminDAO.save(a1);

            Cliente c1 = new Cliente();
			c1.setNome("cliente");
			c1.setSenha(encoder.encode("123"));
            c1.setEmail("cliente");
			c1.setRole("ROLE_CLIENTE");
			c1.setCpf("414.966.658-05");
			c1.setNascimento("1997-09-25");
			c1.setTelefone("(17)99614-0380");
			c1.setSexo("feminino");
			clienteDAO.save(c1);

            Locadora l1 = new Locadora();
			l1.setNome("locadora");
			l1.setSenha(encoder.encode("123"));
            l1.setEmail("locadora");
			l1.setRole("ROLE_LOCADORA");
			l1.setCnpj("12.212.121/2121-21");
			l1.setCidade("São Carlos");
			locadoraDAO.save(l1);

			Locacao l2 = new Locacao();
			l2.setCliente("cliente");
			l2.setLocadora("locadora");
			l2.setData("2020-12-23");
			l2.setHorario("12:00");
			locacaoDAO.save(l2);
		};
	}
}