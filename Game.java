import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.List;
import java.util.*;
public class Game extends  JFrame implements ActionListener,MouseListener,KeyListener{	
 JMenuBar menubar;
 JMenu menu;
 JMenuItem item1,item2;
 JLabel lowestScore;
static  Credit first=null;
static Credit seconed=null; 
 int counter=0;
final int turnDownDelay=500 ;
Container c;
ArrayList<Credit>cr=new ArrayList<Credit>();
	Panel p1=new Panel();
	Panel p2=new Panel();
	Button b1,b2,b3,b4;
	JLabel l;
	JTextField t;
	public Game(){
		////////////////////////////////////THE FIRST PANEL//////////////////////////////
		super("SOLITER");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	c=getContentPane();
 	menubar=new JMenuBar();
 	add(menubar,BorderLayout.NORTH);
  	menubar.add(menu=new JMenu("Game"));
   menu.add(item1=new JMenuItem("NEW GAME"));
   	item1.addActionListener(this);
   	menu.add(item2=new JMenuItem("Exit"));
   	item2.addActionListener(this);
  	 p1.setLayout(new GridLayout(7,1));
	l=new JLabel("SCORE");
	l.setBackground(Color.LIGHT_GRAY);
	 t=new JTextField("0");
	 t.setEditable(false);
	 t.setBackground(Color.LIGHT_GRAY);
	b1=new Button("START");
	b1.setFocusable(false);
	b1.addActionListener(this);
	b1.setBackground(Color.pink);
    b2=new Button("SHUFFLE");
    b2.setFocusable(false);
	b2.addActionListener(this);
	b2.setBackground(Color.pink);
	b3=new Button("SORT");
	b3.setFocusable(false);
	b3.addActionListener(this);
	b3.setBackground(Color.pink);
	b4=new Button("HINT");
	b4.setFocusable(false);
	b4.addActionListener(this);
	b4.setBackground(Color.pink);
	lowestScore=new JLabel("Lowest Score is 30");
	lowestScore.setBackground(Color.LIGHT_GRAY);
	p1.add(lowestScore);
	p1.add(l);
	p1.add(t);
	p1.add(b1);
	p1.add(b2);
	p1.add(b3);
	p1.add(b4);
	add(p1,BorderLayout.EAST);
		//////////////////////////ADDING CREDIT//////////////////////////////////////////
	p2.setBackground(Color.GRAY);
  		p2.setLayout(new GridLayout(6,9));
	for(int i=0;i<=12;++i)	{
		cr.add(new Credit(i,"hearts","Red","heart/"+(i+1)+".PNG"));}
	for(int i=13;i<=25;++i)	{
		cr.add(new Credit(i-13,"diamonds","Red","diamonds/"+(i+1)+".PNG"));	}	 
	for(int i=26;i<=38;++i)	{
		cr.add(new Credit(i-26,"clubs","Black","clubs/"+(i+1)+".PNG"));}	
	for(int i=39;i<=51;++i)	{
         cr.add(new Credit(i-39,"spades","Black","spades/"+(i+1)+".PNG"));}
	cr.add(new Credit(52,"Black","joker/"+"53"+".PNG"));
	cr.add(new Credit(53,"Red","joker/"+"54"+".PNG"));
	/////////////////ADDING CREDIT//////////////////////////////
		Collections.shuffle(cr);
		for(Credit elem:cr)	{
			elem.addMouseListener(this)	;
			p2.add(elem);
	}
	////////////QAction//////////////////////////////////
setFocusable(true);
setFocusTraversalKeysEnabled(false);
addKeyListener(this);
add(p2,BorderLayout.CENTER);
setVisible(true);
setSize(1000,1000);}
		/////////////////////////////ACTION LISTENER////////////////////////////////////////
	public void actionPerformed(ActionEvent e){
			if(e.getSource()==b1){
			++counter;	
	p2.removeAll();
		for(Credit elem:cr){
			p2.add(elem);
			elem.setBackIcone();
		}
		validate();
		add(p2,BorderLayout.CENTER);
			}	
		////////////////////////////////////////////////////////////	
	if(e.getSource()==b2){ 
Collections.shuffle(cr)	;
p2.removeAll();
for(Credit elem:cr){
p2.add(elem);
}
validate();
add(p2,BorderLayout.CENTER);	
}	///////////////////////////////////////////////
if(e.getSource()==b3){
	p2.removeAll();
	List<Credit>list1=cr.subList(0,9);
	Collections.sort(list1,new card());
	for(Credit elem:list1)	
		p2.add(elem);
		/////////////////////////////////////////
			List<Credit>list2=cr.subList(9,18);
	Collections.sort(list2,new card());
	for(Credit elem:list2)	
		p2.add(elem);
		/////////////////////////////////
			List<Credit>list3=cr.subList(18,27);
	Collections.sort(list3,new card());
	for(Credit elem:list3)	
		p2.add(elem);
		///////////////////////////////////////////////
			List<Credit>list4=cr.subList(27,36);
	Collections.sort(list4,new card());
	for(Credit elem:list4)	
		p2.add(elem);
		///////////////////////////////////////////
			List<Credit>list5=cr.subList(36,45);
	Collections.sort(list5,new card());
	for(Credit elem:list5)	
		p2.add(elem);
		//////////////////////////////////////////////////
			List<Credit>list6=cr.subList(45,54);
	Collections.sort(list6,new card());
	for(Credit elem:list6)	
		p2.add(elem);
		validate();
		add(p2,BorderLayout.CENTER);
			
	}
	if(e.getSource()==item1)
		new Game();
			if(e.getSource()==item2)
				System.exit(0);
				////////////////////////////////////////////
				if(e.getSource()==b4)	{
 				 	if((first!=null)&&(seconed==null)){
 				 		for(Credit elem:cr){
 				 			if (elem.equals(first)&&(elem!=first)){
 				 				seconed=elem;
 				 				seconed.flip();
 				 				seconed.setBorder(BorderFactory.createLineBorder(Color.PINK,5));
 				 				seconed=elem;}}
 				 							Timer turnDownTimer2=new Timer(1000,new ActionListener(){
							public void actionPerformed(ActionEvent e)	{
								//System.out.println("IN TIMER");
								 seconed.setBorder(null);
	                           seconed.flip();
	                           //System.out.println("After Flipping");
	                           seconed=null;}
	                         
}
); 
 			
 				 			turnDownTimer2.start();
                            turnDownTimer2.setRepeats(false);
                 
                            
 				 	
 				 	}}}
					

