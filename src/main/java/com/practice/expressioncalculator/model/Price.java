package com.practice.expressioncalculator.model;

import java.util.Map;

import static java.util.Collections.EMPTY_SET;

public class Price extends Indicator<Double> {

	public Price(final String name) {
		super(name, "", EMPTY_SET);
	}

	@Override
	public Double calculate(Map<String, Double> params) throws Exception {
		return params.get(name);
	}
}
