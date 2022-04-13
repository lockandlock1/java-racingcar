package racingcar;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern onlyNumberPattern = Pattern.compile("^[0-9]*?");


    public static int enterTheNumberOfCars(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");

        return validInputData(scanner.nextLine());
    }

    public static int enterTheNumberOfTry(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return validInputData(scanner.nextLine());
    }

    private static int validInputData(String input) {
        Matcher matcher = onlyNumberPattern.matcher(input);

        if(matcher.find()) {
            return checkPositive(input);
        }

        System.out.println("잘못된 입력값 입니다");
        throw new RuntimeException();
    }

    private static int checkPositive(String input) {
        int number = Integer.parseInt(input);

        if(number > 0) {
            return number;
        }

        throw new RuntimeException();
    }
}
