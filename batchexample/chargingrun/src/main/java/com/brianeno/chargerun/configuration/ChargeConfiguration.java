package com.brianeno.chargerun.configuration;

import com.brianeno.chargerun.model.ChargeSession;
import com.brianeno.chargerun.model.Usage;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;


@Configuration
@EnableTask
@EnableBatchProcessing
public class ChargeConfiguration {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Value("${usage.file.name:classpath:usageinfo.json}")
	private Resource usageResource;

	@Bean
	public Job job1(ItemReader<Usage> reader, ItemProcessor<Usage, ChargeSession> itemProcessor, ItemWriter<ChargeSession> writer) {
		Step step = stepBuilderFactory.get("ChargeProcessing")
				.<Usage, ChargeSession>chunk(1)
				.reader(reader)
				.processor(itemProcessor)
				.writer(writer)
				.build();

		return jobBuilderFactory.get("ChargeJob")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}

	@Bean
	public JsonItemReader<Usage> jsonItemReader() {

		ObjectMapper objectMapper = new ObjectMapper();
		JacksonJsonObjectReader<Usage> jsonObjectReader =
				new JacksonJsonObjectReader<>(Usage.class);
		jsonObjectReader.setMapper(objectMapper);

		return new JsonItemReaderBuilder<Usage>()
				.jsonObjectReader(jsonObjectReader)
				.resource(usageResource)
				.name("UsageJsonItemReader")
				.build();
	}

	@Bean
	public JdbcBatchItemWriter<ChargeSession> jdbcBillWriter(DataSource dataSource) {
		JdbcBatchItemWriter<ChargeSession> writer = new JdbcBatchItemWriterBuilder<ChargeSession>()
						.beanMapped()
				.dataSource(dataSource)
				.sql("INSERT INTO CHARGING_SESSION (id, first_name, last_name, minutes, watt_usage,bill_amount) VALUES (:id, :firstName, :lastName, :minutes, :wattUsage, :billAmount)")
				.build();
		return writer;
	}

	@Bean
	ItemProcessor<Usage, ChargeSession> billProcessor() {
		return new ChargeBillProcessor();
	}

}
