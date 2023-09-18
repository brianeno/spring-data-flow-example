package com.brianeno.chargesetuptask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ChargeSetupTaskApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	public void testRepository() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
		int result = jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM CHARGING_SESSION", Integer.class);
		assertThat(result > 0);
	}

}
