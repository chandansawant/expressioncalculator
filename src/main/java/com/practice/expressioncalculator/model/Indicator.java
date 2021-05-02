package com.practice.expressioncalculator.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Indicator<T> {

	protected final String name;
	protected final String expression;
	protected final Set<? extends Indicator> dependencies;

	public abstract T calculate(final Map<String, Double> params) throws Exception;

	public Indicator(final String name
						, final String expression
						, final Set<? extends Indicator> dependencies) {
		this.name = name;
		this.expression = expression;
		this.dependencies = dependencies;
	}
}
