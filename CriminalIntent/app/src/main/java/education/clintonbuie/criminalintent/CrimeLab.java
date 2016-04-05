package education.clintonbuie.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by clintonbuie on 3/22/16.
 */
public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) {

        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context ) {
        mCrimes = new ArrayList<Crime>();
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public List<Crime> getCrimes() {
        List<Crime> crimes = new ArrayList<Crime>();
        for (Crime crime : mCrimes) {
            if (!crime.isDeleted()) {
                crimes.add(crime);
            }
        }
        return crimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id) && !crime.isDeleted()) {
                return crime;
            }
        }
        return null;
    }
}
