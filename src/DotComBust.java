import java.util.*;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("Eboys.com");
        DotCom thee = new DotCom();
        thee.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(thee);
        System.out.println("Ваша цель уничтожить 3 сайта за наименьшее число попыток");

        for (DotCom dotComSet : dotComsList) {
            ArrayList<String> newLocations = helper.placeDotCom(3);
            dotComSet.setLocationCells(newLocations);
        }
    }

    private void startPlaying() {
        while (!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Ваш ход");
            checkUserGuess(userGuess);
        }
        finishGame(); // Переместил сюда
    }

    private void checkUserGuess(String userGuess) { // Исправлено имя метода
        numOfGuesses++;
        String result = "Мимо";

        for (DotCom dotComToTest : dotComsList) {
            result = dotComToTest.checkYoureself(userGuess);
            if (result.equals("Попал")) {
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("Все сайты уничтожены, пошлите смотреть что и как ");
        if (numOfGuesses < 18) {
            System.out.println("Вам понадобилось всего " + numOfGuesses + " попыток, ваши акции спасены");
        } else {
            System.out.println("Увы, вы потратили " + numOfGuesses + " попыток, ваши акции уничтожены");
        }
    }

    public static void main(String[] args) { // Исправлено объявление метода
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}