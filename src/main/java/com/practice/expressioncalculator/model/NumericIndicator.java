package com.practice.expressioncalculator.model;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NumericIndicator extends Indicator<Double> {

	protected final Expression expression;


	public NumericIndicator(final String name
							, final String expression
							, final Set<? extends Indicator> dependencies) {
		super(name, expression, dependencies);

		Set<String> variables
				= dependencies
					.stream()
					.map(indicator -> indicator.name)
					.collect(Collectors.toSet());

		this.expression = new ExpressionBuilder(super.expression)
								.variables(variables)
								.build();
	}

	@Override
	public Double calculate(final Map<String, Double> params) {
		return this.expression
				.setVariables(params)
				.evaluate();
	}
}
