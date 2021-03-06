package com.vid.play;

import javax.swing.JFrame;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.DefaultAdaptiveRuntimeFullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.DefaultFullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class FullScreenStatergy extends DefaultFullScreenStrategy {

	public FullScreenStatergy(EmbeddedMediaPlayer mediaPlayer, PlayerControlsPanel controlsPanel, JFrame frame) {
		super(frame);
		setFullScreenStatergy(mediaPlayer, controlsPanel, frame);
	}

	private void setFullScreenStatergy(EmbeddedMediaPlayer mediaPlayer, PlayerControlsPanel controlsPanel,
			JFrame frame) {
		mediaPlayer.setFullScreenStrategy(new DefaultAdaptiveRuntimeFullScreenStrategy(frame) {

			@Override
			protected void beforeEnterFullScreen() {
				// TODO Auto-generated method stub
				controlsPanel.setVisible(false);
			}

			@Override
			protected void afterExitFullScreen() {
				// TODO Auto-generated method stub
				controlsPanel.setVisible(true);
			}
		});

	}

	public void toggleFullScreen(EmbeddedMediaPlayer mediaPlayer) {
		mediaPlayer.toggleFullScreen();
	}

	public void escapeFullScreen(EmbeddedMediaPlayer mediaPlayer) {
		if (mediaPlayer.isFullScreen())
			mediaPlayer.toggleFullScreen();
	}

}
