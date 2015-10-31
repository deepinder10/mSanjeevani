package shugal.com.msanjeevani;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deepinder on 10/31/2015.
 */
public class UtilsInfo {
    public static final List<Friend> friends = new ArrayList<>();

    static {
        friends.add(new Friend(R.drawable.fortis_cover, "mSanjeevani", R.color.sienna, "WE CARE", "Stay Healthy"));

        friends.add(new Friend(R.drawable.maxhospital, "SHUGAL@INC", R.color.saffron,
                "ABHISHEK DEEPINDER AAYUSH", ""));

    }
}
