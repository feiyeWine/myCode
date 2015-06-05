package com.builder;

public class MyAirshipBuilder implements AirshipBuilder{

    @Override
    public Engine builderEngine() {
	System.out.println("�ҵķ�����");
	return new Engine("�ҵķ�����");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
	System.out.println("�ҵĹ����");
	return new OrbitalModule("�ҵĹ����");
    }

    @Override
    public EscapePod builderEscapePod() {
	System.out.println("�ҵ����ݲ�");
	return new EscapePod("�ҵ����ݲ�");
    }

}
