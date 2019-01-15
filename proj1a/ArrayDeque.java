public class ArrayDeque<T> {
    private int[] items;
    private int size;
    int head_pointer = 0;
    int tail_pointer = -1;



    public ArrayDeque(){
        items = new int[8];
        size = 0;
    }

    public void addLast(int item){
        items[size] = item;
        size = size+1;
        tail_pointer = tail_pointer +1;
    }

    public int removeLast(){
        int x =items[tail_pointer];
        items[tail_pointer] = 0;
        tail_pointer = tail_pointer -1;
        size = size-1;
        return x;
    }


    public int getLast(){
        return items[tail_pointer];
    }

    public int get(int i){
        return items[i];
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        ArrayDeque A = new ArrayDeque();
        A.addLast(5);
        A.addLast(6);
        A.addLast(8);
        A.addLast(10);
        A.addLast(50);
        System.out.println(A.getLast());
        A.removeLast();
        A.removeLast();
        System.out.println(A.getLast());
    }
}
