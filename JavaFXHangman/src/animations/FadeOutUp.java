package animations;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

/** 
 * 
 * Shout out to
 Loïc Sculier aka typhon0
 
 for making the base of this animation code. It's %99 his work
 **/

public class FadeOutUp extends AnimationFX {

    public FadeOutUp(Node node) {
        super(node);
    }

    public FadeOutUp() {
    }

    @Override
    AnimationFX resetNode() {
        getNode().setOpacity(1);
        getNode().setTranslateY(0);
        return this;
    }

    @Override
    void initTimeline() {
        setTimeline(new Timeline(
                new KeyFrame(Duration.millis(0),
                        new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE),
                        new KeyValue(getNode().translateYProperty(), 0, AnimateFXInterpolator.EASE)

                ),
                new KeyFrame(Duration.millis(400),
                        new KeyValue(getNode().opacityProperty(), 0, AnimateFXInterpolator.EASE),
                        new KeyValue(getNode().translateYProperty(), -getNode().getBoundsInParent().getHeight() - 300, AnimateFXInterpolator.EASE)

                )
        ));
    }
}

