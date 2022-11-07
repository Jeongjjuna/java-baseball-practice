package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

class Game {
    public final int RESTART = 1;
    public final int END = 2;

    public void restartGame(int userInputNum) {
        if (userInputNum == RESTART)
            System.out.println("게임시작함수");

        if (userInputNum == END)
            System.out.println("게임종료함수");
    }


    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }


    public void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}


class Computer {
    public List<Integer> NumberList;
    public List<String> result;


    public List<Integer> makeRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    public boolean isEqualNumList(List<Integer> userNumList) {
        for (int i = 0; i < 3; i++) {
            if (userNumList.get(i) != NumberList.get(i))
                return false;
        }
        return true;
    }

//    public void printResult(List<Integer> userList) {
//        String result;
//
//        if isEqualNum(userList) {
//            result = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
//        }
//
//
//
//
//        System.out.println(result);
//    }
}


public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
