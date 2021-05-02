package com.practice.expressioncalculator.model;

import java.util.Map;

import static java.util.Set.of;

public class HistoricIndicator extends Indicator<Double> {

	protected static final String MINUS = "_MINUS_";

	protected final Integer lookBackDays;


	public HistoricIndicator(final Indicator<Double> indicator
								, final Integer lookBackDays) {
		super(indicator.name + MINUS + lookBackDays, "", of(indicator));
		this.lookBackDays = lookBackDays;
	}

	@Override
	public Double calculate(final Map<String, Double> params) {
		return params.get(name);
	}
}
