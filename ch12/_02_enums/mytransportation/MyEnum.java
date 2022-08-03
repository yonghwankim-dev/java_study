package ch12._02_enums.mytransportation;

abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
    static int id = 0; // ��ü�� ���� �Ϸù�ȣ (0���� ����)

    int ordinal;
    String name = "";

    public int ordinal() {
        return ordinal;
    }

    public MyEnum(String name) {
        this.name = name;
        ordinal = id++; // ��ü�� �����Ҵ븶�� id�� ���� ������Ŵ
    }

    @Override
    public int compareTo(T t) {
        return ordinal - t.ordinal();
    }
}
