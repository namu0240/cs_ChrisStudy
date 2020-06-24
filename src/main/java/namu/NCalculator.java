package namu;

public class NCalculator {

    private static int STACK_SIZE = 50;

    private NStack<String> calculateStack = new NStack<>(STACK_SIZE);
    private NStack<String> operatorStack = new NStack<>(STACK_SIZE);

    public void convertToPostFix(String[] formula) {

        for (String value : formula) {
            // 숫자 일 경우에 계산 스택에 바로 넣는다.

            if (isNumber(value)) {
                calculateStack.push(value);
                continue;
            }

            int priority = operatorPriority(value);

            // 연산자 일 경우
            switch (priority) {
                case 1: // + -
                    // 만약 Top 의 연산자가 상위 연산자 일 경우 calculator
                    if (operatorStack.getTop() == null) {
                        operatorStack.push(value);
                        continue;
                    }

                    while (operatorStack.getTop() != null && operatorPriority(operatorStack.getTop()) == 2) {
                        String operator = operatorStack.pop();
                        calculateStack.push(operator);
                    }

                    operatorStack.push(value);
                    break;
                case 2: // * / ^
                case 3: // (
                    operatorStack.push(value);
                    break;
                case 4: // )
                    // "(" 을 찾을 때 까지 연산 스택으로 옮긴다.
                    while (true) {
                        String operator = operatorStack.pop();

                        if (operator.equals("(")) {
                            break;
                        }

                        calculateStack.push(operator);
                    }
                    break;
            }
        }

        // Operate Stack -> Calculate Stack
        int sp = operatorStack.getSp();
        for (int i = 0; i <= sp; i++) {
            String operator = operatorStack.pop();
            calculateStack.push(operator);
        }

        System.out.println(calculateStack);
    }

    private int operatorPriority(String operator) {
        // 연산자 일 경우
        switch (operator) {
            case "-":
            case "+":
                return 1;
            case "*":
            case "/":
            case "^":
                return 2;
            case "(":
                return 3;
            case ")":
                return 4;
        }
        return -1;
    }

    public String calculate(String[] formula) {
        convertToPostFix(formula);

        NStack<String> reverseStack = calculateStack.reverse();
        NStack<String> resultStack = new NStack<>(STACK_SIZE);

        while (!reverseStack.isEmpty()) {

            String value = reverseStack.pop();

            if (isNumber(value)) {
                resultStack.push(value);
                continue;
            }

            double number1 = Double.parseDouble(resultStack.pop());
            double number2 = Double.parseDouble(resultStack.pop());

            switch (value) {
                case "+":
                    resultStack.push(number2 + number1 + "");
                    break;
                case "-":
                    resultStack.push(number2 - number1 + "");
                    break;
                case "*":
                    resultStack.push(number2 * number1 + "");
                    break;
                case "/":
                    resultStack.push(number2 / number1 + "");
                    break;
                case "^":
                    resultStack.push(Math.pow(number2, number1) + "");
                    break;
            }
        }

        double result = Double.parseDouble(resultStack.pop());

        if(result % 1 == 0.0) {
            return ((int) result) + "";
        }
        return result + "";
    }

    private boolean isNumber(String word) {
        try {
            Integer.valueOf(word);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
