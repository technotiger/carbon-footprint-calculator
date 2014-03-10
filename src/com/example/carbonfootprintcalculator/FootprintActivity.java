package com.example.carbonfootprintcalculator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FootprintActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_footprint);
		
		TextView txtFP = (TextView) findViewById(R.id.txtFP);
		TextView txtFPLevel = (TextView) findViewById(R.id.txtFPLevel);
		Button btnReduce = (Button) findViewById(R.id.txtReduceFP);
		Button btnCredits = (Button) findViewById(R.id.btnCredits);
		
		Intent intent = getIntent();
		int fp = intent.getIntExtra("FootPrint", 0);
		txtFP.setText(""+fp);
		
		if (fp<6000){
			txtFPLevel.setText("Very Low");
			txtFPLevel.setTextColor(Color.GREEN);}
		else if (fp>=6000 && fp<16000){
			txtFPLevel.setText("Low");
			txtFPLevel.setTextColor(Color.GREEN);}			
		else if (fp>=16000 && fp<22000){
			txtFPLevel.setText("Average");
			txtFPLevel.setTextColor(Color.YELLOW);}		
		else if (fp>=22000){
			txtFPLevel.setText("High");
			txtFPLevel.setTextColor(Color.RED);} 
		
		btnReduce.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), TipsActivity.class);
				startActivity(intent);
			}
		});
		
		btnCredits.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), CreditsActivity.class);
				startActivity(intent);
			}
		});
	}
}
