package com.namu.calculator;


import namu.alogirthm.NCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Pow {

    NCalculator nCalculator;

    @Before
    public void before() {
        nCalculator = new NCalculator();
    }

    @Test
    public void 양수와_양수가_주어졌을때_올바른_값이_나와야_합니다() {

        // given
        String[] formula = new String[]{"3", "^", "2"};

        // when
        String result = nCalculator.calculate(formula);

        // then
        Assert.assertEquals(result, "9");

    }

    @Test
    public void 음수와_양수가_주어졌을때_올바른_값이_나와야_합니다() {

        // given
        String[] formula = new String[]{"-3", "^", "2"};

        // when
        String result = nCalculator.calculate(formula);

        // then
        Assert.assertEquals(result, "9");

    }

    @Test
    public void 양수와_음수가_주어졌을때_올바른_값이_나와야_합니다() {

        // given
        String[] formula = new String[]{"4", "^", "-2"};

        // when
        String result = nCalculator.calculate(formula);

        // then
        Assert.assertEquals(result, "0.0625");

    }

    @Test
    public void 음수와_음수가_주어졌을때_올바른_값이_나와야_합니다() {

        // given
        String[] formula = new String[]{"-4", "^", "-2"};

        // when
        String result = nCalculator.calculate(formula);

        // then
        Assert.assertEquals(result, "0.0625");

    }

}
