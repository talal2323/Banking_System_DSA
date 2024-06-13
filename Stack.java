// StackNode class
class StackNode {
    String data;
    StackNode next;

    public StackNode(String data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class
class Stack {
    private StackNode top;

    public Stack() {
        this.top = null;
    }

    public void push(String data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

