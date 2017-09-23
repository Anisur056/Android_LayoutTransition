package com.anisdroid.Android_LayoutTransition;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.animation.*;

public class MainActivity extends Activity 
{
	
	EditText in_txt;
	Button add_bt;
	LinearLayout my_lay;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		in_txt = (EditText) findViewById(R.id.input_txt);
		add_bt = (Button) findViewById(R.id.add_button);
		my_lay = (LinearLayout) findViewById(R.id.myLayout);
		
		add_bt.setOnClickListener(
			new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					
					LayoutInflater lif = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					final View addView = lif.inflate(R.layout.add_row,null);
					
					TextView out_txt = (TextView) addView.findViewById(R.id.output_txt);
					out_txt.setText(in_txt.getText().toString());
					
					Button rem = (Button) addView.findViewById(R.id.remove_button);
					
					rem.setOnClickListener(
						new View.OnClickListener(){

							@Override
							public void onClick(View p1)
							{
								// TODO: Implement this method
								
								((LinearLayout)addView.getParent()).removeView(addView);
								
							}
							
							
						}
					);
					
					my_lay.addView(addView,0);
					
				}
				
				
			}
		);
		
		LayoutTransition anim = new LayoutTransition();
		my_lay.setLayoutTransition(anim);
		
    }
}
