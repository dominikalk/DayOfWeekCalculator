public class Test {
    public static void main(String[] args){
        SimpleDate date1 = new SimpleDate(1753, 9, 17); // Mon
        SimpleDate date2 = new SimpleDate(1753, 11, 17); // Sat
        SimpleDate date3 = new SimpleDate(1754, 6, 7); // Fri
        SimpleDate[] dates = {date1, date2, date2, date3, date3, date3};

        System.out.println("Day of week on 17/9/1753: " + Assignment1.dayOfWeek(date1));
        if (args.length > 0) System.out.println("Number of \"" + args[0] + "\" in list: " + Assignment1.countDatesOnDay(dates, args[0]));
        System.out.println("Most frequent day in list: " + Assignment1.mostFrequentDayOfWeek(dates));        
    }
}
