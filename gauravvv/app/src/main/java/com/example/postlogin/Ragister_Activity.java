package com.example.postlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Ragister_Activity extends AppCompatActivity {

    EditText edt1,edt2,edt3;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragister);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        edt3=findViewById(R.id.edt3);
        btn1=findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt1.getText().toString();
                String email = edt2.getText().toString();
                String password = edt3.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){

                    Retro.getInstance().retroApi.ragister(name,email,password).enqueue(new Callback<Model>() {
                        @Override
                        public void onResponse(Call<Model> call, Response<Model> response) {

                            if(response.body().getConnection()==1){

                                if(response.body().getResult()==1){

                                    Toast.makeText(Ragister_Activity.this, "User ragister succesfully", Toast.LENGTH_SHORT).show();
                                    edt1.setText("");
                                    edt2.setText("");
                                    edt3.setText("");
                                } else if (response.body().getResult()==2) {

                                    Toast.makeText(Ragister_Activity.this, "user alredy exist", Toast.LENGTH_SHORT).show();

                                }else {

                                    Toast.makeText(Ragister_Activity.this, "Ragister faild", Toast.LENGTH_SHORT).show();
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