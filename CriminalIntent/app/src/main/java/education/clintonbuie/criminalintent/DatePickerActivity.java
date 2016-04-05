package education.clintonbuie.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by clintonbuie on 4/1/16.
 */
public class DatePickerActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new DatePickerFragment();
    }
}
