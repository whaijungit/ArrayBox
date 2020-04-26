/**
 *  ArrayBox
 */
public class ArrayBox <E> {
    //描述事物
    //属性
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;//长度一旦确定不能发生改变
    private int size = 0;//记录element长度

    //方法
    public ArrayBox(){
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public ArrayBox(int capacity){
        elementData = new Object[capacity];
    }
    /**
     * 信息检查 是否跟仓库相符
     * @
     * */
    private void rangeCheck(int index){
        if(index < 0 || index >= size){
            //不存在
            throw new BoxIndexOutOfBoundsException("Index : "+index+"  "+"Size : "+size);

        }
    }

    /**
     * 确保自己内部容量
     * @name ensureCapacityInternal
     * @param minCapacity
     */
    private void ensureCapacityInternal(int minCapacity){
        if (minCapacity - elementData.length > 0){
            //如果flase那么minCapacity不适合存储 但是程序是人性化的--扩容
            this.grow(minCapacity);
        }
    }

    /**
     * 解决数组长度不能更改 并是你理想的长度
     * @param minCapacity
     */
    private void grow(int minCapacity){
        //获取原来空间的长度
        int oldCapacity = elementData.length;
        //解决数组不能更改长度 --扩容1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1 );//位运算计算最快
        //按照这个算法扩容后，所需要的空间还不够，直接利用minCapacity
        if (newCapacity - minCapacity < 0){
            newCapacity = minCapacity;
        }
        //获取合理长度 最终得到一个合理的长度 newCapacity
        //按照这个新的长度 创建一个新空间 旧空间移入新空间中
        elementData = this.copyOf(elementData,newCapacity);
    }

    /**
     * 这个类就是解决数组长度
     * @param oldArray 原来数组长度
     * @param newCapacity 合理长度的数组
     * @return newArray[element]
     */
    private Object[] copyOf(Object[] oldArray,int newCapacity){
        //自己创建一个合理的长度的空间来存储 需要存放的element
        Object[] newArray = new Object[newCapacity];
        //
        for (int i = 0;i<oldArray.length; i++){
            newArray[i] = oldArray[i];
        }
        //把合理长度返回
        return newArray;
    }

    /**需要 设计一个方法 用来添加元素
     * 提供什么条件(参数)  返回一个结果(返回值)
     * 需要提供任意东西都行  告知这个方法的返回结果 能进去不能进去 boolean
     * @param element
    */
    public String add(E element){
        String ms = "";
        //确保我自己空间容量内部容量
        //存储到我自己的空间里面
        this.ensureCapacityInternal(size + 1);
        //上面代码行的通  -
        elementData[size++] = element;
        ms = "存储成功";
        System.out.println(ms);
        return ms;
    }

    /**
     * 设计一个方法 用来拿到自己存储的元素
     * @param index 存储元素的索引
     * @return element
     */
    public E get(int index){
        //首先拿到别人给你信息跟elementData里面有没有相符的 >=0 <=size
        this.rangeCheck(index);
        //index检验成功
        return (E)elementData[index];
    }
    /**
     * @param
     * @return
     * */
    public E remove(int index){
        this.rangeCheck(index);
        //没有异常 index可用
        //将index位置的旧值报错起来
        E oldValue = (E)elementData[index];
        //10 20 30 40 50 60 0 0 0 0-->有效元素
        //30数字删掉  box.remove(2)
        //10 20 40 50 60 0 0 0 0 --->只能覆盖
        for (int i = index; i < size - 1; i++){//i ==2 4
            elementData[i]=elementData[i+1];//index 开始 至size-1为止 将后面位置元素依次前移覆盖
            //10 20 40 50 60 60(循环结束这里变成0) 0 0 0 0
        }
        elementData[--size] = null;
        return (E)oldValue;

    }
    public int size(){
        return size;
    }
}
