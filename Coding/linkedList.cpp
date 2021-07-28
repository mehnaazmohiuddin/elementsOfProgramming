#include <iostream>
using namespace std;
struct Node
{
	Node * next;
	int data;
};

void addNode(const Node **head, int i){
	Node * ptr = &head;
	while(ptr->next){
		ptr= ptr->next;
	}
	Node * newNode = new Node();
	ptr->next = newNode;
	newNode->next = NULL;
}
//[]
void addNodes(int *array, int size, Node **head)
	{
		Node * ptr = &head;
		while(ptr->next){
			ptr= ptr->next;
		}
		int i =0;
		while(size){
		Node * newNode = new Node();	
			newNode->data = array[i];
			ptr->next = newNode;
			ptr=newNode;
			ptr->next = NULL;
			i++;
			size--;
		}

	}
void nodeTraveller(Node * head);
{
	while(head)
		cout << head->data<<"->";
	
}
int main(){
	Node* node = new Node();
	node->data = 4;
	node->next = NULL;
	addNode(&node, 9);
	nodeTraveller(node);

}