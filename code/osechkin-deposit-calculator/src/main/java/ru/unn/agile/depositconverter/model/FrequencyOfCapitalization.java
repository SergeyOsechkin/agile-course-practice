package ru.unn.agile.depositconverter.model;

public enum FrequencyOfCapitalization {
    onceMonth,
    onceTwoMonth,
    quarterly,
    halfYear;
    static int DEFAULT_TWO_MONTH = 2;
    static int DEFAULT_QUARTERLY = 3;
    static int DEFAULT_HALF_YEAR = 6;

    public static boolean checkCharges(final FrequencyOfCapitalization frequencyCapital,
                                       final int term) {
        if (frequencyCapital == FrequencyOfCapitalization.onceTwoMonth) {
            return (term % DEFAULT_TWO_MONTH == 0);
        } else if (frequencyCapital == FrequencyOfCapitalization.quarterly) {
            return (term % DEFAULT_QUARTERLY == 0);
        } else if (frequencyCapital == FrequencyOfCapitalization.halfYear) {
            return (term % DEFAULT_HALF_YEAR == 0);
        }
        else {
            return true;
        }

    }
}
