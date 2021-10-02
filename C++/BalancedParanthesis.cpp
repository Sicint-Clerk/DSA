#include <iostream>
#include<stack>

using namespace std;

void isBalanced(string s){
    stack<char> st ;
    int n= s.size() ;
    for(int i=0; i<n ; i++){
        if(s[i]=='{' or s[i]=='[' or s[i]=='(' ){
            st.push(s[i]);
        }
        else if(s[i]==')'){
            if(st.top()=='('){
                st.pop();
                continue ;
            }
            else {
                cout<<"Unbalanced Paranthesis" ;
                break ;
            }
        }
        else if(s[i]=='}'){
            if(st.top()=='{'){
                st.pop();
                continue ;
            }
            else {
                cout<<"Unbalanced Paranthesis" ;
                break ;
            }
        }
        else if(s[i]==']'){
            if(st.top()=='['){
                st.pop();
                continue ;
            }
            else {
                cout<<"Unbalanced Paranthesis" ;
                break ;
            }
        }
    }
    if(st.size()==0){
        cout<<"Balanced Paranthesis";
    }
    else{
    cout<<"Unbalanced Paranthesis";
    }
}



int main(){
    string s="{[()]}" ;
    isBalanced(s) ;
}

