package education.clintonbuie.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by clintonbuie on 3/22/16.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    private boolean mDeleted;

    public Crime() {
        this("",false);
    }

    public Crime(String title, Boolean solved) {
        mId = UUID.randomUUID();
        mDate = new Date();
        mTitle = title;
        mSolved = solved;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }


    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isDeleted() {
        return mDeleted;
    }

    public void setDeleted(boolean deleted) {
        mDeleted = deleted;
    }
}
