package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.ufscar.dc.dsw.domain.Admin;

@SuppressWarnings("unchecked")
public interface IAdminDAO extends CrudRepository<Admin, Long>{
	Admin save (Admin admin);
}