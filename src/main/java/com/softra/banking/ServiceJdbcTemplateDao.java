package com.softra.banking;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository("dbJdbcTemplate")
public class ServiceJdbcTemplateDao implements IDao<ServiceRequest> {

	@Autowired
	private JdbcTemplate template;

	@Override
	public Optional<ServiceRequest> findById(int id) {
		String sql = "select * from service_tracker where service_id = ?";
		ServiceRequest request = template.queryForObject(sql, new ServiceRowMapper(), id);
		Optional<ServiceRequest> opt = Optional.ofNullable(request);
		return opt;
	}

	@Override
	public ServiceRequest save(ServiceRequest request) {

		System.out.println("ServiceJdbcTemplateDao.save()");

		String sql = "insert into service_tracker(service_description, "
				+ "account_id, service_raised_date, service_status) values (?,?,?,?)";

//		int row = template.update(sql, request.getDescription(), 
//				request.getAcctId(), request.getRaisedDate(), request.getStatus());

//		System.out.println(row);
//		return null;

		KeyHolder keyHolder = new GeneratedKeyHolder();

		// the update method takes an implementation of PreparedStatementCreator which
		// could be a lambda
		template.update(con -> {
			PreparedStatement ps = con.prepareStatement(sql, new String[] { "id" });
			ps.setString(1, request.getDescription());
			ps.setInt(2, request.getAcctId());
			ps.setDate(3, new java.sql.Date(request.getRaisedDate().getTime()));
			ps.setString(4, request.getStatus());
			return ps;
		}, keyHolder);

		// after the update executed we can now get the value of the generated ID
		return new ServiceRequest((int) keyHolder.getKeys().get("id"));
	}

	@Override
	public List<ServiceRequest> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceRequest deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
