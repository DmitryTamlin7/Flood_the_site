import java.util.*;
public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }

    public void setName(String n){
        name = n;
    }

    public String checkYoureself(String userInput) {
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Потопил";
                System.out.println("Вы уничтожили сайт " + name);

            } else {
                result = "Попал";
            }

        }
        return result;
    }
}
