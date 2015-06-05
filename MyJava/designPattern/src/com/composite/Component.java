package com.composite;
/**
 * ���
 * @author YR
 *
 */
public interface Component {
    void operation();
}

//Ҷ�����
interface Leaf extends  Component{
    
}
/**
 * �������
 *
 */
interface Composite extends Component{
    Component add(Component c);
    Component remove(Component c);
    Component getChild(int index);
}