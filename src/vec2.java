public class vec2<T> {
    public T x,y;

    public vec2(T x, T y){
        this. x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return String.format("(%s,%s)",x,y);
    }
}
