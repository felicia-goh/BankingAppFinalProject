package com.softra.banking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import org.springframework.jdbc.core.RowMapper;

public class ServiceRowMapper implements RowMapper<ServiceRequest> {

  @Override
  public ServiceRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
    System.out.println("UserRowMapper.mapRow() with row number: " + rowNum);
    int id = rs.getInt("service_id");
    String description = rs.getString("service_description");
    int acct_id = rs.getInt("account_id");
    Date date = rs.getDate("service_raised_date");
    String status = rs.getString("service_status");
    
    ServiceRequest u = new ServiceRequest(id, description, acct_id, date, status);
    System.out.println(u);
    return u;
  }

}
