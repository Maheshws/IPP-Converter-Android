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

public class PIPConverter extends Activity implements OnClickListener {
	Button Pre2Post;
	Button Pre2In;
	TextView tRes;
	EditText Exp;
	String Exps,Res;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pipcon);
        
        
        Pre2Post=(Button)findViewById(R.id.Pre2Post);
        Pre2In=(Button)findViewById(R.id.Pre2In);

        Exp=(EditText)findViewById(R.id.Exp);
        tRes=(TextView)findViewById(R.id.tRes);
        
        
        Pre2Post.setOnClickListener(this);
        Pre2In.setOnClickListener(this);
        
               
    }
	public void onClick(View v) {
		Exps=Exp.getText().toString();
		try{
		 switch (v.getId()){
		  case R.id.Pre2In:Pre2In();
			  break;
		  case R.id.Pre2Post:Pre2Post();
			  break;
		 }
   	 }
		catch(ArrayIndexOutOfBoundsException e){
			Intent i = new Intent(this, Error.class);
				i.putExtra("Message", "Invalid Prefix Expression\n(Array Index Out Of Bound Exception)");
				startActivity(i);
		}
		catch(StringIndexOutOfBoundsException e){
			Intent i = new Intent(this, Error.class);
			i.putExtra("Message", "Invalid Prefix Expression\n(String Index Out Of Bound Exception)");
			startActivity(i);
		}
		
	}

	public void Pre2In(){
		PrefixToInfix obj=new PrefixToInfix(Exps);
		Node r=obj.convert();
		Res=obj.inOrder(r);;
		tRes.setText(Res);
	}
	public void Pre2Post(){
		PrefixToInfix obj=new PrefixToInfix(Exps);
		Node r=obj.convert();
		Res=obj.postOrder(r);;
		tRes.setText(Res);
	}


}
class Node
{
  char data;
  Node left,right;
}

class StackPIP
{
  Node a[];
  int top;

public StackPIP()
{
  a=new Node[25];
  top=-1;
}


public void push(Node x)
{
  if(top==a.length-1){}
  else
   {
     top++;
     a[top]=x;
   }
}

public Node pop()
{
  Node t=a[top];
  top--;
  return t;
}

}

class PrefixToInfix
{
  String prefix;
  String Res;
public PrefixToInfix(String p)
   {
     prefix=p;
   }

public Node convert()
   {
     StackPIP s=new StackPIP();
     Res="";
     char x;
     int i,l;
     l=prefix.length();
     for(i=l-1;i>=0;i--)
      {
        x=prefix.charAt(i);
        Node newrec;
        
        if(x=='*'||x=='+'||x=='/'||x=='-'||x=='^')
          {
            Node op1=s.pop();
            Node op2=s.pop();
            newrec=new Node();
            newrec.data=x;
            newrec.left=op2;
            newrec.right=op1;
          }
        else
          {
            newrec=new Node();
            newrec.data=x;
            newrec.left=null;
            newrec.right=null;
          }
        s.push(newrec);
      }

    Node root=s.pop();
    return root;
   }

 public String inOrder(Node root)
   {
     if(root!=null)
      {
	    inOrder(root.right);
        Res=Res+root.data;
        inOrder(root.left);
       }
     return Res;
    }
	public String postOrder(Node root)
   {
     if(root!=null)
      {
         postOrder(root.right);
        postOrder(root.left);
        Res=Res+root.data;
	   }
     return Res;
    }
}