	///////////////////////////MOUSE LISTENER/////////////////////////////////////////////////////	
public void mouseClicked(MouseEvent e){	
		int count=0;
		int result=0;
		if (counter>0){
		if((first==null)&&(seconed==null)){
			System.out.println("does Matching?");
               Toolkit.getDefaultToolkit().beep();
				first=((Credit)e.getSource());
				first.flip();
			first.setBorder(BorderFactory.createLineBorder(Color.PINK,5));
				
		}
			  else if((first!=null)&&(seconed==null)) {
			 	System.out.println("Are Matching:?");
				seconed=((Credit)e.getSource());
				seconed.setBorder(BorderFactory.createLineBorder(Color.PINK,5));
				seconed.flip();	
				}
				/////////////////////////////intisilization/////////////////////
				if((first!=null)&&(seconed!=null)){
					if(first==seconed){
						count=count+1;
						first.setBackIcone();
						seconed.setBackIcone();
						seconed.setBorder(null);
						
						first=null;
						seconed=null;
					}
				else if((first.getRank()==seconed.getRank())&&(first.getColor()==seconed.getColor()))
					{
					System.out.println("Matching");
					first.setEnabled(false);
  					seconed.setEnabled(false);
						first=null;
						seconed=null;
						}
					else if(((first.getRank()==52||(first.getRank()==53))&&((seconed.getRank()==53)||(seconed.getRank()==52)))){
						first.disable();
						seconed.disable();
							first=null;
						seconed=null;
						}
					else {
						count=count+1;
						Toolkit.getDefaultToolkit().beep();
							seconed.setBorder(null);
							first.setBorder(null);
						System.out.println("Not Matching");
						Timer turnDownTimer=new Timer(turnDownDelay,new ActionListener(){
							public void actionPerformed(ActionEvent e)	{
								System.out.println("IN TIMER");
	                              first.flip();
	                           seconed.flip();
	                           System.out.println("After Flipping");
	                           	first=null;
						 seconed=null;
	                         
}
						});  turnDownTimer.setRepeats(false);
						turnDownTimer.start();
					
			} result=Integer.parseInt(t.getText())+count;
			t.setText(Integer.toString(result));
			if (result==30){
				JOptionPane.showMessageDialog(null,"You Lose You Should Focus Harder");
					System.exit(0);

			}
				
				
				}}}
		
			

		
public  void mousePressed(MouseEvent e){
}
public void mouseReleased(MouseEvent e){
}
public void mouseEntered(MouseEvent e){
}
public void mouseExited(MouseEvent e){
}
/////////////////////////////////////KEYLISTENER///////////////////////////	
public void keyTyped(KeyEvent e){
}
	
public void keyReleased(KeyEvent e){
	}
public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_Q){
		for(Credit elem:cr)
			elem.flip();
	}
}	
}	

