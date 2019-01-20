public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static int FACTOR = 2;
    private int capacity = 8;



    public ArrayDeque(){
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    public void resize(int capacity){
        T[] temp = (T[]) new Object[capacity];
        System.arraycopy(items,0,temp,0,size);
        items =temp;
        nextFirst = capacity-1;
        nextLast =size;
    }

    public void addLast(T item){
        if (isEmpty()){
            items[0] = item;
            size ++;
            nextFirst = items.length-1;
        }else {
            if (size == items.length){
                resize(size*FACTOR);
            }
            items[nextLast]=item;
            nextLast++;
            size++;
            if (nextLast>items.length){
                if (items[0]!=null){
                    resize(size*FACTOR);
                }
                nextLast = size;
            }
        }
    }

    public void addFirst(T item){
        if (size == items.length){
            resize(size*FACTOR);
        }
        items[nextFirst] = item;
        size++;
        nextFirst--;
        if(nextFirst<0){
            if (items[items.length-1]!=null){
                resize(size*FACTOR);
            }
            nextFirst = items.length-1;
        }
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        if (nextFirst == items.length-1){
            nextFirst =-1;
        }
        nextFirst++;
        T temp = items[nextFirst];
        items[nextFirst]=null;
        size--;
        if (size>16 && size/items.length <0.25){
            shrink();
        }
        return temp;
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        if (nextLast ==0){
            nextLast=items.length;
        }
        nextLast--;
        T temp = items[nextLast];
        items[nextLast]=null;
        size--;
        if (size>16&&size/items.length<0.25){
            shrink();
        }
        return temp;
    }

    private void shrink() {
        int nullStartIndex = 0;
        int nullEndIndex = 0;
        for(int i = 0; i< items.length;i++) {
            if(items[i] == null) {
                nullStartIndex = i;
                break;
            }
        }
        for(int i = items.length-1;i>=0;i--) {
            if(items[i] == null) {
                nullEndIndex = i;
                break;
            }
        }
        int frontSize = nullStartIndex;
        int rearSize = (items.length-1) - nullEndIndex;
        for(int i = 0;i< rearSize;i++) {
            items[nullStartIndex+i] = items[nullEndIndex+i+1];
        }
        resize(frontSize+rearSize);
    }

   /* public T removeFirst(){
        return
    }*/

    public boolean isEmpty(){
        return size==0;
    }


    public T getLast(int index){
        if (index<size&&index>=0){
            return items[index];
        }
        return null;
    }

    public void printDeque(){
        for (int i=0;i<items.length;i++){
            System.out.println(items[i]+" ");
        }
    }

    public T get(int i){
        return items[i];
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        ArrayDeque A = new ArrayDeque();
        A.addLast('s');
        A.addLast(5);
        A.addLast("QWER");
        A.addFirst(100);
        A.addFirst(200);
        A.addFirst(300);
        A.addFirst(400);
        A.addFirst(500);
        A.addFirst("oversize");
        A.removeLast();
        A.removeFirst();
        A.printDeque();
    }
}
