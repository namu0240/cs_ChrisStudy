package com.namu.calculator;


import namu.alogirthm.NCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Parenthesis {

    NCalculator nCalculator;

    @Before
    public void before() {
        nCalculator = new NCalculator();
    }

    @Test
    public void 괄호를_우선_처리하고_곱셈_연산을_처리하여야_합니다() {

        // given
        String[] formula = new String[]{"(", "3", "+", "2", ")", "*", "2"};

        // when
        String result = nCalculator.calculate(formula);

        // then
        Assert.assertEquals(result, "10");

    }

    @Test
    public void 괄호를_우선_처리하고_제곱_연산을_처리하여야_합니다() {

        // given
        String[] formula = new String[]{"(", "3", "+", "2", ")", "^", "2"};

        // when
        String result = nCalculator.calculate(formula);

        // then
        Assert.assertEquals(result, "25");

    }

    @Test
    public void 괄호를_2개를_우선_처리하고_곱셈_연산을_처리하여야_합니다() {

        // given
        String[] formula = new String[]{"(", "3", "+", "2", ")", "*", "(", "2", "+", "7", ")"};

        // when
        String result = nCalculator.calculate(formula);

        // then
        Assert.assertEquals(result, "45");

    }


}
