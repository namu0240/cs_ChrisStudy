package com.namu.calculator;


import namu.NCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Divide {

    NCalculator nCalculator;

    @Before
    public void before() {
        nCalculator = new NCalculator();
    }

    @Test
    public void 양수와_양수가_주어졌을때_올바른_값이_나와야_합니다() {

        // given
        String[] formula = new String[]{"21", "/", "7"};

        // when
        String result = nCalculator.calculate(formula);

        // then
        Assert.assertEquals(result, "3");

    }

    @Test
    public void 음수와_양수가_주어졌을때_올바른_값이_나와야_합니다() {

        // given
        String[] formula = new String[]{"-21", "/", "7"};

        // when
        String result = nCalculator.calculate(formula);

        // then
        Assert.assertEquals(result, "-3");

    }

    @Test
    public void 양수와_음수가_주어졌을때_올바른_값이_나와야_합니다() {

        // given
        String[] formula = new String[]{"21", "/", "-7"};

        // when
        String result = nCalculator.calculate(formula);

        // then
        Assert.assertEquals(result, "-3");

    }

    @Test
    public void 음수와_음수가_주어졌을때_올바른_값이_나와야_합니다() {

        // given
        String[] formula = new String[]{"-21", "/", "-7"};

        // when
        String result = nCalculator.calculate(formula);

        // then
        Assert.assertEquals(result, "3");

    }

}
