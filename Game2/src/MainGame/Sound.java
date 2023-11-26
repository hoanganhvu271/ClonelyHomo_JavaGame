package MainGame;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
	Clip clip;
	URL soundURL[] = new URL[30];
	FloatControl fc;
	float volumn ; 
	
	public Sound() {
//		soundURL[0] = getClass().getResource("/Sound/backsound.wav");
		soundURL[0] = getClass().getResource("/sound/backsound.wav");
		soundURL[1] = getClass().getResource("/sound/click.wav");
		soundURL[2] = getClass().getResource("/sound/jump.wav");
		soundURL[3] = getClass().getResource("/sound/gameover.wav");
		soundURL[4] = getClass().getResource("/sound/win.wav");
		soundURL[5] = getClass().getResource("/sound/cua_thang_may.wav");
	}
	
	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		}catch(Exception ex) {
			
		}
	}
	
	public void play() {
		clip.start();
		
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	
	public void stop() {
		
		clip.stop();

	}
	
	public void setVolumn(int volumnScale) {
		switch(volumnScale) {
			case 0:
				volumn = -80f;
				break;
			case 1:
				volumn = -5f;
				break;
			case 2:
				volumn = -20f;
				break;
				
		}
		
		fc.setValue(volumn);
	}
	
	
}
