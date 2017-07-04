package cs496.project1;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    void showQuiz() {
        // Add layout information here

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
            }
        }
        cursor.close();
        Random r = new Random(quizProblems.size());
        Random s = new Random(countries.length);

        for(int i = 0; i < 10; i++) {
            int position = r.nextInt();
            while (chosen.contains(position)) {
                position = r.nextInt();
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

            int wrongAnswer1 = s.nextInt();
            while (wrongAnswer1 == rightAnswer) {
                wrongAnswer1 = s.nextInt();
            }
            problem.setWrongAnswer1(countries[wrongAnswer1]);

            int wrongAnswer2 = s.nextInt();
            while (wrongAnswer2 == rightAnswer || wrongAnswer2 == wrongAnswer1) {
                wrongAnswer2 = s.nextInt();
            }
            problem.setWrongAnswer2(countries[wrongAnswer2]);

            int wrongAnswer3 = s.nextInt();
            while (wrongAnswer3 == rightAnswer || wrongAnswer3 == wrongAnswer1 || wrongAnswer3 == wrongAnswer2) {
                wrongAnswer3 = s.nextInt();
            }
            problem.setWrongAnswer3(countries[wrongAnswer3]);

            actualProblems[i] = problem;
        }

        //add information to adapter

    }

    void updateAnswer() {

    }


}
