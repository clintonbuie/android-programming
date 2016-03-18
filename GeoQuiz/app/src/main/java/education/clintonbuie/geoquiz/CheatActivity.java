package education.clintonbuie.geoquiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CheatActivity extends AppCompatActivity {

    public static final String TAG = "CheatActivity";
    private static final String EXTRA_ANSWER_IS_TRUE = "com.clintonbuie.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.clintonbuie.geoquiz.answer_shown";
    private boolean mAnswerIsTrue;
    private boolean mAnswerShown = false;

    private TextView mAnswerTextView;
    private Button mShowAnswer;

    private TextView mBuildNumberTextView;

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN,false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState != null) {
            mAnswerShown = savedInstanceState.getBoolean(EXTRA_ANSWER_SHOWN);
            setAnswerShownResult(mAnswerShown);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
        mBuildNumberTextView = (TextView) findViewById(R.id.build_version_text_view);

        String sequence = "API Level " + (new Integer(Build.VERSION.SDK_INT)).toString();

        mBuildNumberTextView.setText(sequence);
        mShowAnswer = (Button) findViewById(R.id.show_answer_button);

        mShowAnswer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int cx = mShowAnswer.getWidth() / 2;
                    int cy = mShowAnswer.getHeight() / 2;

                    float radius = mShowAnswer.getWidth();

                    Animator anim = ViewAnimationUtils
                            .createCircularReveal(mShowAnswer, cx, cy, radius, 0);
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            mAnswerTextView.setVisibility(View.VISIBLE);
                            mShowAnswer.setVisibility(View.INVISIBLE);
                        }
                    });
                    anim.start();
                } else {
                    mAnswerTextView.setVisibility(View.VISIBLE);
                    mShowAnswer.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        mAnswerShown = isAnswerShown;
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putBoolean(EXTRA_ANSWER_SHOWN, mAnswerShown);
    }
}
