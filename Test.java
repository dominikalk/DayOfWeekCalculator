public class Test {
    public static void main(String[] args){
        SimpleDate date1 = new SimpleDate(1753, 9, 19);
        SimpleDate date2 = new SimpleDate(1753, 11, 17);
        SimpleDate date3 = new SimpleDate(1754, 6, 7);

        SimpleDate[] dates = {date1, date2, date2, date2, date3, date3};
        System.out.print(Assignment1.countDatesOnDay(dates, args[0]));
    }
}
