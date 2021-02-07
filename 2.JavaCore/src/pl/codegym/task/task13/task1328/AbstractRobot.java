package pl.codegym.task.task13.task1328;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractRobot implements CanAttack, CanDefend{
    private static int hitCount;

    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        int random = ThreadLocalRandom.current().nextInt(0, 3);
        hitCount = hitCount + random;

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
//            hitCount = 0;
            attackedBodyPart = BodyPart.LEG;
        } else if(hitCount == 4){
            attackedBodyPart = BodyPart.CHEST;
        } else {
            attackedBodyPart = BodyPart.CHEST;
            hitCount = 0;
        }
        return attackedBodyPart;
    }

    public BodyPart defend() {
        BodyPart defendedBodyPart = null;
        int random = ThreadLocalRandom.current().nextInt(0, 3);
        hitCount = hitCount + random;

        if (hitCount == 1) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            defendedBodyPart = BodyPart.ARM;
        } else if(hitCount == 4){
            defendedBodyPart = BodyPart.CHEST;
        } else {
            defendedBodyPart = BodyPart.CHEST;
            hitCount = 0;
        }
        return defendedBodyPart;
    }

}
