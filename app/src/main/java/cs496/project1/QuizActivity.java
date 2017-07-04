package cs496.project1;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static android.icu.lang.UCharacter.toLowerCase;

public class QuizActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        showQuiz();



    }

    void showQuiz() {
        // Add layout information here
        GridView gridView;
        City2Adapter citiesAdapter;

        citiesAdapter = new City2Adapter();

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(citiesAdapter);

        String[] countries = {"Canada", "United States", "Greenland", "Argentina", "Bolivia", "Brazil", "Chile", "Peru", "Czech", "France", "Greece", "Italy", "Netherlands", "United Kingdom", "Algeria", "Ethiopia",
                "Egypt", "South Africa", "China", "Hong Kong", "Japan", "Russia", "South Korea", "Thailand", "Turkey", "UAE"};
        ArrayList<Integer> chosen = new ArrayList<>();
        ArrayList<QuizProblem> quizProblems = new ArrayList<>();
        QuizProblem actualProblems[] = new QuizProblem[10];
        Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
        String _ID = ContactsContract.Contacts._ID;
        String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
        String DATA = ContactsContract.CommonDataKinds.Email.DATA;
        String TYPE = ContactsContract.CommonDataKinds.Phone.TYPE;
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(CONTENT_URI, null, null, null, null);
        // Iterate every contact in the phone
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String contact_id = cursor.getString(cursor.getColumnIndex(_ID));
                String address;
                String name = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));

                //Address?
                Cursor addressCursor = contentResolver.query(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI, null, ContactsContract.Data.CONTACT_ID + "= ?",new String[]{contact_id},null);
                if (addressCursor.getCount() > 0) {
                    addressCursor.moveToNext();
                    address = addressCursor.getString(addressCursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS));
                    if (Arrays.asList(countries).contains(address)) {
                        QuizProblem problem = new QuizProblem();
                        problem.setName(name);
                        problem.setRightAnswer(address);
                        quizProblems.add(problem);
                    }
                }
                addressCursor.close();
            }
        }
        cursor.close();
        TextView questionTextView = (TextView) findViewById(R.id.question);
        TextView nameTextView = (TextView) findViewById(R.id.name);
        Random r = new Random();
        Random s = new Random();
        int numTotal = quizProblems.size();
        if (numTotal < 10) {
            nameTextView.setText("Not enough friends to play... (at least 10)");
            return;
        }
        int numCountry = countries.length;

        for(int i = 0; i < 10; i++) {
            int position = r.nextInt(numTotal);
            while (chosen.contains(position)) {
                position = r.nextInt(numTotal);
            }
            chosen.add(position);

            QuizProblem problem = quizProblems.get(position);
            String answer = problem.getRightAnswer();
            int rightAnswer = -1;
            for (int j = 0; j<countries.length;j++){
                if(countries[j] == answer) {
                    rightAnswer = j;
                    break;
                }
            }

            assert rightAnswer != -1;

            int wrongAnswer1 = s.nextInt(numCountry);
            while (wrongAnswer1 == rightAnswer) {
                wrongAnswer1 = s.nextInt(numCountry);
            }
            problem.setWrongAnswer1(countries[wrongAnswer1]);

            int wrongAnswer2 = s.nextInt(numCountry);
            while (wrongAnswer2 == rightAnswer || wrongAnswer2 == wrongAnswer1) {
                wrongAnswer2 = s.nextInt(numCountry);
            }
            problem.setWrongAnswer2(countries[wrongAnswer2]);

            int wrongAnswer3 = s.nextInt(numCountry);
            while (wrongAnswer3 == rightAnswer || wrongAnswer3 == wrongAnswer1 || wrongAnswer3 == wrongAnswer2) {
                wrongAnswer3 = s.nextInt(numCountry);
            }
            problem.setWrongAnswer3(countries[wrongAnswer3]);

            actualProblems[i] = problem;
        }

        nameTextView.setText(actualProblems[0].getName());
        questionTextView.setText("Where does this person live?");

        //add information to adapter
        Resources res = getResources();
        String formattedStr;
        int resID;
        Integer arr[] = {1,2,3,4};
        Collections.shuffle(Arrays.asList(arr));
        for(int i = 0; i<4; i++) {
            switch(arr[i]) {
                case 1:
                    String rightAnswer = actualProblems[0].getRightAnswer();
                    formattedStr = toLowerCase(rightAnswer.replaceAll("\\s",""));
                    Log.v("bloop",formattedStr);
                    resID = res.getIdentifier(formattedStr, "drawable", getPackageName());
                    citiesAdapter.addItem(ContextCompat.getDrawable(this, resID), rightAnswer);
                    break;
                case 2:
                    String wrongAnswer1 = actualProblems[0].getWrongAnswer1();
                    formattedStr = toLowerCase(wrongAnswer1.replaceAll("\\s",""));
                    Log.v("bloop",formattedStr);
                    resID = res.getIdentifier(formattedStr, "drawable", getPackageName());
                    citiesAdapter.addItem(ContextCompat.getDrawable(this, resID), wrongAnswer1);
                    break;
                case 3:
                    String wrongAnswer2 = actualProblems[0].getWrongAnswer2();
                    formattedStr = toLowerCase(wrongAnswer2.replaceAll("\\s",""));
                    Log.v("bloop",formattedStr);
                    resID = res.getIdentifier(formattedStr, "drawable", getPackageName());
                    citiesAdapter.addItem(ContextCompat.getDrawable(this, resID), wrongAnswer2);
                    break;
                case 4:
                    String wrongAnswer3 = actualProblems[0].getWrongAnswer3();
                    formattedStr = toLowerCase(wrongAnswer3.replaceAll("\\s",""));
                    Log.v("bloop",formattedStr);
                    resID = res.getIdentifier(formattedStr, "drawable", getPackageName());
                    citiesAdapter.addItem(ContextCompat.getDrawable(this, resID), wrongAnswer3);
                    break;
            }
        }
    }

    void updateAnswer() {

    }


}
