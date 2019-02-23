package animations;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeInDown extends AnimationFX{

	/** 
	 * 
	 * Shout out to
	 Loïc Sculier aka typhon0
	 
	 for making the base of this animation code. It's %99 his work
	 **/
	
	Timeline someTimeline;
	
    public FadeInDown(Node node) {
        super(node);
    }

    public FadeInDown() {
    }

    @Override
    AnimationFX resetNode() {
        return this;
    }

    
    @Override
    void initTimeline() {
        setTimeline(new Timeline(
        		
                new KeyFrame(Duration.millis(50),
                        new KeyValue(getNode().opacityProperty(), 0, AnimateFXInterpolator.EASE),
                        new KeyValue(getNode().translateYProperty(), -getNode().getBoundsInParent().getHeight(), AnimateFXInterpolator.EASE)
                ),

                new KeyFrame(Duration.millis(1000),
                        new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE),
                        new KeyValue(getNode().translateYProperty(), 0, AnimateFXInterpolator.EASE)
                )
        ));
    }
}

