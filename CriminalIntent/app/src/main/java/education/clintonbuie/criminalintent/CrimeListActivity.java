package education.clintonbuie.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by clintonbuie on 3/22/16.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
