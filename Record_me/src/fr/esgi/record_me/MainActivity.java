package fr.esgi.record_me;

import java.io.File;
import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.media.MediaRecorder;

public class MainActivity extends Activity {
  Button start_record;
  Button stop_record;
  AlertDialog message;
  private static final String AUDIO_RECORDER_FILE_EXT_3GP = ".3gp";
  private static final String AUDIO_RECORDER_FILE_EXT_MP4 = ".mp4";
  private static final String AUDIO_RECORDER_FOLDER = "AudioRecorder";
  private int currentFormat = 0;
  private MediaRecorder recorder=null;
  private int output_formats[] = { MediaRecorder.OutputFormat.MPEG_4,
			MediaRecorder.OutputFormat.THREE_GPP };
  private String file_exts[] = { AUDIO_RECORDER_FILE_EXT_MP4,
			AUDIO_RECORDER_FILE_EXT_3GP };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_record=(Button)findViewById(R.id.btn_start);
        stop_record=(Button) findViewById(R.id.btn_stop);
        start_record.setOnClickListener(action_start);
        stop_record.setOnClickListener(action_stop);
        message = new AlertDialog.Builder(this).create();
        

    }
private String getFilename() {
		String filepath = Environment.getExternalStorageDirectory().getPath();
		File file = new File(filepath, AUDIO_RECORDER_FOLDER);

		if (!file.exists()) {
			file.mkdirs();
		}

		return (file.getAbsolutePath() + "/" + System.currentTimeMillis() + file_exts[currentFormat]);
	}
private void startRecording() {
		recorder = new MediaRecorder();

		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		recorder.setOutputFormat(output_formats[currentFormat]);
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		recorder.setOutputFile(getFilename());

	//	recorder.setOnErrorListener(errorListener);
	//	recorder.setOnInfoListener(infoListener);

		try {
			recorder.prepare();
			recorder.start();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

View.OnClickListener action_start= new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startRecording();
	//	message.setTitle("start");
	//	message.setMessage("Button start record.");
	//	message.show();
		//recorder.setAudioEncoder(MediaRecorder.AudioSource.MIC);
		
	}
};

private void stopRecording() {
	if (null != recorder) {
		recorder.stop();
		recorder.reset();
		recorder.release();

		recorder = null;
	}
}

  View.OnClickListener action_stop=new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		stopRecording();
		
		//message.setTitle("stop");
		//message.setMessage("Button stop record.");
		//message.show();
	}
};  

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
