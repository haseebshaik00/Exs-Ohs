package com.e.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int a=0;
    int i;
    ImageView c;
    boolean active = true;
    int[] state = {2,2,2,2,2,2,2,2,2};
    int[][] win = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void put(View view) {

        ImageView c = (ImageView) view;
        int tap = Integer.parseInt(c.getTag().toString());
        if (state[tap] == 2 && active == true)
        {
            state[tap]=a;
            if (a == 0)
                {
                c.setImageResource(R.drawable.yellow);
                c.setTranslationY(-1000f);
                c.animate().translationYBy(1000f).rotation(360).setDuration(300);
                a = 1;
                }
            else
                {
                c.setImageResource(R.drawable.red);
                c.setTranslationY(1000f);
                c.animate().translationYBy(-1000f).rotation(360).setDuration(300);
                a = 0;
                }
            for (int[] win1 : win)
                {
                    if (state[win1[0]] == state[win1[1]] && state[win1[1]] == state[win1[2]] && state[win1[0]]!=2 )
                    {
                        active = false;
                       String m = "";
                        if (state[win1[0]]==0)
                       {
                           m="Yellow";
                       }
                        else
                        {
                            m="Red";
                        }

                        TextView t2 = (TextView) findViewById(R.id.t2);
                        t2.setText(m+" has won!");
                        LinearLayout layout = (LinearLayout) findViewById(R.id.l1);
                        layout.setVisibility(View.VISIBLE);
                        layout.bringToFront();
                    }
                    else
                    {
                        boolean over = true;
                        for(int counter : state)
                        {
                            if(counter == 2) over= false;
                        }
                        if(over)
                        {
                            TextView t2 = (TextView) findViewById(R.id.t2);
                            t2.setText("It's a Draw!");
                            LinearLayout layout = (LinearLayout) findViewById(R.id.l1);
                            layout.setVisibility(View.VISIBLE);
                            layout.bringToFront();
                        }
                    }
                }
           }



    }

    public void playAgain (View view)
    {
        active = true;
        a=0;
        LinearLayout layout = (LinearLayout) findViewById(R.id.l1);
        layout.setVisibility(View.INVISIBLE);
        for (i=0;i<9;i++)
        {
            state[i]=2;
        }
        GridLayout g1 = (GridLayout) findViewById(R.id.g1);
        for(i=0;i<g1.getChildCount();i++)
        {
            ((ImageView) g1.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
