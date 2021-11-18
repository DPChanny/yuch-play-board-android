package com.googleplaygames.dpc.yuch_play_board;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yodo1.mas.Yodo1Mas;
import com.yodo1.mas.error.Yodo1MasError;
import com.yodo1.mas.helper.model.Yodo1MasAdBuildConfig;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<ArrayList<YuchPiece>> yuchPieces = new ArrayList<>();

    private final Random random = new Random();
    private TextView result;

    private final int[] yuch_resource_ids =
            new int[] {
                R.drawable.t1yuch,
                R.drawable.t2yuch,
                R.drawable.t3yuch,
                R.drawable.t4yuch};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Yodo1MasAdBuildConfig config =
                new Yodo1MasAdBuildConfig.Builder().enableUserPrivacyDialog(true).build();
        Yodo1Mas.getInstance().setAdBuildConfig(config);

        Yodo1Mas.getInstance().init(this, "L3QFoZViBG", new Yodo1Mas.InitListener() {
            @Override
            public void onMasInitSuccessful() {

            }

            @Override
            public void onMasInitFailed(@NonNull Yodo1MasError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        result = findViewById(R.id.result);

        RelativeLayout layout = findViewById(R.id.board);

        for (int team = 0; team < 4; team++){
            yuchPieces.add(new ArrayList<>());
            for (int i = 0; i < 4; i++){
                yuchPieces.get(team).add(
                        new YuchPiece(
                            i * 125 + 25,
                            team * 125 + 25,
                            yuch_resource_ids[team],
                            getApplicationContext(),
                            layout));
            }
        }
    }

    public void OnThrow(View view){
        int rand = random.nextInt(32);
        if(rand < 8){
            result.setText("도");
        }else if(rand < 20){
            result.setText("개");
        }else if(rand < 28){
            result.setText("걸");
        }else if(rand < 30){
            result.setText("윷");
        }else{
            result.setText("모");
        }
        Toast.makeText(getApplicationContext(), "윷을 던졌습니다.",Toast.LENGTH_SHORT).show();
    }
}