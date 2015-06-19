package com.ponces.alberto.calendariococo;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alberto Ponces on 12/06/15.
 */
public class Controller {

    private Calendar cal;

    public Controller(Context context) {
        cal = new Calendar(context);
    }

    public Calendar getCal() {
        return cal;
    }

    public void setCal(Calendar cal) {
        this.cal = cal;
    }

    public String getDescription() {
        return cal.getDescription();
    }

    public String getHeart() {
        return cal.getHeart();
    }

    public void searchDay(String date) {
        cal.searchDay(cal.getReadableDatabase(), date);
    }

    public String[] getAll() {
        return cal.getAll(cal.getReadableDatabase());
    }

    public String getSeason() {
        SimpleDateFormat df = new SimpleDateFormat("MM-dd");
        String date = df.format(new Date());
        int month = Integer.parseInt(date.split("-")[0]);
        int day = Integer.parseInt(date.split("-")[1]);
        if (month == 1 || month == 2)
            return "winter";
        else if (month == 4 || month == 5)
            return "spring";

        else if (month == 7 || month == 8)
            return "summer";

        else if (month == 10 || month == 11)
            return "fall";

        else if (month == 3 && day <= 19)
            return "winter";

        else if (month == 3 && day >= 20)
            return "spring";

        else if (month == 6 && day <= 20)
            return "spring";

        else if (month == 6 && day >= 21)
            return "summer";

        else if (month == 9 && day <= 21)
            return "summer";

        else if (month == 9 && day >= 22)
            return "fall";

        else if (month == 12 && day <= 21)
            return "fall";

        else if (month == 12 && day >= 22)
            return "winter";
        else
            return "";
    }
}
