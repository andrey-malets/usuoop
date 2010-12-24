#include <stack>
#include <iostream>
using namespace std;
class Caster{
private:
	stack <char> st;
public:
	Caster(){};
	~Caster(){};
void cast(string str){
	const char* a = str.c_str();
	cout<<a[5];
	char outstring[80];
	int k, point;
	k=point=0;
	while(a[k]!='\0'&&a[k]!='=')           
    {
      if(a[k]==')'){                                     
			while(st.top()!='('){    
				outstring[point++]=st.top();  
				st.pop();
			}
        st.pop();
      }
      if(a[k]>='0'&&a[k]<='9')        
          outstring[point++]=a[k];        
      if(a[k]=='(')                         
          st.push('(');
      if(a[k]=='+'||a[k]=='-'||a[k]=='/'||a[k]=='*')
      {                             
        if(st.empty())                     
            st.push(a[k]);        
        else                                 
			if(prior(st.top())<prior(a[k]))      
				st.push(a[k]);      
			else{
				while((!st.empty())&&(prior(st.top())>=prior(a[k]))){
					outstring[point++]=st.top();
					st.pop();
				}
          st.push(a[k]);           
        } 
      }
      k++;
	  std::cout<<"!";
    }	
	while(!st.empty()){           
        outstring[point++]=st.top();    
		st.pop();
	}
    outstring[point]='\0';                    
    printf("\n%s\n", outstring);            
}

int prior(char a)
{
  switch(a)
  {
    case '*': return 3;
    case '/':
         return 3;

    case '-': return 2;
    case '+': return 2;

    case '(':
         return 1;
  }
}

};