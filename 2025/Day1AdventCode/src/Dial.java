public class Dial {
    private int degree;
    private int extravals;
    public Dial(int Startdegree){
        degree = Startdegree;
    }

    public void TurnRight(){
        degree++;
        if(degree == 100){
            degree = 0;
            extravals++;
        }
    }

    public void TurnLeft(){
        degree--;
        if (degree == 0){
            extravals++;
        }
        if(degree == -1){
            degree = 99;
        }
    }

    public void TurnLeftVal(int incr){
        for(int i = 0; i < incr; i++){
            TurnLeft();
        }
    }

    public void TurnRightVal(int incr){
        for(int i = 0; i < incr; i++){
            TurnRight();
        }
    }

    public int getDegree(){
        return degree;
    }

    public int getExtravals(){
        return extravals;
    }
}
