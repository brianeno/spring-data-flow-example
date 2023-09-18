package com.brianeno.chargerun;

import com.brianeno.chargerun.model.ChargeSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ChargeRunApplicationTests {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	@BeforeEach
	public void setup() {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	@Test
	public void testJobResults() {
		List<ChargeSession> billStatements = this.jdbcTemplate.query("select id, " +
						"first_name, last_name, minutes, watt_usage, bill_amount " +
						"FROM CHARGING_SESSION ORDER BY id",
				(rs, rowNum) -> new ChargeSession(rs.getLong("id"),
						rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),
						rs.getLong("WATT_USAGE"), rs.getLong("MINUTES"),
						rs.getDouble("bill_amount")));

		//assertThat(billStatements.size()).isEqualTo(5);
		ChargeSession billStatement = billStatements.get(0);
		assertThat(billStatement.getBillAmount()).isEqualTo(6.0);
		assertThat(billStatement.getFirstName()).isEqualTo("jane");
		assertThat(billStatement.getLastName()).isEqualTo("doe");
		assertThat(billStatement.getId()).isEqualTo(1);
		assertThat(billStatement.getMinutes()).isEqualTo(500);
		assertThat(billStatement.getWattUsage()).isEqualTo(1000);

	}
}