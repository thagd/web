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
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.ILocacaoDAO;
import br.ufscar.dc.dsw.domain.Locacao;

@SpringBootApplication
public class BicicletasMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BicicletasMvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IClienteDAO clienteDAO, ILocadoraDAO locadoraDAO, IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder, ILocacaoDAO locacaoDAO) {
		return (args) -> {
			
			Usuario a1 = new Usuario();
			a1.setNome("admin");
			a1.setSenha(encoder.encode("admin"));
            a1.setEmail("admin");
            a1.setRole("ROLE_ADMIN");
			usuarioDAO.save(a1);

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

			Cliente c2 = new Cliente();
			c2.setNome("cliente 2");
			c2.setSenha(encoder.encode("123"));
            c2.setEmail("cliente@cliente");
			c2.setRole("ROLE_CLIENTE");
			c2.setCpf("414.966.658-05");
			c2.setNascimento("1997-09-25");
			c2.setTelefone("(17)99614-0380");
			c2.setSexo("feminino");
			clienteDAO.save(c2);

			Cliente c3 = new Cliente();
			c3.setNome("cliente 3");
			c3.setSenha(encoder.encode("123"));
            c3.setEmail("cliente@teste");
			c3.setRole("ROLE_CLIENTE");
			c3.setCpf("414.966.658-05");
			c3.setNascimento("1997-09-25");
			c3.setTelefone("(17)99614-0380");
			c3.setSexo("feminino");
			clienteDAO.save(c3);

            Locadora l1 = new Locadora();
			l1.setNome("locadora");
			l1.setSenha(encoder.encode("123"));
            l1.setEmail("locadora");
			l1.setRole("ROLE_LOCADORA");
			l1.setCnpj("12.212.121/2121-21");
			l1.setCidade("São Carlos");
			locadoraDAO.save(l1);

			Locadora l2 = new Locadora();
			l2.setNome("locadora teste");
			l2.setSenha(encoder.encode("123"));
            l2.setEmail("locadora@teste");
			l2.setRole("ROLE_LOCADORA");
			l2.setCnpj("12.212.121/2121-21");
			l2.setCidade("São Carlos");
			locadoraDAO.save(l2);

			Locadora l3 = new Locadora();
			l3.setNome("locadora da sabs");
			l3.setSenha(encoder.encode("123"));
            l3.setEmail("locadora@locadora");
			l3.setRole("ROLE_LOCADORA");
			l3.setCnpj("12.212.121/2121-21");
			l3.setCidade("Rio Preto");
			locadoraDAO.save(l3);

			Locacao l4 = new Locacao();
			l4.setCliente(c1);
			l4.setLocadora(l1);
			l4.setData("2020-12-23");
			l4.setHorario("12:00");
			locacaoDAO.save(l4);

			Locacao l5 = new Locacao();
			l5.setCliente(c3);
			l5.setLocadora(l3);
			l5.setData("2020-12-23");
			l5.setHorario("12:00");
			locacaoDAO.save(l5);
		};
	}
}