///////////////////////////////////////CREDIT CLASS///////////////////////////////////
class Credit extends JLabel implements Comparable<Credit>  {
int num=0;
private int Rank;
private	String Suit;
private String color;
String icon;
	private boolean turned;
	public Credit(){
	}
	public Credit(int Rank,String color,String icon){
		this.Rank=Rank;
		this.color=color;
		this.icon=icon;
		turned=true;
     	new JLabel();
 		setIcon(new ImageIcon(icon));
	}
	
	public Credit(int Rank,String Suit,String color,String icon){
		this.Rank=Rank;
		this.Suit=Suit;
		this.color=color;
		this.icon=icon;
		turned=true;
		 new JLabel();
		setIcon((new ImageIcon(icon)));
		}
		public void setRank(int Rank){
			this.Rank=Rank;
		}
		public void setColor(String color){
			this.color=color;
		}
		
		public String getColor(){
			return color;}
			
		public void setSuit(String Suit){
			this.Suit=Suit;
		}
		public int getRank(){
			return Rank;
		}
		public String getSuit(){
			return Suit;
		}
		public void setBackIcone(){
		setIcon(new ImageIcon("themes/coral reef.PNG"));
		turned=false;	
		}
		
		public void flip(){
			if(turned==true){
				setBackIcone();
				turned=false;}
				else{
				setIcon(new ImageIcon(this.icon));
				turned=true;}}
				
public int getNum(){
if(Rank==52)
num=-1;
if (Suit=="diamond")
num=1;
if (Suit=="clubs")
num=2;
if(Suit=="hearts")
num=3;
if(Suit=="spades")
num=4;
if(Rank==53)
num=5;
return num;
}
			
public int  compareTo(Credit c1){
	return this.getNum()-c1.getNum();
}


public boolean equals(Credit c){
	if(((c.getRank()==52)||(c.getRank()==53))&&((Rank==52)||(Rank==53)))
		return true;
	if((c.color==color)&&(c.Rank==Rank))
		return true;
		else
			return false;}
////////////////////MAIN///////////////////////////////////////////////////	
	public static void main (String[] args) {
		new Game();
}}
 class card implements Comparator<Credit>{
	public int compare(Credit c1,Credit c2){
	if(c1.compareTo(c2)!=0)
		return c1.getNum()-c2.getNum();			 
		else
		return c1.getRank()-c2.getRank();
			
	}}
	/*MADE BY :ASEEL RABAH SALEH ALSHORAFA.
	                    WARDA JAWAD TAHA SOBAIH.
	                    HEBA YEHYA MAHMOUD.
	                    */
	
