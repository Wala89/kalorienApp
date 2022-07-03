package com.example.footdiary;

import java.util.Date;
import java.util.HashMap;

public class Utils {

    // --- Static Stuff ---------------------------------------------------------------------------
    private static Utils utils;

    public static Utils getInstance() {
        if (utils == null) {
            utils = new Utils();
        }

        return utils;
    }

    // --- Utils Class ----------------------------------------------------------------------------
    private HashMap<Integer, Double> dailyActivity;
    private UserData userData;

    private Utils() {
        initialDailyActivity();
        initialUserData();
    }

    /**
     * Initialisiert die HashMap wo die Faktoren für die Tägliche aktivität gespeichert ist.
     */
    private void initialDailyActivity() {
        dailyActivity = new HashMap<Integer, Double>();
        dailyActivity.put(0, 1.2);
        dailyActivity.put(1, 1.4);
        dailyActivity.put(2, 1.6);
        dailyActivity.put(3, 1.8);
        dailyActivity.put(4, 2.2);
    }

    private void initialUserData() {
        userData = new UserData("Christian", "male", "1989-03-26", 170, 183);
    }

    // --- Getter ---------------------------------------------------------------------------------

    /**
     * Gibt die HashMap für die Faktoren der Täglichen aktivitäten zurrück
     * @return HashMap DailyActivity
     */
    public HashMap<Integer, Double> getDailyActivity() {
        return dailyActivity;
    }

    /**
     * Gibt die UserDaten zurück
     * @return UserData instance
     */
    public UserData getUserData() {
        return userData;
    }
}
