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

    }

    /**
     * @return the parts
     */
    public List<Part> getParts() {
        return parts;
    }
}
