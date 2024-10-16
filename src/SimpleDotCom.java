public class SimpleDotCom {
    int[] locationCells;
    int numOfHits;

    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    public String checkYourself(String sringGuess) {
        int guess = Integer.parseInt(sringGuess);
        String result = "МИМО";
        for (int cell : locationCells) {
            if (guess == cell) {
                result = "Попал";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length) {
            result = "Потопил";
        }
        System.out.println(result);
        return result;
    }
}
