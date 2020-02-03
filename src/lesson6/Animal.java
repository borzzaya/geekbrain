package lesson6;

public class Animal {
    protected int limitRun = 0;
    protected float limitJump = 0;
    protected int limitSwim = 0;

    public void initLimit (int _limitRun, float _limitJump, int _limitSwim){
        limitRun = _limitRun;
        limitJump = _limitJump;
        limitSwim = _limitSwim;
    }
    public boolean run(int distance) {
        if (limitRun == 0) {
            return false;
        }

        if (distance > limitRun) {
            return false;
        }

        return true;
    }

    public boolean jump(float height) {
        if (limitJump == 0) {
            return false;
        }

        if (height > limitJump) {
            return false;
        }
        return true;
    }

    public boolean swim(int distance) {
        if (limitSwim == 0) {
            return false;
        }

        if (distance > limitSwim) {
            return false;
        }
        return true;
    }
}
