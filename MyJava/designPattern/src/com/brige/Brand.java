package com.brige;

public interface Brand{
    void scale();
}

class Lenovo implements Brand{

    @Override
    public void scale() {
	System.out.println("销售联想品牌");
    }
}
class Dell implements Brand{

    @Override
    public void scale() {
	System.out.println("销售戴尔品牌");
    }
}