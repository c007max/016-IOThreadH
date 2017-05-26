import java.util.LinkedList;
import java.util.Iterator;
import java.util.Random;

public class IOThread_MAIN
{
	public static void main(String[] args) throws InterruptedException
	{
		int nodes_T	= 10 ;
		Random r1	= new Random();
		PCB	pcbRunning = null ;
		
		LinkedList<PCB> QReady	= new LinkedList<PCB>();
		
		for (int ii=0; ii<nodes_T; ii++)
		{
			QReady.addLast(new PCB());
		}
		
		T_IOProcess iop1	= new T_IOProcess(QReady);
		T_IOProcess iop2	= new T_IOProcess(QReady);
		T_IOProcess iop3	= new T_IOProcess(QReady);
	
//		while (!QReady.isEmpty())
//		{
//			System.out.printf("main: thread started %s %d %s\n"
//				,iop.getName()
//				,iop.getId()
//				,iop.getState()
//			);
//		}
		
		System.out.printf("\nmain: threads still running: %d\n\n"
				,Thread.activeCount()-1
				);
		
		for (PCB loopI : QReady)
			System.out.printf("main: %s\n"	,loopI.showPCB()) ;

		System.out.printf("\t***** done *****\n");
	}
}
