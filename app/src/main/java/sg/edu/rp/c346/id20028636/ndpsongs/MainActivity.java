package sg.edu.rp.c346.id20028636.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView songTitle;
    EditText etSong;
    TextView singer;
    EditText etSinger;
    TextView year;
    EditText etYear;
    TextView star;
    RadioGroup rating;

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


    }
}