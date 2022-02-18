package projectSem2;
//similar to specialLnkedList
class node
{
	double stn;
	String data;
	node next;
	node()
	{
		next=null;
	}
	node(String d,double p)
	{
		stn=p;
		data=d;
		next=null;
	}
}
public class stnNameFrmNo 
{
	node head;
	int size=0;
	stnNameFrmNo()
	{
		head=null;
	}
	stnNameFrmNo(String d,double p)
	{
		head=new node(d,p);
	}
	void insertStnIntoList(String d,double p)
	{
		node t=new node(d,p);
		if(head==null||p<head.stn)
		{
			
			t.next=head;
			head=t;
		}
		else
		{
			node temp=head;
			while((temp.next!=null)&&(temp.next.stn<=p))
			{
				temp=temp.next;
			}
			t.next=temp.next;
			temp.next=t;
		}
		size++;
	}
	String retStnNamne(double stn)
	{
		node t=this.head;
		String temp=null;
		while(t!=null)
		{
			if(t.stn==stn)
			{
				temp=t.data;
				return temp;
			}
			t=t.next;
		}
		return temp;
	}
	void insertStations()
	{
		this.insertStnIntoList("Mysore Road", 1);
		this.insertStnIntoList("Deepanjalinagar", 2);
		this.insertStnIntoList("Attiguppe", 3);
		this.insertStnIntoList("Vijayanagar",4);
		this.insertStnIntoList("Hosahalli",5);
		this.insertStnIntoList("Magadi Road",6);
		this.insertStnIntoList("City railway station", 7);
		this.insertStnIntoList("Majestic",8);
		this.insertStnIntoList("Sir M Visveshwaraya station",9);
		this.insertStnIntoList("Vidhana Sauda",10);
		this.insertStnIntoList("CUBBON PARK",11);
		this.insertStnIntoList("M G Road",12 );
		this.insertStnIntoList("Trinity", 13);
		this.insertStnIntoList("Halasuru", 14);
		this.insertStnIntoList("indiranagar", 15);
		this.insertStnIntoList("Swamy Vivekanada road", 16);
		this.insertStnIntoList("BAIYAPPANAHALLI", 17);
		this.insertStnIntoList("Nagasandra", 18);
		this.insertStnIntoList("Dasarahalli", 19);
		this.insertStnIntoList("Jalahalli", 20);
		this.insertStnIntoList("Peenya Industrial Area", 21);
		this.insertStnIntoList("Peenya", 22);
		this.insertStnIntoList("GORAGUNTEPALYA", 23);
		this.insertStnIntoList("YESHWANTHAPUR", 24);
		this.insertStnIntoList("SANDAL SOAP FACTORY", 25);
		this.insertStnIntoList("MAHALAKSHMI", 26);
		this.insertStnIntoList("RAJAJINAGAR", 27);
		this.insertStnIntoList("KUVEMPU", 28);
		this.insertStnIntoList("SRIRAMPURA", 29);
		this.insertStnIntoList("SAMPIGE ROAD", 30);
		this.insertStnIntoList("CHICKPETE", 31);
		this.insertStnIntoList("KRISHNA RAJENDRA MARKET", 32);
		this.insertStnIntoList("NATIONAL COLLEGE", 33);
		this.insertStnIntoList("LALBAGH", 34);
		this.insertStnIntoList("SOUTH END CIRCLE", 35);
		this.insertStnIntoList("JAYANAGAR",36);
		this.insertStnIntoList("RASHTREEYA VIDYALAYA ROAD", 37);
		this.insertStnIntoList("BANASHANKARI",38);
		this.insertStnIntoList("JAYAPRAKASH NAGAR",39);
		this.insertStnIntoList("YELACHANAHALLI",40);
	}

}
