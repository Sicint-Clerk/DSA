#include<bits/stdc++.h>
using namespace std;

class node{
    public:
    int data;
    node *next;
    node(int data){
        this->data = data;
        this->next = NULL;
    }
};

node* insert_node(node *head, int data){
    node *new_node = new node(data);
    if(head == NULL){
        head = new_node;
        return head;
    }
    node *temp = head;
    while(temp->next != NULL){
        temp = temp->next;
    }
    temp->next = new_node;
    return head;
}

int main(){
    node *head = NULL;
    int data;
    while(cin >> data){
        head = insert_node(head, data);
    }
    node *temp = head;
    while(temp != NULL){
        cout << temp->data << " ";
        temp = temp->next;
    }
    return 0;
}
