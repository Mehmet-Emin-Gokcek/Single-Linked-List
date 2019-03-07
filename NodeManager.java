//Create two methods, insert and delete , that allows new node to be inserted
//or deleted from any location in the linked list


public class NodeManager {

    Node head;
    Node tail;


    public void insert(String name){

       Node node = new Node(name);
        if(head == null) {
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            tail = node;
        }
    }

    private void insertHead(String name) {
        Node node = new Node(name);
        if (head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
        }
    }


   public void deleteNode(int position){
        if (head == null) {
            System.out.println("Empty List");
        }
        else if (position == 0) { //just remove the head
            head = head.next;
        }

        else {
            int counter = 0;
            Node currentNode = head;
            while (counter < position-1){ //must stop two positions before the indicated position to avoid the node that will soon-to-be-deleted

                currentNode = currentNode.next;
                if (currentNode.next == null) {
                    System.out.println("*** ERROR! Entered position (" + position + ") is out of List boundaries! ***");
                    System.out.println("Here is the untouched full list");
                    return;
                }
                counter++;
            }

            //at this point currentNode is the node before the targeted node
            currentNode.next = currentNode.next.next; //targeted node equals next node.This declaration essentially drops it from the list
        }
    }



    public void insertPosition(String name, int position){
        Node node = new Node(name);
        Node temp = head;

        if(position == 0) {
            head = node;
            node.next = temp;
            temp.prev = node;
        }

        else{
            int counter = 0;
            while(temp != null){

                if (counter == position-1) {
                    node.next =  temp.next;
                    temp.next = node;
                    break;
                }

                else if (temp.next == null){
                    temp.next = node;
                    break;

                }
                temp = temp.next;
                counter ++;
            }


        }
    }

    public void insertbyName(String search, String newValue){
        Node node = new Node(newValue);
        Node temp = head;
        while(temp != null){
            if (temp.name.equals(search)){
                if(temp.next == null){
                    temp.next = node;
                    return;
                }
                node.next =  temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }


    public void delete(String deleteNode){
        Node temp = head;
        Node prev = head;
        while(temp != null){
            if (head.name.equals(deleteNode)){ //deleteNode found in the head
                head = head.next;
                break;
            }

            else if (temp.name.equals(deleteNode)){
                prev.next = temp.next;
            }
            prev = temp;
            temp = temp.next;
        }
    }





    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.name);
            temp = temp.next;
        }
        System.out.println("------------------------------------");

    }



    public static void main(String[] args) {
        NodeManager nm = new NodeManager();
        nm.insertHead("Caleb");
        nm.insertHead("Meba");
        nm.insertHead("Mimi");
        nm.display();
        
        nm.insertPosition("Ali", 6);
        nm.display();
        
        nm.deleteNode(3);
        nm.display();

    }
}
