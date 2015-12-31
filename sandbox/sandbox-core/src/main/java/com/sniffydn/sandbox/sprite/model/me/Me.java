package com.sniffydn.sandbox.sprite.model.me;

import com.sniffydn.sandbox.sprite.model.me.parts.Ankle;
import com.sniffydn.sandbox.sprite.model.me.parts.Arm;
import com.sniffydn.sandbox.sprite.model.me.parts.Back;
import com.sniffydn.sandbox.sprite.model.me.parts.Butt;
import com.sniffydn.sandbox.sprite.model.me.parts.Calf;
import com.sniffydn.sandbox.sprite.model.me.parts.Chest;
import com.sniffydn.sandbox.sprite.model.me.parts.Ear;
import com.sniffydn.sandbox.sprite.model.me.parts.Elbow;
import com.sniffydn.sandbox.sprite.model.me.parts.Foot;
import com.sniffydn.sandbox.sprite.model.me.parts.Forearm;
import com.sniffydn.sandbox.sprite.model.me.parts.Hair;
import com.sniffydn.sandbox.sprite.model.me.parts.Hand;
import com.sniffydn.sandbox.sprite.model.me.parts.Head;
import com.sniffydn.sandbox.sprite.model.me.parts.Hips;
import com.sniffydn.sandbox.sprite.model.me.parts.Knee;
import com.sniffydn.sandbox.sprite.model.me.parts.Mouth;
import com.sniffydn.sandbox.sprite.model.me.parts.Neck;
import com.sniffydn.sandbox.sprite.model.me.parts.Nose;
import com.sniffydn.sandbox.sprite.model.me.parts.Np;
import com.sniffydn.sandbox.sprite.model.me.parts.Pn;
import com.sniffydn.sandbox.sprite.model.me.parts.Sc;
import com.sniffydn.sandbox.sprite.model.me.parts.Shin;
import com.sniffydn.sandbox.sprite.model.me.parts.Shoulders;
import com.sniffydn.sandbox.sprite.model.me.parts.Stomach;
import com.sniffydn.sandbox.sprite.model.me.parts.Thigh;
import com.sniffydn.sandbox.sprite.model.me.parts.Wrist;
import java.util.ArrayList;
import java.util.List;

public class Me {

    private List<Part> parts = new ArrayList<>();
    private PState state = PState.STANDING;

