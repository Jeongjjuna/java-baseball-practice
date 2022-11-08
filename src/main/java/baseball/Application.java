package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class Game {
    public Map<String, Integer> result;

    public Game() {
        result = new HashMap<>();
        result.put("strike", 0);
        result.put("ball", 0);
    }

    public void startGame() {
        // 컴퓨터 객체
        Computer computer = new Computer();

        // 플레이어 객체 생성
        Player player = new Player();

        // 컴퓨터 랜덤 숫자 생성 ->
        computer.makeRandomNumber();
        System.out.println("컴퓨터 랜덤숫자 : " + computer.myNumberList);

        while (true) {
            // result 초기화

            // 사용자로부터 숫자 입력받기
            player.inputNumber();
            System.out.println("사용자 핸덤숫자 : " + player.myInputNumber);

            // 숫자 비교하기
            compareNumbers(computer.myNumberList, player.myInputNumber);
            System.out.println("숫자 비교" + result);

            // 출력하기


            // 출력 결과값이 다 맞췄다면 break;
        }
    }

    public void compareNumbers(List<Integer> comNum, List<Integer> userNum) {
        for (int i = 0; i < 3; i++) {
            int eachUserNum = userNum.get(i);
            int eachComNum = comNum.get(i);

            if (eachComNum == eachUserNum) {
                System.out.println("스트라이크");
                result.replace("strike", result.get("strike") + 1);
                continue;
            }

            if (comNum.contains(eachUserNum)) {
                System.out.println("볼");
                result.replace("ball", result.get("ball") + 1);
                continue;
            }

            System.out.println("낫싱");
        }
    }

    public void printCompareResult() {
        System.out.println("test : 프린트함수 호출");
    }

}

class Computer {
    public List<Integer> myNumberList = new ArrayList<>();

    public void makeRandomNumber() {
        while (myNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!myNumberList.contains(randomNumber)) {
                myNumberList.add(randomNumber);
            }
        }
    }
}

class Player {
    List<Integer> myInputNumber = new ArrayList<>();

    public void inputNumber() {
        myInputNumber.clear();

        String inputNum = Console.readLine();
        for (int i = 0; i < 3; i++) {
            int num = ((int) inputNum.charAt(i) % 10);
            myInputNumber.add(num);
        }
    }

}


public class Application {
    public static void main(String[] args) {
        boolean checkPlayGame = true;

        Game game = new Game();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (checkPlayGame) {
            // 게임 시작
            game.startGame();

            // 게임 종료 조건 확인
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartCheckNum = Console.readLine();
            if (restartCheckNum == "2") {
                checkPlayGame = false;
            }
        }


    }
}
