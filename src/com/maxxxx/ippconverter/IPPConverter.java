package com.maxxxx.ippconverter;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class IPPConverter extends Activity implements OnClickListener {
	Button In2Post;
	Button In2Pre;
	TextView tRes;
	EditText Exp;
	String Exps,Res;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ippcon);
        
        
        In2Post=(Button)findViewById(R.id.In2Post);
        In2Pre=(Button)findViewById(R.id.In2Pre);

        Exp=(EditText)findViewById(R.id.Exp);
        tRes=(TextView)findViewById(R.id.tRes);
        
        
        In2Post.setOnClickListener(this);
        In2Pre.setOnClickListener(this);
        
               
    }
	public void onClick(View v) {
		Exps=Exp.getText().toString();
		try{
		 switch (v.getId()){
		  case R.id.In2Pre:In2Pre();
			  break;
		  case R.id.In2Post:In2Post();
			  break;
		 }
 	 }
		catch(ArrayIndexOutOfBoundsException e){
			Intent i = new Intent(this, Error.class);
				i.putExtra("Message", "Invalid Infix Expression\n(Array Index Out Of Bound Exception)");
				startActivity(i);
		}
		catch(StringIndexOutOfBoundsException e){
			Intent i = new Intent(this, Error.class);
			i.putExtra("Message", "Invalid Infix Expression\n(String Index Out Of Bound Exception)");
			startActivity(i);
		}
	}
	public void In2Post(){
		InPostExp ipp=new InPostExp(Exps);
		Res=ipp.convert2Post();
		tRes.setText(Res);
		
	}
	public void In2Pre(){
		InPreExp ipp=new InPreExp(Exps);
		Res=ipp.convert2Pre();
		tRes.setText(Res);
		
	}
}

class StackIPP{
char a[];
int top;
StackIPP(){
a=new char [25];
top=-1;
}
void push(char x){
if(top==a.length-1)
System.out.println("Stack Overflow");
else{
top++;
a[top]=x;
}
}
boolean isEmpty(){
if(top==-1)
return true;
else
return false;
}
char pop(){
char x;
if(isEmpty())
return 0;
else
x=a[top];
top--;
return x;
}
char stackTop(){
char y=' ';
if(isEmpty()){
return 0;
}
else{
y=a[top];
}
return y;
}
}

class InPostExp{
	String exp;
	InPostExp(String x){
		exp=x;
	}
static int icp(char x){
int r=0;
switch (x){
case '^':r=5;break;
case '*':r=4;break;
case '/':r=4;break;
case '+':r=3;break;
case '-':r=3;break;
}
return r;
}
static int isp(char t){
int r=0;
switch (t){
case '^':r=5;break;
case '*':r=4;break;
case '/':r=4;break;
case '+':r=3;break;
case '-':r=3;break;
case '(':r=2;break;
case '~':r=1;break;
}
return r;
}

public String convert2Post(){
String p="";
StackIPP s=new StackIPP();
char x,t;
int l=exp.length();
int i=0;
s.push('~');
while(i!=l){
x=exp.charAt(i);
if(x=='(')
s.push(x);
else if(x==')'){
while(s.stackTop()!='('){
t=s.pop();
p=p+t;
}
t=s.pop();
}
else if (x=='^'||x=='+'||x=='-'||x=='*'||x=='/')
{
while(icp(x)<=isp(s.stackTop())){
t=s.pop();
p=p+t;
}
s.push(x);
}
else{
p=p+x;
}
i++;
}

while (s.stackTop()!='~'){
t=s.pop();
p=p+t;
}
t=s.pop();
return p;
}
}
class InPreExp{
	String exp;
	InPreExp(String x){
		exp=x;
	}
static int icp(char x){
int r=0;
switch (x){
case '^':r=5;break;
case '*':r=4;break;
case '/':r=4;break;
case '+':r=3;break;
case '-':r=3;break;
}
return r;
}
static int isp(char t){
int r=0;
switch (t){
case '^':r=5;break;
case '*':r=4;break;
case '/':r=4;break;
case '+':r=3;break;
case '-':r=3;break;
case ')':r=2;break;
case '~':r=1;break;
}
return r;
}

public String convert2Pre(){
String p="";
StackIPP s=new StackIPP();
char x,t;
int i=exp.length()-1;
s.push('~');
do{
x=exp.charAt(i);
if(x==')')
s.push(x);
else if(x=='('){
while(s.stackTop()!=')'){
t=s.pop();
p=t+p;
}
t=s.pop();
}
else if (x=='^'||x=='+'||x=='-'||x=='*'||x=='/')
{
while(icp(x)<isp(s.stackTop())){
t=s.pop();
p=t+p;
}
s.push(x);
}
else{
p=x+p;
}
i--;
}while(i!=-1);

while (s.stackTop()!='~'){
t=s.pop();
p=t+p;
}
t=s.pop();
return p;
}
}
