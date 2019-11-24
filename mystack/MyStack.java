package Practice.mystack;

public class MyStack implements Stack {

    private static final int START_INDEX = 0; // 배열의 시작 위치

    private String[] stackArray; // 값들을 담을 수 있는 배열
    private int currentIndex = START_INDEX; // 현재 배열의 인덱스 위치

    MyStack(int size) {
        stackArray = new String[size];
    }

    @Override
    public boolean isEmpty() {
        return currentIndex == 0;
    }

    @Override
    public boolean isNotEmpty() {
        return !isEmpty();
    }

    @Override
    public int capacity() { // 앞으로 저장 가능한 갯수 리턴
        return stackArray.length - currentIndex;
    }

    @Override
    public String pop() {
        final int topIndex = currentIndex-1;
        final String topValue = stackArray[topIndex]; // b
        stackArray[topIndex] = null;
        currentIndex--;
        return topValue;
    }

    @Override
    public void push(String val) {
//        if(currentIndex < stackArray.length) { // 넣을 수 있는 단계
//            // stackArray[currentIndex++] = val 로 해도 됨
//            insertValue(val);
//            return true;
//        } else { // 넣을 수 없는 단계
//            stackArrayResize();
//            insertValue(val);
//            return true;
//        }
        if(isNeedResize()) {
            stackArrayResize();
        }
        insertValue(val);
    }

    private boolean isNeedResize() {
        return !(currentIndex < stackArray.length);
    }

    private void stackArrayResize() {
        final int previousStackSize = stackArray.length;
        final int sizeOfResizingStack = previousStackSize * 2;
        String[] resizingStackArray = new String[sizeOfResizingStack];
        for(int i=0; i<previousStackSize; i++) {
            resizingStackArray[i] = stackArray[i];
        }
        stackArray = resizingStackArray;
    }

    private void insertValue(String val) {
        stackArray[currentIndex] = val;
        currentIndex++;
    }
}
