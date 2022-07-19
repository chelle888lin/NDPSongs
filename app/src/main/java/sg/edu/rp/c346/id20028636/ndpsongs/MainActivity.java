package sg.edu.rp.c346.id20028636.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView songTitle;
    EditText etSong;
    TextView singer;
    EditText etSinger;
    TextView year;
    EditText etYear;
    TextView star;
    RadioGroup rating;
    Button btnInsert;
    Button btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songTitle = findViewById(R.id.songTitle);
        etSong = findViewById(R.id.etSong);
        singer = findViewById(R.id.singers);
        etSinger = findViewById(R.id.etSingers);
        year = findViewById(R.id.year);
        etYear = findViewById(R.id.etYear);
        star = findViewById(R.id.stars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = etSong.getText().toString().trim();
                String singers = etSinger.getText().toString().trim();
                if (title.length() == 0 || singers.length() == 0){
                    Toast.makeText(MainActivity.this, "Incomplete data", Toast.LENGTH_SHORT).show();
                    return;
                }

                String year_str = etYear.getText().toString().trim();
                int year = Integer.valueOf(year_str);
                int stars = getStars();

                DBHelper dbh = new DBHelper(MainActivity.this);
                long result = dbh.insertSong(title, singers, year, stars);

                if (result != -1) {
                    Toast.makeText(MainActivity.this, "Song inserted", Toast.LENGTH_LONG).show();
                    etSong.setText("");
                    etSinger.setText("");
                    etYear.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Insert failed", Toast.LENGTH_LONG).show();
                }


            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

    }


    private int getStars() {
        int stars = 1;
        switch (rating.getCheckedRadioButtonId()) {
            case R.id.starOne:
                stars = 1;
                break;
            case R.id.starTwo:
                stars = 2;
                break;
            case R.id.starThree:
                stars = 3;
                break;
            case R.id.starFour:
                stars = 4;
                break;
            case R.id.starFive:
                stars = 5;
                break;
        }
        return stars;
    }
}