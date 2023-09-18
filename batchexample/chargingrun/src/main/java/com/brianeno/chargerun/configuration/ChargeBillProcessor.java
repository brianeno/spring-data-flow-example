package com.brianeno.chargerun.configuration;

import com.brianeno.chargerun.model.ChargeSession;
import com.brianeno.chargerun.model.Usage;

import org.springframework.batch.item.ItemProcessor;

public class ChargeBillProcessor implements ItemProcessor<Usage, ChargeSession> {

	@Override
	public ChargeSession process(Usage usage) {

		Double billAmount = usage.getWattUsage() * .001 + usage.getMinutes() * .01;
		return new ChargeSession(usage.getId(), usage.getFirstName(), usage.getLastName(),
				usage.getWattUsage(), usage.getMinutes(), billAmount);
	}
}
