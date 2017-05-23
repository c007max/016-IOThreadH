import java.util.Random;
import java.util.LinkedList;

public class IOProcess extends Thread
{
	int	ID ;
	Random	r1 =	new Random();
	private final PCB pcb;
	private final LinkedList<PCB> QReady ;
	
	public IOProcess	(PCB	pcb0
						,LinkedList<PCB> qr0
						)
	{
		this.pcb	= pcb0 ;
		this.QReady	= qr0 ;
	}
	
	public void run() 
	{
		pcb.set_state("Running");
		
		synchronized(this)
		{
			this.QReady.addLast(pcb);			
		}
				
		System.out.printf("** IOProcess start for ID: %d\n"	
				,pcb.get_ID()
				);
		
		try 
		{
			pcb.add_CPU_used(r1.nextInt(20)+10);
			Thread.sleep((r1.nextInt(500)+1000)) ;
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		System.out.printf("** IOProcess end for ID: %d\tCPU used: %d\n"
				,pcb.get_ID()
				,pcb.get_CPU_used()
				);
	}
}
