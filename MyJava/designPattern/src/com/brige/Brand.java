package com.brige;

public interface Brand{
    void scale();
}

class Lenovo implements Brand{

    @Override
    public void scale() {
	System.out.println("��������Ʒ��");
    }
}
class Dell implements Brand{

    @Override
    public void scale() {
	System.out.println("���۴���Ʒ��");
    }
}