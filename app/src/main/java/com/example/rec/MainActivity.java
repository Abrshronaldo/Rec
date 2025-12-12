package com.example.rec;

import android.view.Window;
import androidx.core.content.ContextCompat;
import android.view.WindowManager;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import java.io.*;
import java.net.*;

import android.view.Gravity;
import android.widget.ImageView;

import android.graphics.Color;

import java.lang.reflect.Field;
import android.widget.Button;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.app.Activity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
public class MainActivity extends Activity {
       
 @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                                              
            getWindow().setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
    );                  
//yes
  

ConstraintLayout layout = new ConstraintLayout(this);

ConstraintLayout.LayoutParams Dparams = new ConstraintLayout.LayoutParams(
    ConstraintLayout.LayoutParams.MATCH_PARENT,
    ConstraintLayout.LayoutParams.WRAP_CONTENT
);


ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
    480,
    960
);
                                                                        
TextView tv = new TextView(this);
tv.setId(View.generateViewId());
  tv.setText("touch one of the box :first player is always X  ");
tv.setTextSize(15);
tv.setGravity(Gravity.CENTER);   // centers text inside the TextView
// Other options: Gravity.LEFT, Gravity.RIGHT, Gravity.TOP, Gravity.BOTTOM

Drawable bg = ContextCompat.getDrawable(this, R.drawable.rounded_layer);
// example tint
tv.setBackground(bg);
//tv.setBackgroundColor(Color.argb(255, 255, 255, 255));

// Constrain to top and left only
params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
params.topMargin=0;
// Now apply margins
params.leftMargin=0;  
params.bottomMargin=0;


params.rightMargin=0;
tv.setLayoutParams(params); 




ConstraintLayout.LayoutParams buttonParams = new ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
    );

    // Positioning: center in parent
    buttonParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
    buttonParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
    buttonParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;

    // Create the Button
    Button myButton = new Button(this);
    myButton.setId(View.generateViewId()); // Important for constraints
    myButton.setText("Click Me");

     buttonParams.topMargin=360; 

   

myButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
   



new Thread(() -> {
    try {
        Socket socket = new Socket("127.0.0.1", 8080);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Go");
        socket.close();

        runOnUiThread(() -> tv.setText("sent: "));


    runOnUiThread(() -> tv.setText("Server running on localhost:5000"));   >

        ServerSocket serverSocket = new ServerSocket(8080);
                Socket clientSocket = serverSocket.accept(); // blocks until >
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream())
                );


char[] buffer = new char[1024];
int len = in.read(buffer);
String message = new String(buffer, 0, len);

       if (message.equals("Go"){


                runOnUiThread(() -> tv.setText("it was all a dreeam"));
             }



                clientSocket.close();
                serverSocket.close();


    } catch (IOException e) {
        e.printStackTrace(); // or handle error
    }
}).start();



    }



});
    

     myButton.setLayoutParams(buttonParams);

    // Apply params and add to layout
    layout.addView(myButton);                                                                 

 
//layout.addView(lineview);




    layout.addView(tv);
                                         
        // Set layout as content view
        setContentView(layout);

  
        

}
}