    public Me() {
        Hair hair = new Hair();
        parts.add(hair);
        Head head = new Head();
        parts.add(head);
        Ear leftEar = new Ear("left ear");
        parts.add(leftEar);
        Ear rightEar = new Ear("right ear");
        parts.add(rightEar);
        Nose nose = new Nose();
        parts.add(nose);
        Mouth mouth = new Mouth();
        parts.add(mouth);
        Neck neck = new Neck();
        parts.add(neck);
        Shoulders shoulders = new Shoulders();
        parts.add(shoulders);
        Arm leftArm = new Arm("left arm");
        parts.add(leftArm);
        Arm rightArm = new Arm("right arm");
        parts.add(rightArm);
        Elbow leftElbow = new Elbow("left elbow");
        parts.add(leftElbow);
        Elbow rightElbow = new Elbow("right elbow");
        parts.add(rightElbow);
        Forearm leftForearm = new Forearm("left forearm");
        parts.add(leftForearm);
        Forearm rightForearm = new Forearm("right forearm");
        parts.add(rightForearm);
        Wrist leftWrist = new Wrist("left wrist");
        parts.add(leftWrist);
        Wrist rightWrist = new Wrist("right wrist");
        parts.add(rightWrist);
        Hand leftHand = new Hand("left hand");
        parts.add(leftHand);
        Hand rightHand = new Hand("right hand");
        parts.add(rightHand);
        Chest chest = new Chest();
        parts.add(chest);
        Np leftNp = new Np("left nipple");
        parts.add(leftNp);
        Np rightNp = new Np("right nipple");
        parts.add(rightNp);
        Stomach stomach = new Stomach();
        parts.add(stomach);
        Hips hips = new Hips();
        parts.add(hips);
        Back back = new Back();
        parts.add(back);
        Butt butt = new Butt();
        parts.add(butt);
        Sc sc = new Sc();
        parts.add(sc);
        Pn pn = new Pn();
        parts.add(pn);
        Thigh leftThigh = new Thigh("left thigh");
        parts.add(leftThigh);
        Thigh rightThigh = new Thigh("right thigh");
        parts.add(rightThigh);
        Knee leftKnee = new Knee("left knee");
        parts.add(leftKnee);
        Knee rightKnee = new Knee("right knee");
        parts.add(rightKnee);
        Calf leftCalf = new Calf("left calf");
        parts.add(leftCalf);
        Calf rightCalf = new Calf("right calf");
        parts.add(rightCalf);
        Shin leftShin = new Shin("left shin");
        parts.add(leftShin);
        Shin rightShin = new Shin("right shin");
        parts.add(rightShin);
        Ankle leftAnkle = new Ankle("left ankle");
        parts.add(leftAnkle);
        Ankle rightAnkle = new Ankle("right ankle");
        parts.add(rightAnkle);
        Foot leftFoot = new Foot("left foot");
        parts.add(leftFoot);
        Foot rightFoot = new Foot("right foot");
        parts.add(rightFoot);

        hair.getDown().add(head);

        head.getUp().add(hair);
        head.getAround().add(leftEar);
        head.getAround().add(rightEar);
        head.getAround().add(nose);
        head.getAround().add(mouth);
        leftEar.getAround().add(head);
        rightEar.getAround().add(head);
        nose.getAround().add(head);
        mouth.getAround().add(head);
        head.getDown().add(neck);

        neck.getUp().add(head);
        neck.getDown().add(shoulders);

        shoulders.getUp().add(neck);
        shoulders.getDown().add(leftArm);
        shoulders.getDown().add(rightArm);
        shoulders.getDown().add(back);
        shoulders.getDown().add(chest);

        leftArm.getUp().add(shoulders);
        rightArm.getUp().add(shoulders);
        leftArm.getDown().add(leftElbow);
        rightArm.getDown().add(rightElbow);

        leftElbow.getUp().add(leftArm);
        rightElbow.getUp().add(rightArm);
        leftElbow.getDown().add(leftForearm);
        rightElbow.getDown().add(rightForearm);

        leftForearm.getUp().add(leftElbow);
        rightForearm.getUp().add(rightElbow);
        leftForearm.getDown().add(leftWrist);
        rightForearm.getDown().add(rightWrist);

        leftWrist.getUp().add(leftForearm);
        rightWrist.getUp().add(rightForearm);
        leftWrist.getDown().add(leftHand);
        rightWrist.getDown().add(rightHand);

        leftHand.getUp().add(leftWrist);
        rightHand.getUp().add(rightWrist);

        back.getUp().add(shoulders);
        back.getAround().add(chest);
        back.getAround().add(stomach);
        back.getDown().add(butt);

        chest.getUp().add(shoulders);
        chest.getAround().add(back);
        chest.getAround().add(leftNp);
        chest.getAround().add(rightNp);
        leftNp.getAround().add(chest);
        rightNp.getAround().add(chest);
        chest.getDown().add(stomach);

        stomach.getAround().add(back);
        stomach.getUp().add(chest);
        stomach.getDown().add(hips);

        hips.getUp().add(stomach);
        hips.getAround().add(sc);
        hips.getAround().add(pn);
        sc.getAround().add(hips);
        sc.getDown().add(pn);
        pn.getUp().add(sc);
        hips.getAround().add(butt);
        hips.getDown().add(leftThigh);
        hips.getDown().add(rightThigh);

        butt.getUp().add(back);
        butt.getAround().add(hips);
        butt.getDown().add(leftThigh);
        butt.getDown().add(rightThigh);

        leftThigh.getUp().add(hips);
        rightThigh.getUp().add(hips);
        leftThigh.getUp().add(butt);
        rightThigh.getUp().add(butt);
        leftThigh.getDown().add(leftKnee);
        rightThigh.getDown().add(rightKnee);

        leftKnee.getUp().add(leftThigh);
        rightKnee.getUp().add(rightThigh);
        leftKnee.getDown().add(leftCalf);
        rightKnee.getDown().add(rightCalf);

        leftCalf.getUp().add(leftKnee);
        rightCalf.getUp().add(rightKnee);
        leftCalf.getDown().add(leftShin);
        rightCalf.getDown().add(rightShin);

        leftShin.getUp().add(leftCalf);
        rightShin.getUp().add(rightCalf);
        leftShin.getDown().add(leftAnkle);
        rightShin.getDown().add(rightAnkle);

        leftAnkle.getUp().add(leftShin);
        rightAnkle.getUp().add(rightShin);
        leftAnkle.getDown().add(leftFoot);
        rightAnkle.getDown().add(rightFoot);

        leftFoot.getUp().add(leftAnkle);
        rightFoot.getUp().add(rightAnkle);
    }

//    /**
//     * @return the parts
//     */
//    public List<Part> getParts() {
//        return parts;
//    }
    public Part pickAPart() {
        int index = (int) (Math.random() * parts.size());
        return parts.get(index);
    }

    /**
     * @return the state
     */
    public PState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(PState state) {
        this.state = state;
    }
}
