package ch12.ex02_enums.mytransportation;


abstract class MyTransportation extends MyEnum {
    static final MyTransportation BUS = new MyTransportation("BUS", 100) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };
    static final MyTransportation TRAIN = new MyTransportation("TRAIN", 150) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };
    static final MyTransportation SHIP = new MyTransportation("SHIP", 100) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };
    static final MyTransportation AIRPLANE = new MyTransportation("AIRPLANE", 300) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };


    abstract int fare(int distance); // 추상 메서드

    protected final int BASIC_FARE;

    private MyTransportation(String name, int basic_fare) {
        super(name);
        this.BASIC_FARE = basic_fare;
    }

    public String name() {
        return name;
    }

    public String toString() {
        return name;
    }
}
