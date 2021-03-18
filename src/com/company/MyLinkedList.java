package com.company;

public class MyLinkedList implements NodeList{
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null)
        {
            //List is empty
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while(currentItem != null)
        {
            int comparison =  (currentItem.compareTo(newItem));
            if(comparison<0)
            {
                //new Item is greater, move right if possible
                if(currentItem.next() != null)
                {
                    currentItem = currentItem.next();
                }
                else
                {
                    //there is no next i.e end of list
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            }
            else if(comparison > 0)
            {
                //new Item is less, insert before
                if(currentItem.previous()!=null)
                {
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                }
                else
                {
                    //if the node is without previous then it root
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            }
            else
            {
                System.out.println(newItem.getValue() + "is already present");
                return false;
            }

        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null)
            System.out.println("Deleting Item" + item.getValue());
        ListItem currentItem = this.root;
        while (currentItem!=null)
        {
            int comparison = currentItem.compareTo(item);
            if(comparison ==0)
            {
                if(currentItem == this.root)
                {
                    this.root = currentItem.next();
                }
                else
                {
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next()!=null)
                    {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            }
            else if(comparison<0)
            {
                currentItem = currentItem.next();
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null)
            System.out.println("This list is Empty");
        else
            while(root != null)
            {
                System.out.println(root.getValue());
                root = root.next();

            }
    }





}
