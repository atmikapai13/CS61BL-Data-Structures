public class GregorianDate extends Date {

    private static final int[] MONTH_LENGTHS = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public GregorianDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }


    // YOUR CODE HERE
<<<<<<< HEAD
    @Override
    public Date nextDate() {
        int newDay, newMonth, newYear;
        if ((dayOfMonth == 31 ) || (dayOfMonth == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) || (dayOfMonth == 28 && month == 2)) {
            newDay = 1;
            newMonth = month + 1;
        } else {
            newDay = dayOfMonth + 1;
            newMonth = month;
        }
        if (newMonth == 13) {
            newMonth = 1;
            newYear = year + 1;
        } else {
            newYear = year;
        }
        return new GregorianDate(newYear, newMonth, newDay);
    }
=======
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65

    @Override
    public int dayOfYear() {
        int precedingMonthDays = 0;
        for (int m = 1; m < month; m += 1) {
            precedingMonthDays += getMonthLength(m);
        }
        return precedingMonthDays + dayOfMonth;
    }

    private static int getMonthLength(int m) {
        return MONTH_LENGTHS[m - 1];
    }
}