/*
第二题 没见过，有一个4-way stop的路口，4条lane， 给两个function getNextCar（）， arriveCar（Car car， Lane lane），
要求实现这两个方法。
就是生活中一个intersection有4个stop sign，然后看看哪条lane的车应该先走。理解完题只剩10min，
写了一会儿发现好烦，最后没时间了，说了下思路，还有好多核心code没写。。
估计挂了。。。
*/
class 4WayIntersection {
    public private int state;//initial state
    public static final EMPTY = 0;
    public static final VERTICAL = 1;
    public static final HORIZONTAL =2;

    public 4WayIntersection() {

    }

    private void nextState(int lane) {
        
    }
    public int getLaneNum() {
        if(state == VERTICAL) return 0;
        else return 1;
    }
}
