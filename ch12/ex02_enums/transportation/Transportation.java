package ch12.ex02_enums.transportation;

enum Transportation {
    BUS(100) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    TRAIN(150) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    SHIP(100) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    AIRPLANE(300) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };

    protected final int BASIC_FARE; // protected로 해야 각 상수에서 접근이 가능함

    Transportation(int BASIC_FARE) {
        this.BASIC_FARE = BASIC_FARE;
    }

    public int getBASIC_FARE() {
        return BASIC_FARE;
    }

    abstract int fare(int distance); // 거리에 따른 요금 계산

}
