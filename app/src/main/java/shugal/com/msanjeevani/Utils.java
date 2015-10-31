package shugal.com.msanjeevani;

/**
 * Created by Deepinder on 10/24/2015.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yalantis
 */
public class Utils {
    public static final List<Friend> friends = new ArrayList<>();

    static {
        friends.add(new Friend(R.drawable.fortis_cover, "FORTIS",R.color.sienna,"Sector 62 ," +
                " Phase - VIII ,   Mohali","0172-4692222"));

        friends.add(new Friend(R.drawable.maxhospital, "MAX HOSPITAL",R.color.saffron,
                "Sector 56A , Phase - VI , Mohali","0172-6652000" ));

        friends.add(new Friend(R.drawable.pgi, "P G I",R.color.green,
                "Sector 12 , Chandigarh","0172-2746018" ));

        friends.add(new Friend(R.drawable.gmch32, "GMCH 32",R.color.pink,
                "Sector 32C , Chandigarh","0172-2601024" ));

        friends.add(new Friend(R.drawable.mukat, "MUKAT HOSPITAL",R.color.orange,
                "SCO 47-49 , Sector 34A , Chandigarh","0172-4344444" ));

        friends.add(new Friend(R.drawable.grewal, "GREWAL EYE CARE",R.color.purple,
                "SCO 168-169 , Sector 9C , Chandigarh","0172-5056969" ));


    }
}
