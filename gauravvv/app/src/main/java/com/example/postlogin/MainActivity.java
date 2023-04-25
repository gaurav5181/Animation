package com.example.postlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2;
    Button btn1;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        btn1=findViewById(R.id.btn1);
        txt1=findViewById(R.id.signup);

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Ragister_Activity.class);
                startActivity(intent);

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = edt1.getText().toString();
                String password = edt2.getText().toString();

                if(!email.isEmpty() && !password.isEmpty()){

                    Retro.getInstance().retroApi.login(email,password).enqueue(new Callback<Model>() {
                        @Override
                        public void onResponse(Call<Model> call, Response<Model> response) {
                            if (response.body().getConnection()==1){

                                if(response.body().getResult()==1){

                                    Toast.makeText(MainActivity.this, "user login ", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this,Activity_2.class);
                                    startActivity(intent);

                                }



                            }


                        }

                        @Override
                        public void onFailure(Call<Model> call, Throwable t) {

                        }
                    });

                }

            }
        });
    }
}