package ru.unn.agile.depositconverter.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    private SimpleDateFormat formatter;
    private Date date;

    public DateTime() {
        this.date = new Date();
        this.initFormatter();
    }

    private void initFormatter() {
        this.formatter = new SimpleDateFormat("dd.MM.yyyy") {{
            setLenient(false);
        }};
    }

    public DateTime(final String date) throws ParseException {
        this.initFormatter();
        this.date = this.formatter.parse(date);
    }

    public String convertToString() {
        return this.formatter.format(this.date);
    }
}
