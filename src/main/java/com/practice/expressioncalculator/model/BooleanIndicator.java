package com.practice.expressioncalculator.model;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;
import java.util.Set;

public class BooleanIndicator extends Indicator<Boolean> {

	protected static final ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");


	public BooleanIndicator(final String name
							, final String expression
							, final Set<? extends Indicator<?>> dependencies) {
		super(name, expression, dependencies);
	}

	@Override
	public Boolean calculate(final Map<String, Double> params) throws ScriptException {

		String finalExpression = expression;

		for (Indicator<?> dependency : dependencies)
			finalExpression = finalExpression.replaceAll(dependency.name, params.get(dependency.name).toString());

		return (Boolean)engine.eval(finalExpression);
	}
}
