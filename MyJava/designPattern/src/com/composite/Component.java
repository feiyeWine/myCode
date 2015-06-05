package com.composite;
/**
 * 组件
 * @author YR
 *
 */
public interface Component {
    void operation();
}

//叶子组件
interface Leaf extends  Component{
    
}
/**
 * 容器组件
 *
 */
interface Composite extends Component{
    Component add(Component c);
    Component remove(Component c);
    Component getChild(int index);
}