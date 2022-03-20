import java.util.Arrays;

/*
 * Name: Dominik Alkhovik
 * Student number: C21024669
 */

public class Assignment1 {
    final private static String[] daysOfTheWeek = {"Sat", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri"};

    /*
     * A method to find the day-of-week for a date.
     *
     * Arguments:
     * `date` -- the SimpleDate for which the day-of-week is to be found.
     *
     * Return value:
     * A String representing the day of week. The day of week should be
     * expressed as a three-letter abbreviation; in other words, this method
     * returns one of:
     *   "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
     */
    public static String dayOfWeek( SimpleDate date ) {
        int y = date.getYear();
        int m = date.getMonth();
        int d = date.getDay();

        if(m < 3){
            m += 12;
            y -= 1;
        }
        int C = y % 100;
        int D = Math.floorDiv(y, 100);
        int W = 13 * (m + 1) / 5;
        int X = C / 4;
        int Y = D / 4;
        int Z = W + X + Y + d + C - 2 * D;
        int day = Z % 7;
        if(day < 0){
            day += 7;
        }
        return daysOfTheWeek[day];
    }

    /*
     * Given a set of dates, this method will count the number of dates in the
     * set that fall on a particular day-of-week.
     *
     * Arguments:
     * `dates` -- an array of SimpleDate objects
     * `dayOfWeek` -- a String representing the day of week ("Mon" to "Sun")
     *
     * Return value:
     * An integer giving the number of dates that fell on `dayOfWeek`.
     */
    public static int countDatesOnDay( SimpleDate[] dates, String dayOfWeek ) {
        int numberOfDays = 0;
        // Format day so that case and redundant spaces do not effect result incorrectly
        String formatedDay = dayOfWeek.toLowerCase().trim();
        // Returns 0 if length of formatted day not equal to 3 as will always give value of 0
        if(formatedDay.length() != 3) return 0;
        // Iterate through dates and increment numberOfDays if specified day of week
        for (SimpleDate date : dates) {
            if(dayOfWeek(date).toLowerCase().equals(formatedDay)) numberOfDays += 1;
        }
        return numberOfDays;
    }

    /*
     * A method to find the most frequent day-of-week among a collection of
     * dates.
     *
     * Arguments:
     * `dates` -- an array of SimpleDate objects
     *
     * Return value:
     * If the array `dates` is empty, then this method should return the null
     * reference. Otherwise, the method should return the three-letter
     * abbreviation ("Mon", "Tue", etc.) of the day-of-week that was most
     * frequent.
     * In the case that there is a tie for the most-frequent day-of-week,
     * priority should be given to the day-of-week that comes earliest in the
     * week. (For this method, "Mon" is assumed to be the first day of the
     * week.)
     * For example, if there were a tie between Tuesday, Wednesday, and Sunday,
     * the method should return "Tue".
     */
    public static String mostFrequentDayOfWeek( SimpleDate[] dates ) {
        if(dates.length == 0) return null;
        int[] dayNumbers = new int[7];

        // Set array dayNumbers with corresponding indexes to day with frequency of day
        for (SimpleDate date : dates) {
            int dateIndex = Arrays.asList(daysOfTheWeek).indexOf(dayOfWeek(date));
            dayNumbers[dateIndex] += 1;
        }

        // Iterate through dayNumbers to work out which is the most frequent
        // Start with index 2 so in the case frequencies match the earlier day is returned
        int maxIndex = 2;
        for (int i = 2; i < 9; i++) {
            int index = i;
            if (i >= 7) {
                index -= 7;
            }

            if (dayNumbers[index] > dayNumbers[maxIndex]){
                maxIndex = index;
            }
        }

        return daysOfTheWeek[maxIndex];
    }
}