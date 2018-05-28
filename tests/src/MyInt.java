public class MyInt {
    Integer value;

    public MyInt(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public MyInt increment(){
        value++;
        return this;
    }
}