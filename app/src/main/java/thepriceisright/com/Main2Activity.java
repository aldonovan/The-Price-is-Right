package thepriceisright.com;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {
    ImageView topleft, top, topright, left, center, right, bottomleft, bottom, bottomright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        topleft = findViewById(R.id.topleft);
        top = findViewById(R.id.top);
        topright = findViewById(R.id.topright);
        left = findViewById(R.id.left);
        center = findViewById(R.id.center);
        right = findViewById(R.id.right);
        bottomleft = findViewById(R.id.bottomleft);
        bottom = findViewById(R.id.bottom);
        bottomright = findViewById(R.id.bottomright);

        FirebaseDatabase.getInstance().getReference().child("Image")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //if (dataSnapshot.getValue().toString().equals("Image"))
                        int count = 0;
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String encodedString = snapshot.getValue().toString();
                            byte[] decodedString = Base64.decode(encodedString, Base64.DEFAULT);
                            final Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                            count++;

                            if (count > 9) {
                                return;
                            }

                            ImageView curr = topleft;
                            if (count == 10) {
                                count = 1;
                            }

                            switch(count) {
                                case 1 : curr = topleft;
                                    break;
                                case 2: curr = top;
                                    break;
                                case 3: curr = topright;
                                    break;
                                case 4: curr = left;
                                    break;
                                case 5: curr = center;
                                    break;
                                case 6: curr = right;
                                    break;
                                case 7: curr = bottomleft;
                                    break;
                                case 8: curr = bottom;
                                    break;
                                case 9: curr = bottomright;
                                    break;
                            }

                            curr.setImageBitmap(decodedByte);
                            curr.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Main2Activity.this, GuessPriceActivity.class);
                                    intent.putExtra("Image", decodedByte);
                                    startActivity(intent);
                                }
                            });
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });


        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("images");
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                String s = dataSnapshot;
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("error", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        myRef.addValueEventListener(listener);*/

    }

    public void launchMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
